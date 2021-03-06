package net.aicoder.speedcloud.console.business.speedcloud.deployscheme.controller;

import com.alibaba.fastjson.JSONArray;
import com.yunkang.saas.bootstrap.application.business.annotation.SaaSAnnotation;
import com.yunkang.saas.bootstrap.application.business.security.SaaSUtil;
import com.yunkang.saas.common.framework.spring.DateConverter;
import com.yunkang.saas.common.framework.web.ExcelUtil;
import com.yunkang.saas.common.framework.web.controller.PageContent;
import com.yunkang.saas.common.framework.web.data.PageSearchRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.aicoder.speedcloud.business.deployscheme.dto.ResourceAddDto;
import net.aicoder.speedcloud.business.deployscheme.dto.ResourceCondition;
import net.aicoder.speedcloud.business.deployscheme.dto.ResourceEditDto;
import net.aicoder.speedcloud.business.deployscheme.vo.ResourceVO;
import net.aicoder.speedcloud.console.business.speedcloud.deployscheme.service.ResourceRibbonService;
import net.aicoder.speedcloud.console.business.speedcloud.deployscheme.valid.ResourceValidator;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * 管理方案资源
 * @author icode
 */
@Api(description = "方案资源", tags = "Resource")
@RestController("speedcloudDeploySchemeResource")
@RequestMapping(value = "/speedcloud/deployscheme/resource")
public class ResourceController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ResourceController.class);


	@Autowired
	private SaaSUtil saaSUtil;

	@Autowired
	private ResourceRibbonService resourceRibbonService;

	@Autowired
	ResourceValidator resourceValidator;


    @InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		webDataBinder.addValidators(resourceValidator);
		webDataBinder.registerCustomEditor(Date.class, new DateConverter());
	}

	/**
	 * 新增方案资源
	 * @param resourceAddDto
	 * @return
	 */
	@ApiOperation(value = "新增", notes = "新增方案资源", httpMethod = "POST")
	@PostMapping
	@ResponseStatus( HttpStatus.CREATED )
	@SaaSAnnotation
	public ResourceVO add(@RequestBody ResourceAddDto resourceAddDto){
    	return  resourceRibbonService.add(resourceAddDto);
	}

	/**
	 * 删除方案资源,id以逗号分隔
	 * @param idArray
	 */
	@ApiOperation(value = "删除", notes = "删除方案资源", httpMethod = "DELETE")
	@DeleteMapping(value="/{idArray}")
	public void delete(@PathVariable String idArray){

	    LOGGER.debug("delete resource :{}", idArray);

		String[] ids = idArray.split(",");
		for (String id : ids ){
			resourceRibbonService.delete(Long.parseLong(id));
		}

	}

	/**
	 * 更新方案资源
	 * @param resourceEditDto
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "修改", notes = "修改产方案资源(修改全部字段,未传入置空)", httpMethod = "PUT")
	@PutMapping(value="/{id}")
	public ResourceVO update(@RequestBody ResourceEditDto resourceEditDto, @ApiParam(value = "要查询的方案资源id") @PathVariable Long id){

		ResourceVO vo = resourceRibbonService.merge(id, resourceEditDto);

		return  vo;
	}

	/**
	 * 根据ID查询方案资源
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "查询", notes = "根据ID查询方案资源", httpMethod = "GET")
	@GetMapping(value="/{id}")
	public ResourceVO get(@ApiParam(value = "要查询的方案资源id") @PathVariable Long id) {

		ResourceVO vo = resourceRibbonService.find(id);
		return vo;
	}

	/**
	 * 查询方案资源列表
	 * @param pageSearchRequest
	 * @return
	 */
	@ApiOperation(value = "查询", notes = "根据条件查询方案资源列表", httpMethod = "POST")
	@PostMapping("/list") @SaaSAnnotation(conditionClass = ResourceCondition.class)
	public PageContent<ResourceVO> list(@RequestBody PageSearchRequest<ResourceCondition> pageSearchRequest){

		PageContent<ResourceVO> pageContent = resourceRibbonService.list(pageSearchRequest);
		for(ResourceVO vo : pageContent.getContent()){
			initViewProperty(vo);
		}

		LOGGER.debug("page Size :{}, total:{}", pageContent.getContent().size() ,pageContent.getTotal());
		return pageContent;

	}

	/**
     * 导出方案资源列表
     * @param condition
     * @param response
     */
    @ApiOperation(value = "导出", notes = "根据条件导出方案资源列表", httpMethod = "POST")
    @RequestMapping("/export")
    public void export(ResourceCondition condition, HttpServletResponse response) throws UnsupportedEncodingException  {

        PageSearchRequest<ResourceCondition> pageSearchRequest = new PageSearchRequest<>();
        pageSearchRequest.setPage(0);
        pageSearchRequest.setLimit(Integer.MAX_VALUE);
        pageSearchRequest.setSearchCondition(condition);

        PageContent<ResourceVO> content = this.list(pageSearchRequest);

        List<ResourceVO> voList = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(content.getContent())){
            voList.addAll(content.getContent());
        }

        JSONArray jsonArray = new JSONArray();
        for(ResourceVO vo : voList){
            jsonArray.add(vo);
        }

        Map<String,String> headMap = new LinkedHashMap<String,String>();

    
            headMap.put("name" ,"资源名称");
            headMap.put("code" ,"资源代码");
            headMap.put("alias" ,"资源别名");
            headMap.put("category" ,"资源类别");
            headMap.put("type" ,"资源类型");
            headMap.put("notes" ,"备注");
            headMap.put("description" ,"资源描述");
            headMap.put("version" ,"版本");
            headMap.put("seq" ,"顺序号");
            headMap.put("evn" ,"所属环境");
            headMap.put("project" ,"产品编号");
            headMap.put("outerResource" ,"外部资源");
            headMap.put("scheme" ,"所属方案");

        String title = new String("方案资源");
        String fileName = new String(("方案资源_"+ DateFormatUtils.ISO_8601_EXTENDED_TIME_FORMAT.format(new Date())).getBytes("UTF-8"), "ISO-8859-1");
        ExcelUtil.downloadExcelFile(title, headMap, jsonArray, response, fileName);

    }


	private ResourceVO initViewProperty( ResourceVO vo){

	   


	   
        return vo;

	}


}
