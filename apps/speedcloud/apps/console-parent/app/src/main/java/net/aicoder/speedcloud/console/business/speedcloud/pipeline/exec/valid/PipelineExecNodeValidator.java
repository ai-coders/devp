package net.aicoder.speedcloud.console.business.speedcloud.pipeline.exec.valid;


import net.aicoder.speedcloud.business.pipeline.exec.dto.PipelineExecNodeAddDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class PipelineExecNodeValidator implements Validator {

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
	    if(obj instanceof PipelineExecNodeAddDto){
            this.validateAddDto((PipelineExecNodeAddDto)obj, errors);
        }
	}

	/**
     * 验证新增信息
     * @param pipelineExecNode 运行实例节点
     * @param errors
     */
		public void validateAddDto(PipelineExecNodeAddDto pipelineExecNode, Errors errors) {


		//把校验信息注册到Error的实现类里
		//验证必填

		//验证长度
		if(StringUtils.length(pipelineExecNode.getCode()) > 255){
			errors.rejectValue("code", null, "编号最长255个字符");
		}
		if(StringUtils.length(pipelineExecNode.getName()) > 255){
			errors.rejectValue("name", null, "节点名称最长255个字符");
		}
		if(StringUtils.length(pipelineExecNode.getNodeType()) > 255){
			errors.rejectValue("nodeType", null, "节点类型最长255个字符");
		}
		if(StringUtils.length(pipelineExecNode.getExecMode()) > 255){
			errors.rejectValue("execMode", null, "执行方式最长255个字符");
		}
		if(StringUtils.length(pipelineExecNode.getStatus()) > 255){
			errors.rejectValue("status", null, "运行状态最长255个字符");
		}
		if(StringUtils.length(pipelineExecNode.getResult()) > 255){
			errors.rejectValue("result", null, "运行结果最长255个字符");
		}
		if(StringUtils.length(pipelineExecNode.getResultMessage()) > 255){
			errors.rejectValue("resultMessage", null, "结果消息最长255个字符");
		}
		if(StringUtils.length(pipelineExecNode.getParentId()) > 255){
			errors.rejectValue("parentId", null, "上级节点最长255个字符");
		}
	}
}