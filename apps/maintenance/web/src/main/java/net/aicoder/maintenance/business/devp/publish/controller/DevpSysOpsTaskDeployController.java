package net.aicoder.maintenance.business.devp.publish.controller;

import com.alibaba.fastjson.JSONArray;
import com.yunkang.saas.common.framework.spring.DateConverter;
import com.yunkang.saas.common.framework.web.controller.PageContent;
import com.yunkang.saas.common.framework.web.data.PageSearchRequest;
import com.yunkang.saas.common.framework.web.ExcelUtil;
import com.yunkang.saas.bootstrap.application.business.security.SaaSUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.aicoder.devp.business.publish.dto.DevpSysOpsTaskDeployCondition;
import net.aicoder.devp.business.publish.dto.DevpSysOpsTaskDeployAddDto;
import net.aicoder.devp.business.publish.dto.DevpSysOpsTaskDeployEditDto;
import net.aicoder.devp.business.publish.vo.DevpSysOpsTaskDeployVO;
import net.aicoder.maintenance.business.devp.publish.service.DevpSysOpsTaskDeployRibbonService;
import net.aicoder.maintenance.business.devp.publish.valid.DevpSysOpsTaskDeployValidator;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.WebDataBinder;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * 管理组件部署设置
 * @author icode
 */
@Api(description = "组件部署设置", tags = "DevpSysOpsTaskDeploy")
@RestController
@RequestMapping(value = "/publish/devpSysOpsTaskDeploy")
public class DevpSysOpsTaskDeployController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DevpSysOpsTaskDeployController.class);


	@Autowired
	private SaaSUtil saaSUtil;

	@Autowired
	private DevpSysOpsTaskDeployRibbonService devpSysOpsTaskDeployRibbonService;

	@Autowired
	DevpSysOpsTaskDeployValidator devpSysOpsTaskDeployValidator;


    @InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		webDataBinder.addValidators(devpSysOpsTaskDeployValidator);
		webDataBinder.registerCustomEditor(Date.class, new DateConverter());
	}

	/**
	 * 新增组件部署设置
	 * @param devpSysOpsTaskDeployAddDto
	 * @return
	 */
	@ApiOperation(value = "新增", notes = "新增组件部署设置", httpMethod = "POST")
	@PostMapping
	@ResponseStatus( HttpStatus.CREATED )
	public DevpSysOpsTaskDeployVO add(@RequestBody DevpSysOpsTaskDeployAddDto devpSysOpsTaskDeployAddDto){
		devpSysOpsTaskDeployAddDto.setTid(saaSUtil.getAccount().getTid());
		return  devpSysOpsTaskDeployRibbonService.add(devpSysOpsTaskDeployAddDto);
	}

	/**
	 * 删除组件部署设置,id以逗号分隔
	 * @param idArray
	 */
	@ApiOperation(value = "删除", notes = "删除组件部署设置", httpMethod = "DELETE")
	@DeleteMapping(value="/{idArray}")
	public void delete(@PathVariable String idArray){

	    LOGGER.debug("delete devpSysOpsTaskDeploy :{}", idArray);

		String[] ids = idArray.split(",");
		for (String id : ids ){
			devpSysOpsTaskDeployRibbonService.delete(Long.parseLong(id));
		}

	}

	/**
	 * 更新组件部署设置
	 * @param devpSysOpsTaskDeployEditDto
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "修改", notes = "修改产组件部署设置(修改全部字段,未传入置空)", httpMethod = "PUT")
	@PutMapping(value="/{id}")
	public DevpSysOpsTaskDeployVO update(@RequestBody DevpSysOpsTaskDeployEditDto devpSysOpsTaskDeployEditDto, @ApiParam(value = "要查询的组件部署设置id") @PathVariable Long id){

		DevpSysOpsTaskDeployVO vo = devpSysOpsTaskDeployRibbonService.merge(id, devpSysOpsTaskDeployEditDto);

		return  vo;
	}

	/**
	 * 根据ID查询组件部署设置
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "查询", notes = "根据ID查询组件部署设置", httpMethod = "GET")
	@GetMapping(value="/{id}")
	public DevpSysOpsTaskDeployVO get(@ApiParam(value = "要查询的组件部署设置id") @PathVariable Long id) {

		DevpSysOpsTaskDeployVO vo = devpSysOpsTaskDeployRibbonService.find(id);
		return vo;
	}

	/**
	 * 查询组件部署设置列表
	 * @param pageSearchRequest
	 * @return
	 */
	@ApiOperation(value = "查询", notes = "根据条件查询组件部署设置列表", httpMethod = "POST")
	@PostMapping("/list")
	public PageContent<DevpSysOpsTaskDeployVO> list(@RequestBody PageSearchRequest<DevpSysOpsTaskDeployCondition> pageSearchRequest){

		DevpSysOpsTaskDeployCondition condition = pageSearchRequest.getSearchCondition();
		if(condition==null){
			condition = new DevpSysOpsTaskDeployCondition();
			pageSearchRequest.setSearchCondition(condition);
		}
		pageSearchRequest.getSearchCondition().setTid(saaSUtil.getAccount().getTid());
		PageContent<DevpSysOpsTaskDeployVO> pageContent = devpSysOpsTaskDeployRibbonService.list(pageSearchRequest);
		for(DevpSysOpsTaskDeployVO vo : pageContent.getContent()){
			initViewProperty(vo);
		}

		LOGGER.debug("page Size :{}, total:{}", pageContent.getContent().size() ,pageContent.getTotal());
		return pageContent;

	}

	/**
     * 导出组件部署设置列表
     * @param condition
     * @param response
     */
    @ApiOperation(value = "导出", notes = "根据条件导出组件部署设置列表", httpMethod = "POST")
    @RequestMapping("/export")
    public void export(DevpSysOpsTaskDeployCondition condition, HttpServletResponse response) throws UnsupportedEncodingException  {

        PageSearchRequest<DevpSysOpsTaskDeployCondition> pageSearchRequest = new PageSearchRequest<>();
        pageSearchRequest.setPage(0);
        pageSearchRequest.setLimit(Integer.MAX_VALUE);
        pageSearchRequest.setSearchCondition(condition);

        PageContent<DevpSysOpsTaskDeployVO> content = this.list(pageSearchRequest);

        List<DevpSysOpsTaskDeployVO> voList = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(content.getContent())){
            voList.addAll(content.getContent());
        }

        JSONArray jsonArray = new JSONArray();
        for(DevpSysOpsTaskDeployVO vo : voList){
            jsonArray.add(vo);
        }

        Map<String,String> headMap = new LinkedHashMap<String,String>();

    
            headMap.put("tid" ,"租户编号");
            headMap.put("etype" ,"元素类型");
            headMap.put("name" ,"系统元素名称");
            headMap.put("code" ,"系统元素代码");
            headMap.put("alias" ,"系统元素别名");
            headMap.put("description" ,"系统元素描述");
            headMap.put("recordState" ,"记录状态");
            headMap.put("type" ,"类型");
            headMap.put("subType" ,"子类型");
            headMap.put("deployPath" ,"部署路径");
            headMap.put("backupPath" ,"备份路径");
            headMap.put("preAction" ,"部署前操作");
            headMap.put("deployAction" ,"部署操作");
            headMap.put("postAction" ,"部署后操作");
            headMap.put("status" ,"状态");
            headMap.put("notes" ,"备注");
            headMap.put("prdRid" ,"产品编号");
            headMap.put("schemeRid" ,"部署方案编号");
            headMap.put("cmpRid" ,"组件编号");
            headMap.put("taskRid" ,"任务编号");
            headMap.put("seq" ,"顺序号");
            headMap.put("createUcode" ,"创建用户代码");
            headMap.put("createUname" ,"创建用户姓名");
            headMap.put("modifyUcode" ,"修改用户代码");
            headMap.put("modifyUname" ,"修改用户姓名");

        String title = new String("组件部署设置");
        String fileName = new String(("组件部署设置_"+ DateFormatUtils.ISO_8601_EXTENDED_TIME_FORMAT.format(new Date())).getBytes("UTF-8"), "ISO-8859-1");
        ExcelUtil.downloadExcelFile(title, headMap, jsonArray, response, fileName);

    }


	private DevpSysOpsTaskDeployVO initViewProperty( DevpSysOpsTaskDeployVO vo){

	   


	   
        return vo;

	}


}
