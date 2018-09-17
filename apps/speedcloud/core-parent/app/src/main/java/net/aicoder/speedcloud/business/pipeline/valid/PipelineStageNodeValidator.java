package net.aicoder.speedcloud.business.pipeline.valid;

import com.yunkang.saas.common.framework.web.data.PageSearchRequest;
import net.aicoder.speedcloud.business.pipeline.dto.PipelineStageNodeAddDto;
import net.aicoder.speedcloud.business.pipeline.dto.PipelineStageNodeEditDto;
import net.aicoder.speedcloud.business.pipeline.dto.PipelineStageNodeCondition;
import net.aicoder.speedcloud.business.pipeline.domain.PipelineStageNode;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class PipelineStageNodeValidator implements Validator {

	/**
	 * 判断支持的JavaBean类型
	 * @param aClass
	 * @return
	 */
	@Override
	public boolean supports(Class<?> aClass) {
		return true;
	}

	/**
	 * 实现Validator中的validate接口
	 * @param obj
	 * @param errors
	 */
	@Override
	public void validate(Object obj, Errors errors) {
	    if(obj instanceof PipelineStageNodeAddDto){
            this.validatePipelineStageNodeAddDto((PipelineStageNodeAddDto)obj, errors);
        }
        if(obj instanceof PageSearchRequest){
            this.validateSearchDto((PageSearchRequest)obj);
        }
	}
	
    public void validateSearchDto(PageSearchRequest<PipelineStageNodeCondition> search){
        if(search.getSearchCondition() == null){
            search.setSearchCondition(new PipelineStageNodeCondition());
        }
    }

	/**
     * 实现Validator中的validate接口
     * @param pipelineStageNode 阶段执行节点
     * @param errors
     */
	public void validatePipelineStageNodeAddDto(PipelineStageNodeAddDto pipelineStageNode, Errors errors) {


		//把校验信息注册到Error的实现类里
		//验证必填

		//验证长度
		if(StringUtils.length(pipelineStageNode.getName()) > 255){
			errors.rejectValue(PipelineStageNode.PROPERTY_NAME,null,"名称最长255个字符");
		}
	}
}