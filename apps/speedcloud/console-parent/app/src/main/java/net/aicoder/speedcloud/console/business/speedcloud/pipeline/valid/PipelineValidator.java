package net.aicoder.speedcloud.console.business.speedcloud.pipeline.valid;


import net.aicoder.speedcloud.business.pipeline.dto.PipelineAddDto;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class PipelineValidator implements Validator {

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
	    if(obj instanceof PipelineAddDto){
            this.validateAddDto((PipelineAddDto)obj, errors);
        }
	}

	/**
     * 验证新增信息
     * @param pipeline 流水线
     * @param errors
     */
	public void validateAddDto(PipelineAddDto pipeline, Errors errors) {
		//把校验信息注册到Error的实现类里
		//验证必填

		//验证长度
		if(StringUtils.length(pipeline.getName()) > 255){
			errors.rejectValue("name", null, "流水线名称最长255个字符");
		}
	}
}