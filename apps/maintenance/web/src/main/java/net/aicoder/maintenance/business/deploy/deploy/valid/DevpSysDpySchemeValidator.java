package net.aicoder.maintenance.business.deploy.deploy.valid;


import com.yunkang.saas.common.framework.web.data.PageSearchRequest;
import net.aicoder.devp.business.deploy.dto.DevpSysDpySchemeAddDto;
import net.aicoder.devp.business.deploy.dto.DevpSysDpySchemeEditDto;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class DevpSysDpySchemeValidator implements Validator {

	/**
	 * 判断支持的JavaBean类型
	 * @param aClass
	 * @return
	 */
	@Override
	public boolean supports(Class<?> aClass) {
		if(DevpSysDpySchemeAddDto.class.equals(aClass))
			return true;
		if(DevpSysDpySchemeEditDto.class.equals(aClass))
			return true;
		if(PageSearchRequest.class.equals(aClass))
			return true;
		return false;
	}

	/**
	 * 实现Validator中的validate接口
	 * @param obj
	 * @param errors
	 */
	@Override
	public void validate(Object obj, Errors errors) {
	    if(obj instanceof DevpSysDpySchemeAddDto){
            this.validateAddDto((DevpSysDpySchemeAddDto)obj, errors);
        }
	}

	/**
     * 验证新增信息
     * @param devpSysDpyScheme 产品部署方案
     * @param errors
     */
	public void validateAddDto(DevpSysDpySchemeAddDto devpSysDpyScheme, Errors errors) {


		//把校验信息注册到Error的实现类里
		//验证必填
		if (null == devpSysDpyScheme.getTid() ) {
			errors.rejectValue("tid", "EMPTY_TID", "租户编号不能为空");
		}
		if(StringUtils.isEmpty(devpSysDpyScheme.getEtype())){
			errors.rejectValue("etype", "EMPTY_ETYPE", "元素类型不能为空");
		}
       
		if(StringUtils.isEmpty(devpSysDpyScheme.getName())){
			errors.rejectValue("name", "EMPTY_NAME", "系统元素名称不能为空");
		}
       
		if(StringUtils.isEmpty(devpSysDpyScheme.getCode())){
			errors.rejectValue("code", "EMPTY_CODE", "系统元素代码不能为空");
		}
       
		if (null == devpSysDpyScheme.getPrdRid() ) {
			errors.rejectValue("prdRid", "EMPTY_PRD_RID", "产品编号不能为空");
		}

		//验证长度
		if(StringUtils.length(devpSysDpyScheme.getEtype()) > 255){
			errors.rejectValue("etype", null, "元素类型最长255个字符");
		}
		if(StringUtils.length(devpSysDpyScheme.getName()) > 255){
			errors.rejectValue("name", null, "系统元素名称最长255个字符");
		}
		if(StringUtils.length(devpSysDpyScheme.getCode()) > 255){
			errors.rejectValue("code", null, "系统元素代码最长255个字符");
		}
		if(StringUtils.length(devpSysDpyScheme.getAlias()) > 255){
			errors.rejectValue("alias", null, "系统元素别名最长255个字符");
		}
		if(StringUtils.length(devpSysDpyScheme.getDescription()) > 255){
			errors.rejectValue("description", null, "系统元素描述最长255个字符");
		}
		if(StringUtils.length(devpSysDpyScheme.getType()) > 255){
			errors.rejectValue("type", null, "类型最长255个字符");
		}
		if(StringUtils.length(devpSysDpyScheme.getSubType()) > 255){
			errors.rejectValue("subType", null, "子类型最长255个字符");
		}
		if(StringUtils.length(devpSysDpyScheme.getStereotype()) > 255){
			errors.rejectValue("stereotype", null, "构造型最长255个字符");
		}
		if(StringUtils.length(devpSysDpyScheme.getScope()) > 255){
			errors.rejectValue("scope", null, "范围最长255个字符");
		}
		if(StringUtils.length(devpSysDpyScheme.getVersion()) > 255){
			errors.rejectValue("version", null, "版本最长255个字符");
		}
		if(StringUtils.length(devpSysDpyScheme.getVerPostfix()) > 255){
			errors.rejectValue("verPostfix", null, "版本标识后缀最长255个字符");
		}
		if(StringUtils.length(devpSysDpyScheme.getPhase()) > 255){
			errors.rejectValue("phase", null, "阶段最长255个字符");
		}
		if(StringUtils.length(devpSysDpyScheme.getStatus()) > 255){
			errors.rejectValue("status", null, "状态最长255个字符");
		}
		if(StringUtils.length(devpSysDpyScheme.getNotes()) > 255){
			errors.rejectValue("notes", null, "备注最长255个字符");
		}
	}
}