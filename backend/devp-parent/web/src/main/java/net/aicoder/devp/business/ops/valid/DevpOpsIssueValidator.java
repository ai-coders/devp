package net.aicoder.devp.business.ops.valid;

import com.yunkang.saas.common.framework.web.data.PageSearchRequest;
import net.aicoder.devp.business.ops.dto.DevpOpsIssueAddDto;
import net.aicoder.devp.business.ops.dto.DevpOpsIssueEditDto;
import net.aicoder.devp.business.ops.dto.DevpOpsIssueCondition;
import net.aicoder.devp.business.ops.domain.DevpOpsIssue;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class DevpOpsIssueValidator implements Validator {

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
	    if(obj instanceof DevpOpsIssueAddDto){
            this.validateDevpOpsIssueAddDto((DevpOpsIssueAddDto)obj, errors);
        }
        if(obj instanceof PageSearchRequest){
            this.validateSearchDto((PageSearchRequest)obj);
        }
	}
	
    public void validateSearchDto(PageSearchRequest<DevpOpsIssueCondition> search){
        if(search.getSearchCondition() == null){
            search.setSearchCondition(new DevpOpsIssueCondition());
        }
    }

	/**
     * 实现Validator中的validate接口
     * @param devpOpsIssue 问题记录
     * @param errors
     */
	public void validateDevpOpsIssueAddDto(DevpOpsIssueAddDto devpOpsIssue, Errors errors) {


		//把校验信息注册到Error的实现类里
		//验证必填

		//验证长度
		if(StringUtils.length(devpOpsIssue.getEtype()) > 255){
			errors.rejectValue(DevpOpsIssue.PROPERTY_ETYPE,null,"元素类型最长255个字符");
		}
		if(StringUtils.length(devpOpsIssue.getCode()) > 255){
			errors.rejectValue(DevpOpsIssue.PROPERTY_CODE,null,"问题代码最长255个字符");
		}
		if(StringUtils.length(devpOpsIssue.getName()) > 255){
			errors.rejectValue(DevpOpsIssue.PROPERTY_NAME,null,"问题名称最长255个字符");
		}
		if(StringUtils.length(devpOpsIssue.getAlias()) > 255){
			errors.rejectValue(DevpOpsIssue.PROPERTY_ALIAS,null,"问题别名最长255个字符");
		}
		if(StringUtils.length(devpOpsIssue.getDescription()) > 255){
			errors.rejectValue(DevpOpsIssue.PROPERTY_DESCRIPTION,null,"问题描述最长255个字符");
		}
		if(StringUtils.length(devpOpsIssue.getType()) > 255){
			errors.rejectValue(DevpOpsIssue.PROPERTY_TYPE,null,"问题类型最长255个字符");
		}
		if(StringUtils.length(devpOpsIssue.getIssue()) > 255){
			errors.rejectValue(DevpOpsIssue.PROPERTY_ISSUE,null,"问题说明最长255个字符");
		}
		if(StringUtils.length(devpOpsIssue.getReply()) > 255){
			errors.rejectValue(DevpOpsIssue.PROPERTY_REPLY,null,"问题回复最长255个字符");
		}
		if(StringUtils.length(devpOpsIssue.getStatus()) > 255){
			errors.rejectValue(DevpOpsIssue.PROPERTY_STATUS,null,"处理状态最长255个字符");
		}
		if(StringUtils.length(devpOpsIssue.getNexusType()) > 255){
			errors.rejectValue(DevpOpsIssue.PROPERTY_NEXUS_TYPE,null,"关联记录类型最长255个字符");
		}
		if(StringUtils.length(devpOpsIssue.getNexusVersion()) > 255){
			errors.rejectValue(DevpOpsIssue.PROPERTY_NEXUS_VERSION,null,"关联记录版本最长255个字符");
		}
		if(StringUtils.length(devpOpsIssue.getNexusPhase()) > 255){
			errors.rejectValue(DevpOpsIssue.PROPERTY_NEXUS_PHASE,null,"关联记录阶段最长255个字符");
		}
		if(StringUtils.length(devpOpsIssue.getParasCode()) > 255){
			errors.rejectValue(DevpOpsIssue.PROPERTY_PARAS_CODE,null,"参数定义标识最长255个字符");
		}
		if(StringUtils.length(devpOpsIssue.getCreateUcode()) > 255){
			errors.rejectValue(DevpOpsIssue.PROPERTY_CREATE_UCODE,null,"创建用户代码最长255个字符");
		}
		if(StringUtils.length(devpOpsIssue.getCreateUname()) > 255){
			errors.rejectValue(DevpOpsIssue.PROPERTY_CREATE_UNAME,null,"创建用户姓名最长255个字符");
		}
		if(StringUtils.length(devpOpsIssue.getModifyUcode()) > 255){
			errors.rejectValue(DevpOpsIssue.PROPERTY_MODIFY_UCODE,null,"修改用户代码最长255个字符");
		}
		if(StringUtils.length(devpOpsIssue.getModifyUname()) > 255){
			errors.rejectValue(DevpOpsIssue.PROPERTY_MODIFY_UNAME,null,"修改用户姓名最长255个字符");
		}
		if(StringUtils.length(devpOpsIssue.getCmodifyUcode()) > 255){
			errors.rejectValue(DevpOpsIssue.PROPERTY_CMODIFY_UCODE,null,"cmodify_ucode最长255个字符");
		}
	}
}