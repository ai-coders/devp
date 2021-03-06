package net.aicoder.speedcloud.console.business.speedcloud.pipeline.task.controller;

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
import net.aicoder.speedcloud.business.pipeline.task.dto.PipelineTaskActionTypeAddDto;
import net.aicoder.speedcloud.business.pipeline.task.dto.PipelineTaskActionTypeCondition;
import net.aicoder.speedcloud.business.pipeline.task.dto.PipelineTaskActionTypeEditDto;
import net.aicoder.speedcloud.business.pipeline.task.vo.PipelineTaskActionTypeVO;
import net.aicoder.speedcloud.console.business.speedcloud.pipeline.task.service.PipelineTaskActionTypeRibbonService;
import net.aicoder.speedcloud.console.business.speedcloud.pipeline.task.valid.PipelineTaskActionTypeValidator;
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
 * 管理操作类型
 * @author icode
 */
@Api(description = "操作类型", tags = "PipelineTaskActionType")
@RestController
@RequestMapping(value = "/speedcloud/pipeline/task/pipelinetaskactiontype")
public class PipelineTaskActionTypeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PipelineTaskActionTypeController.class);


	@Autowired
	private SaaSUtil saaSUtil;

	@Autowired
	private PipelineTaskActionTypeRibbonService pipelineTaskActionTypeRibbonService;

	@Autowired
	PipelineTaskActionTypeValidator pipelineTaskActionTypeValidator;


    @InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		webDataBinder.addValidators(pipelineTaskActionTypeValidator);
		webDataBinder.registerCustomEditor(Date.class, new DateConverter());
	}

	/**
	 * 新增操作类型
	 * @param pipelineTaskActionTypeAddDto
	 * @return
	 */
	@ApiOperation(value = "新增", notes = "新增操作类型", httpMethod = "POST")
	@PostMapping
	@ResponseStatus( HttpStatus.CREATED )
	@SaaSAnnotation
	public PipelineTaskActionTypeVO add(@RequestBody PipelineTaskActionTypeAddDto pipelineTaskActionTypeAddDto){
		return  pipelineTaskActionTypeRibbonService.add(pipelineTaskActionTypeAddDto);
	}

	/**
	 * 删除操作类型,id以逗号分隔
	 * @param idArray
	 */
	@ApiOperation(value = "删除", notes = "删除操作类型", httpMethod = "DELETE")
	@DeleteMapping(value="/{idArray}")
	public void delete(@PathVariable String idArray){

	    LOGGER.debug("delete pipelineTaskActionType :{}", idArray);

		String[] ids = idArray.split(",");
		for (String id : ids ){
			pipelineTaskActionTypeRibbonService.delete(Long.parseLong(id));
		}

	}

	/**
	 * 更新操作类型
	 * @param pipelineTaskActionTypeEditDto
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "修改", notes = "修改产操作类型(修改全部字段,未传入置空)", httpMethod = "PUT")
	@PutMapping(value="/{id}")
	public PipelineTaskActionTypeVO update(@RequestBody PipelineTaskActionTypeEditDto pipelineTaskActionTypeEditDto, @ApiParam(value = "要查询的操作类型id") @PathVariable Long id){

		PipelineTaskActionTypeVO vo = pipelineTaskActionTypeRibbonService.merge(id, pipelineTaskActionTypeEditDto);

		return  vo;
	}

	/**
	 * 根据ID查询操作类型
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "查询", notes = "根据ID查询操作类型", httpMethod = "GET")
	@GetMapping(value="/{id}")
	public PipelineTaskActionTypeVO get(@ApiParam(value = "要查询的操作类型id") @PathVariable Long id) {

		PipelineTaskActionTypeVO vo = pipelineTaskActionTypeRibbonService.find(id);
		return vo;
	}

	/**
	 * 查询操作类型列表
	 * @param pageSearchRequest
	 * @return
	 */
	@ApiOperation(value = "查询", notes = "根据条件查询操作类型列表", httpMethod = "POST")
	@PostMapping("/list") @SaaSAnnotation(conditionClass = PipelineTaskActionTypeCondition.class)
	public PageContent<PipelineTaskActionTypeVO> list(@RequestBody PageSearchRequest<PipelineTaskActionTypeCondition> pageSearchRequest){

		PageContent<PipelineTaskActionTypeVO> pageContent = pipelineTaskActionTypeRibbonService.list(pageSearchRequest);
		for(PipelineTaskActionTypeVO vo : pageContent.getContent()){
			initViewProperty(vo);
		}

		LOGGER.debug("page Size :{}, total:{}", pageContent.getContent().size() ,pageContent.getTotal());
		return pageContent;

	}

	/**
     * 导出操作类型列表
     * @param condition
     * @param response
     */
    @ApiOperation(value = "导出", notes = "根据条件导出操作类型列表", httpMethod = "POST")
    @RequestMapping("/export")
    public void export(PipelineTaskActionTypeCondition condition, HttpServletResponse response) throws UnsupportedEncodingException  {

        PageSearchRequest<PipelineTaskActionTypeCondition> pageSearchRequest = new PageSearchRequest<>();
        pageSearchRequest.setPage(0);
        pageSearchRequest.setLimit(Integer.MAX_VALUE);
        pageSearchRequest.setSearchCondition(condition);

        PageContent<PipelineTaskActionTypeVO> content = this.list(pageSearchRequest);

        List<PipelineTaskActionTypeVO> voList = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(content.getContent())){
            voList.addAll(content.getContent());
        }

        JSONArray jsonArray = new JSONArray();
        for(PipelineTaskActionTypeVO vo : voList){
            jsonArray.add(vo);
        }

        Map<String,String> headMap = new LinkedHashMap<String,String>();

    
            headMap.put("code" ,"类型代码");
            headMap.put("name" ,"类型名称");
            headMap.put("viewOrder" ,"展现顺序");
            headMap.put("memo" ,"说明");
            headMap.put("description" ,"描述");
            headMap.put("content" ,"脚本内容");

        String title = new String("操作类型");
        String fileName = new String(("操作类型_"+ DateFormatUtils.ISO_8601_EXTENDED_TIME_FORMAT.format(new Date())).getBytes("UTF-8"), "ISO-8859-1");
        ExcelUtil.downloadExcelFile(title, headMap, jsonArray, response, fileName);

    }


	private PipelineTaskActionTypeVO initViewProperty( PipelineTaskActionTypeVO vo){

	   


	   
        return vo;

	}


}
