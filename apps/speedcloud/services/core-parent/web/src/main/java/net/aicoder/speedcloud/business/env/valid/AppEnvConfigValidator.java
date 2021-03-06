package net.aicoder.speedcloud.business.env.valid;

import com.yunkang.saas.common.framework.web.data.PageSearchRequest;
import net.aicoder.speedcloud.business.env.domain.AppEnvConfig;
import net.aicoder.speedcloud.business.env.dto.AppEnvConfigAddDto;
import net.aicoder.speedcloud.business.env.dto.AppEnvConfigCondition;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class AppEnvConfigValidator implements Validator {

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
	    if(obj instanceof AppEnvConfigAddDto){
            this.validateAppEnvConfigAddDto((AppEnvConfigAddDto)obj, errors);
        }
        if(obj instanceof PageSearchRequest){
            this.validateSearchDto((PageSearchRequest)obj);
        }
	}
	
    public void validateSearchDto(PageSearchRequest<AppEnvConfigCondition> search){
        if(search.getSearchCondition() == null){
            search.setSearchCondition(new AppEnvConfigCondition());
        }
    }

	/**
     * 实现Validator中的validate接口
     * @param appEnvConfig 应用环境
     * @param errors
     */
	public void validateAppEnvConfigAddDto(AppEnvConfigAddDto appEnvConfig, Errors errors) {


		//把校验信息注册到Error的实现类里
		//验证必填

		//验证长度
		if(StringUtils.length(appEnvConfig.getName()) > 255){
			errors.rejectValue(AppEnvConfig.PROPERTY_NAME,null,"环境名称最长255个字符");
		}
		if(StringUtils.length(appEnvConfig.getLevel()) > 255){
			errors.rejectValue(AppEnvConfig.PROPERTY_LEVEL,null,"环境级别最长255个字符");
		}
	}
}