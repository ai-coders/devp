package net.aicoder.speedcloud.console.business.speedCloud.pipeline.controller;

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
import net.aicoder.speedcloud.business.pipeline.dto.PipelineStageNodeCondition;
import net.aicoder.speedcloud.business.pipeline.dto.PipelineStageNodeAddDto;
import net.aicoder.speedcloud.business.pipeline.dto.PipelineStageNodeEditDto;
import net.aicoder.speedcloud.business.pipeline.vo.PipelineStageNodeVO;
import net.aicoder.speedcloud.console.business.speedCloud.pipeline.service.PipelineStageNodeRibbonService;
import net.aicoder.speedcloud.console.business.speedCloud.pipeline.valid.PipelineStageNodeValidator;
import com.yunkang.saas.bootstrap.common.business.simpleconfig.domain.SimpleConfig;
import com.yunkang.saas.bootstrap.common.business.simpleconfig.service.SimpleConfigService;
import com.yunkang.saas.bootstrap.common.business.simpleconfig.vo.SimpleConfigVO;

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
 * 管理阶段执行节点
 * @author icode
 */
@Api(description = "阶段执行节点", tags = "PipelineStageNode")
@RestController
@RequestMapping(value = "/speedcloud/pipeline/pipelinestagenode")
public class PipelineStageNodeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PipelineStageNodeController.class);


	@Autowired
	private SaaSUtil saaSUtil;

	@Autowired
	private PipelineStageNodeRibbonService pipelineStageNodeRibbonService;

	@Autowired
	PipelineStageNodeValidator pipelineStageNodeValidator;

    @Autowired
    private SimpleConfigService simpleConfigService;

    @InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		webDataBinder.addValidators(pipelineStageNodeValidator);
		webDataBinder.registerCustomEditor(Date.class, new DateConverter());
	}

	/**
	 * 根据ID查询阶段执行节点
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "查询", notes = "根据ID查询阶段执行节点", httpMethod = "GET")
	@GetMapping(value="/{id}")
	public PipelineStageNodeVO get(@ApiParam(value = "要查询的阶段执行节点id") @PathVariable Long id) {

		PipelineStageNodeVO vo = pipelineStageNodeRibbonService.find(id);
		return vo;
	}

	/**
	 * 查询阶段执行节点列表
	 * @param pageSearchRequest
	 * @return
	 */
	@ApiOperation(value = "查询", notes = "根据条件查询阶段执行节点列表", httpMethod = "POST")
	@PostMapping("/list")
	public PageContent<PipelineStageNodeVO> list(@RequestBody PageSearchRequest<PipelineStageNodeCondition> pageSearchRequest){

		PipelineStageNodeCondition condition = pageSearchRequest.getSearchCondition();
		if(condition==null){
			condition = new PipelineStageNodeCondition();
			pageSearchRequest.setSearchCondition(condition);
		}
        pageSearchRequest.getSearchCondition().setTid(saaSUtil.getAccount().getTenantId());
		PageContent<PipelineStageNodeVO> pageContent = pipelineStageNodeRibbonService.list(pageSearchRequest);
		for(PipelineStageNodeVO vo : pageContent.getContent()){
			initViewProperty(vo);
		}

		LOGGER.debug("page Size :{}, total:{}", pageContent.getContent().size() ,pageContent.getTotal());
		return pageContent;
	}

	private PipelineStageNodeVO initViewProperty( PipelineStageNodeVO vo){

		SimpleConfig nodeTypeSimpleConfig = simpleConfigService.findByConfigTypeAndCode("PIPELINESTAGENODE-NODETYPE", vo.getNodeType());

		if(nodeTypeSimpleConfig!=null) {

		    SimpleConfigVO nodeTypeSimpleConfigVO = new SimpleConfigVO();
		    BeanUtils.copyProperties(nodeTypeSimpleConfig, nodeTypeSimpleConfigVO);
		    vo.setNodeTypeVO(nodeTypeSimpleConfigVO);
		}

        return vo;

	}


}