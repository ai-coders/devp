package com.yunkang.saas.platform.manage.business.platform.resource.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunkang.saas.bootstrap.application.business.resource.domain.Resource;
import com.yunkang.saas.bootstrap.application.business.resource.dto.ResourceCondition;
import com.yunkang.saas.bootstrap.application.business.resource.service.ResourceService;
import com.yunkang.saas.bootstrap.application.business.resource.service.ResourceUtil;
import com.yunkang.saas.bootstrap.application.business.resource.vo.ResourceTreeNode;
import com.yunkang.saas.bootstrap.application.business.resource.vo.ResourceVO;
import com.yunkang.saas.bootstrap.platform.business.application.domain.App;
import com.yunkang.saas.bootstrap.platform.business.application.service.AppService;
import com.yunkang.saas.bootstrap.platform.business.application.vo.AppVO;
import com.yunkang.saas.common.framework.web.controller.PageContent;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 管理资源
 * @author icode
 */
@RestController
@RequestMapping(value = "/platform/security/resource")
public class ResourceManageController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ResourceManageController.class);

	@Autowired
	private ResourceService resourceService;

	@Autowired
	private AppService appService;



	/**
	 * Method getChildNodes.
	 * @param node String
	 * @param id int
	 * @return ResponseEntity<String>
	 */
	@RequestMapping(params = "method=getChildNodes", headers="Accept=application/xml, application/json")
	public @ResponseBody
	List<ResourceTreeNode> getChildNodes(
			@RequestParam(required=false,value="node") String node,
			@RequestParam(required=false,value="id",defaultValue = "-1") Long id
	){

		if(-1L == id){
			return findAppNode();
		}


		//先查询父节点
		Resource parentResource = resourceService.find(id);

		List<ResourceTreeNode> resourceTreeNodes = getResourceTreeNodes(parentResource);

		return resourceTreeNodes;
	}

	private List<ResourceTreeNode> getResourceTreeNodes(Resource parentResource) {
		ResourceCondition condition = new ResourceCondition();
		condition.setParentCode(parentResource.getCode());
		condition.setAppCode(parentResource.getAppCode());

		List<Resource> resourceList = resourceService.findAll(condition);
		LOGGER.info(resourceList.toString());

		List<ResourceTreeNode> resourceTreeNodes = new ArrayList<>();
		if(resourceList!=null){
			for(Resource resource:resourceList){
				ResourceVO vo = new ResourceVO();
				BeanUtils.copyProperties(resource, vo);
				resourceTreeNodes.add(new ResourceTreeNode(vo));
			}
		}
		return resourceTreeNodes;
	}

	@RequestMapping("/tree")
	public PageContent<ResourceTreeNode> tree(
			@RequestParam(required=false, value="condition") String condition ){

		ObjectMapper objectMapper = new ObjectMapper();

		ResourceCondition searchCondition = null;
		if(StringUtils.isNotEmpty(condition)){
			try {
				searchCondition = objectMapper.readValue(condition, ResourceCondition.class);
			} catch (IOException e) {
				LOGGER.error("convert searchCondition error,condition:("+condition+")", e);
			}
		}

		List<Resource> resourcePage = resourceService.findAll(searchCondition);
		PageContent<ResourceTreeNode> pageContent = new PageContent<>(ResourceUtil.convert(resourcePage), resourcePage.size());

		return pageContent;

	}


	/**
	 * 查询APP并转换成ResourceTreeNode
	 * @return
	 */
	private List<ResourceTreeNode> findAppNode(){
		/*
		 * 1.茶渣所有APP
		 * 2.查找每个APP的定级节点
		 */


		List<ResourceTreeNode> result = new ArrayList<>();
		List<App> appList = appService.findAll(null);

		for(App app : appList){
			AppVO appVO = new AppVO();
			BeanUtils.copyProperties(app, appVO);
			ResourceTreeNode resourceTreeNode = new ResourceTreeNode(appVO);
			List<ResourceVO> children = new ArrayList<>();
			CollectionUtils.addAll(children, this.findTopNodeForApp(app));
			resourceTreeNode.setChildren(children);
			result.add(resourceTreeNode);

		}

		return result;
	}

	private List<ResourceTreeNode> findTopNodeForApp(App app){

		Resource parentResource = new Resource();
		parentResource.setCode(-1L);
		parentResource.setAppCode(app.getCode());
		return this.getResourceTreeNodes(parentResource);

	}

}
