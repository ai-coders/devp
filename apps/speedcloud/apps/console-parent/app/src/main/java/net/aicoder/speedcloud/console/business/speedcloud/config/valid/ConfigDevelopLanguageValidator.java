package net.aicoder.speedcloud.console.business.speedcloud.config.valid;


import net.aicoder.speedcloud.business.config.dto.ConfigDevelopLanguageAddDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class ConfigDevelopLanguageValidator implements Validator {

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
	    if(obj instanceof ConfigDevelopLanguageAddDto){
            this.validateAddDto((ConfigDevelopLanguageAddDto)obj, errors);
        }
	}

	/**
     * 验证新增信息
     * @param configDevelopLanguage 开发语言
     * @param errors
     */
	public void validateAddDto(ConfigDevelopLanguageAddDto configDevelopLanguage, Errors errors) {


		//把校验信息注册到Error的实现类里
		//验证必填

		//验证长度
		if(StringUtils.length(configDevelopLanguage.getName()) > 255){
			errors.rejectValue("name", null, "名称最长255个字符");
		}
	}
}