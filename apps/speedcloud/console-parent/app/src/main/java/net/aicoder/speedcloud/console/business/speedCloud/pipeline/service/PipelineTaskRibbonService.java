package net.aicoder.speedcloud.console.business.speedCloud.pipeline.service;

import com.yunkang.saas.common.framework.exception.BusinessException;
import com.yunkang.saas.common.framework.web.controller.PageContent;
import com.yunkang.saas.common.framework.web.data.PageSearchRequest;
import net.aicoder.speedcloud.client.pipeline.PipelineTaskRibbon;
import net.aicoder.speedcloud.client.pipeline.result.PipelineTaskPageResult;
import net.aicoder.speedcloud.client.pipeline.result.PipelineTaskResult;
import net.aicoder.speedcloud.business.pipeline.dto.PipelineTaskCondition;
import net.aicoder.speedcloud.business.pipeline.dto.PipelineTaskAddDto;
import net.aicoder.speedcloud.business.pipeline.dto.PipelineTaskEditDto;
import net.aicoder.speedcloud.business.pipeline.vo.PipelineTaskVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("pipelineTaskRibbonService")
public class PipelineTaskRibbonService  {

	private static final Logger LOGGER = LoggerFactory.getLogger(PipelineTaskRibbonService.class);


	@Autowired
	private PipelineTaskRibbon pipelineTaskRibbon;


	public PipelineTaskVO add(PipelineTaskAddDto addDto){
		PipelineTaskResult result = pipelineTaskRibbon.add(addDto);

		if(!result.isSuccess()){
			throw new BusinessException("SPEEDCLOUD", "PIPELINE", result.getCode()+"", result.getMessage());
		}
		return result.getData();
	
	}

	public void delete(Long id){
		if(null == id){
			LOGGER.warn("try delete T by empty id. Code need check");
			return ;
		}
		LOGGER.debug("delete t:{}", id);
		PipelineTaskResult result = pipelineTaskRibbon.delete(id);
		if(!result.isSuccess()){
			throw new BusinessException("SPEEDCLOUD", "PIPELINE", result.getCode()+"", result.getMessage());
		}
	}
	public PipelineTaskVO merge(Long id, PipelineTaskEditDto editDto){
		PipelineTaskResult result = pipelineTaskRibbon.update(id, editDto);

		if(!result.isSuccess()){
			throw new BusinessException("SPEEDCLOUD", "PIPELINE", result.getCode()+"", result.getMessage());
		}

		return result.getData();
	}
	public PipelineTaskVO find(Long id){
		PipelineTaskResult result = pipelineTaskRibbon.get(id);

		if(!result.isSuccess()){
			throw new BusinessException("SPEEDCLOUD", "PIPELINE", result.getCode()+"", result.getMessage());
		}

		return result.getData();
	}

	public PageContent<PipelineTaskVO> list(PageSearchRequest<PipelineTaskCondition> pageSearchRequest) {
		PipelineTaskPageResult result = pipelineTaskRibbon.list(pageSearchRequest);

		if(!result.isSuccess()){
			throw new BusinessException("SPEEDCLOUD", "PIPELINE", result.getCode()+"", result.getMessage());
		}

		return result.getData();
	}
}
