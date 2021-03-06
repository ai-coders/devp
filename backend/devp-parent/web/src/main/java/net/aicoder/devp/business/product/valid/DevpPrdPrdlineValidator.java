package net.aicoder.devp.business.product.valid;

import com.yunkang.saas.common.framework.web.data.PageSearchRequest;
import net.aicoder.devp.business.product.dto.DevpPrdPrdlineAddDto;
import net.aicoder.devp.business.product.dto.DevpPrdPrdlineEditDto;
import net.aicoder.devp.business.product.dto.DevpPrdPrdlineCondition;
import net.aicoder.devp.business.product.domain.DevpPrdPrdline;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class DevpPrdPrdlineValidator implements Validator {

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
	    if(obj instanceof DevpPrdPrdlineAddDto){
            this.validateDevpPrdPrdlineAddDto((DevpPrdPrdlineAddDto)obj, errors);
        }
        if(obj instanceof PageSearchRequest){
            this.validateSearchDto((PageSearchRequest)obj);
        }
	}
	
    public void validateSearchDto(PageSearchRequest<DevpPrdPrdlineCondition> search){
        if(search.getSearchCondition() == null){
            search.setSearchCondition(new DevpPrdPrdlineCondition());
        }
    }

	/**
     * 实现Validator中的validate接口
     * @param devpPrdPrdline 产品线
     * @param errors
     */
	public void validateDevpPrdPrdlineAddDto(DevpPrdPrdlineAddDto devpPrdPrdline, Errors errors) {


		//把校验信息注册到Error的实现类里
		//验证必填

		//验证长度
		if(StringUtils.length(devpPrdPrdline.getEtype()) > 255){
			errors.rejectValue(DevpPrdPrdline.PROPERTY_ETYPE,null,"etype最长255个字符");
		}
		if(StringUtils.length(devpPrdPrdline.getName()) > 255){
			errors.rejectValue(DevpPrdPrdline.PROPERTY_NAME,null,"产品线名称最长255个字符");
		}
		if(StringUtils.length(devpPrdPrdline.getCode()) > 255){
			errors.rejectValue(DevpPrdPrdline.PROPERTY_CODE,null,"产品线代码最长255个字符");
		}
		if(StringUtils.length(devpPrdPrdline.getAlias()) > 255){
			errors.rejectValue(DevpPrdPrdline.PROPERTY_ALIAS,null,"产品线别名最长255个字符");
		}
		if(StringUtils.length(devpPrdPrdline.getDescription()) > 255){
			errors.rejectValue(DevpPrdPrdline.PROPERTY_DESCRIPTION,null,"产品线描述最长255个字符");
		}
		if(StringUtils.length(devpPrdPrdline.getType()) > 255){
			errors.rejectValue(DevpPrdPrdline.PROPERTY_TYPE,null,"产品线类型最长255个字符");
		}
		if(StringUtils.length(devpPrdPrdline.getDomain()) > 255){
			errors.rejectValue(DevpPrdPrdline.PROPERTY_DOMAIN,null,"领域最长255个字符");
		}
		if(StringUtils.length(devpPrdPrdline.getStereotype()) > 255){
			errors.rejectValue(DevpPrdPrdline.PROPERTY_STEREOTYPE,null,"构造型最长255个字符");
		}
		if(StringUtils.length(devpPrdPrdline.getScope()) > 255){
			errors.rejectValue(DevpPrdPrdline.PROPERTY_SCOPE,null,"访问控制范围最长255个字符");
		}
		if(StringUtils.length(devpPrdPrdline.getVersion()) > 255){
			errors.rejectValue(DevpPrdPrdline.PROPERTY_VERSION,null,"版本最长255个字符");
		}
		if(StringUtils.length(devpPrdPrdline.getPhase()) > 255){
			errors.rejectValue(DevpPrdPrdline.PROPERTY_PHASE,null,"阶段最长255个字符");
		}
		if(StringUtils.length(devpPrdPrdline.getStatus()) > 255){
			errors.rejectValue(DevpPrdPrdline.PROPERTY_STATUS,null,"状态最长255个字符");
		}
		if(StringUtils.length(devpPrdPrdline.getCreateUcode()) > 255){
			errors.rejectValue(DevpPrdPrdline.PROPERTY_CREATE_UCODE,null,"创建用户代码最长255个字符");
		}
		if(StringUtils.length(devpPrdPrdline.getCreateUname()) > 255){
			errors.rejectValue(DevpPrdPrdline.PROPERTY_CREATE_UNAME,null,"创建用户姓名最长255个字符");
		}
		if(StringUtils.length(devpPrdPrdline.getModifyUcode()) > 255){
			errors.rejectValue(DevpPrdPrdline.PROPERTY_MODIFY_UCODE,null,"修改用户代码最长255个字符");
		}
		if(StringUtils.length(devpPrdPrdline.getModifyUname()) > 255){
			errors.rejectValue(DevpPrdPrdline.PROPERTY_MODIFY_UNAME,null,"修改用户姓名最长255个字符");
		}
	}
}