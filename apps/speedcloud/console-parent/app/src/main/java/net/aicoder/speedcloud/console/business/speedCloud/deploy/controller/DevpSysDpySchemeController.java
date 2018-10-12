package net.aicoder.speedcloud.console.business.speedCloud.deploy.controller;

import com.alibaba.fastjson.JSONArray;
import com.yunkang.saas.bootstrap.application.business.security.SaaSUtil;
import com.yunkang.saas.common.framework.spring.DateConverter;
import com.yunkang.saas.common.framework.web.controller.PageContent;
import com.yunkang.saas.common.framework.web.data.PageRequest;
import com.yunkang.saas.common.framework.web.data.PageSearchRequest;
import com.yunkang.saas.common.framework.web.ExcelUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.aicoder.speedcloud.business.deploy.dto.DevpSysDpySchemeCondition;
import net.aicoder.speedcloud.business.deploy.dto.DevpSysDpySchemeAddDto;
import net.aicoder.speedcloud.business.deploy.dto.DevpSysDpySchemeEditDto;
import net.aicoder.speedcloud.business.deploy.vo.DevpSysDpySchemeVO;
import net.aicoder.speedcloud.console.business.speedCloud.deploy.service.DevpSysDpySchemeRibbonService;
import net.aicoder.speedcloud.console.business.speedCloud.deploy.valid.DevpSysDpySchemeValidator;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.WebDataBinder;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * 管理部署方案
 * @author icode
 */
@Api(description = "部署方案", tags = "DevpSysDpyScheme")
@RestController
@RequestMapping(value = "/speedcloud/deploy/devpsysdpyscheme")
public class DevpSysDpySchemeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DevpSysDpySchemeController.class);


	@Autowired
	private SaaSUtil saaSUtil;

	@Autowired
	private DevpSysDpySchemeRibbonService devpSysDpySchemeRibbonService;

	@Autowired
	DevpSysDpySchemeValidator devpSysDpySchemeValidator;


    @InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		webDataBinder.addValidators(devpSysDpySchemeValidator);
		webDataBinder.registerCustomEditor(Date.class, new DateConverter());
	}

	/**
	 * 新增部署方案
	 * @param devpSysDpySchemeAddDto
	 * @return
	 */
	@ApiOperation(value = "新增", notes = "新增部署方案", httpMethod = "POST")
	@PostMapping
	@ResponseStatus( HttpStatus.CREATED )
	public DevpSysDpySchemeVO add(@RequestBody DevpSysDpySchemeAddDto devpSysDpySchemeAddDto){
    	devpSysDpySchemeAddDto.setTid(saaSUtil.getAccount().getTenantId());
		return  devpSysDpySchemeRibbonService.add(devpSysDpySchemeAddDto);
	}

	/**
	 * 删除部署方案,id以逗号分隔
	 * @param idArray
	 */
	@ApiOperation(value = "删除", notes = "删除部署方案", httpMethod = "DELETE")
	@DeleteMapping(value="/{idArray}")
	public void delete(@PathVariable String idArray){

	    LOGGER.debug("delete devpSysDpyScheme :{}", idArray);

		String[] ids = idArray.split(",");
		for (String id : ids ){
			devpSysDpySchemeRibbonService.delete(Long.parseLong(id));
		}

	}

	/**
	 * 更新部署方案
	 * @param devpSysDpySchemeEditDto
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "修改", notes = "修改产部署方案(修改全部字段,未传入置空)", httpMethod = "PUT")
	@PutMapping(value="/{id}")
	public DevpSysDpySchemeVO update(@RequestBody DevpSysDpySchemeEditDto devpSysDpySchemeEditDto, @ApiParam(value = "要查询的部署方案id") @PathVariable Long id){

		DevpSysDpySchemeVO vo = devpSysDpySchemeRibbonService.merge(id, devpSysDpySchemeEditDto);

		return  vo;
	}

	/**
	 * 根据ID查询部署方案
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "查询", notes = "根据ID查询部署方案", httpMethod = "GET")
	@GetMapping(value="/{id}")
	public DevpSysDpySchemeVO get(@ApiParam(value = "要查询的部署方案id") @PathVariable Long id) {

		DevpSysDpySchemeVO vo = devpSysDpySchemeRibbonService.find(id);
		return vo;
	}

	/**
	 * 查询部署方案列表
	 * @param pageSearchRequest
	 * @return
	 */
	@ApiOperation(value = "查询", notes = "根据条件查询部署方案列表", httpMethod = "POST")
	@PostMapping("/list")
	public PageContent<DevpSysDpySchemeVO> list(@RequestBody PageSearchRequest<DevpSysDpySchemeCondition> pageSearchRequest){

		DevpSysDpySchemeCondition condition = pageSearchRequest.getSearchCondition();
		if(condition==null){
			condition = new DevpSysDpySchemeCondition();
			pageSearchRequest.setSearchCondition(condition);
		}
        pageSearchRequest.getSearchCondition().setTid(saaSUtil.getAccount().getTenantId());
		PageContent<DevpSysDpySchemeVO> pageContent = devpSysDpySchemeRibbonService.list(pageSearchRequest);
		for(DevpSysDpySchemeVO vo : pageContent.getContent()){
			initViewProperty(vo);
		}

		LOGGER.debug("page Size :{}, total:{}", pageContent.getContent().size() ,pageContent.getTotal());
		return pageContent;

	}

	/**
     * 导出部署方案列表
     * @param condition
     * @param response
     */
    @ApiOperation(value = "导出", notes = "根据条件导出部署方案列表", httpMethod = "POST")
    @RequestMapping("/export")
    public void export(DevpSysDpySchemeCondition condition, HttpServletResponse response) throws UnsupportedEncodingException  {

        PageSearchRequest<DevpSysDpySchemeCondition> pageSearchRequest = new PageSearchRequest<>();
        pageSearchRequest.setPage(0);
        pageSearchRequest.setLimit(Integer.MAX_VALUE);
        pageSearchRequest.setSearchCondition(condition);

        PageContent<DevpSysDpySchemeVO> content = this.list(pageSearchRequest);

        List<DevpSysDpySchemeVO> voList = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(content.getContent())){
            voList.addAll(content.getContent());
        }

        JSONArray jsonArray = new JSONArray();
        for(DevpSysDpySchemeVO vo : voList){
            jsonArray.add(vo);
        }

        Map<String,String> headMap = new LinkedHashMap<String,String>();

    
            headMap.put("name" ,"方案名称");
            headMap.put("code" ,"方案代码");
            headMap.put("alias" ,"方案别名");
            headMap.put("description" ,"方案描述");
            headMap.put("type" ,"方案类型");
            headMap.put("status" ,"已生效");
            headMap.put("notes" ,"备注");
            headMap.put("project" ,"所属项目（产品）");
            headMap.put("env" ,"所属环境");

        String title = new String("部署方案");
        String fileName = new String(("部署方案_"+ DateFormatUtils.ISO_8601_EXTENDED_TIME_FORMAT.format(new Date())).getBytes("UTF-8"), "ISO-8859-1");
        ExcelUtil.downloadExcelFile(title, headMap, jsonArray, response, fileName);

    }


	private DevpSysDpySchemeVO initViewProperty( DevpSysDpySchemeVO vo){

	   


	   
        return vo;

	}


}
