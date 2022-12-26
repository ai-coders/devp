package net.aicoder.speedcloud.business.config.valid;

import com.yunkang.saas.common.framework.web.data.PageSearchRequest;
import net.aicoder.speedcloud.business.config.domain.CodeRepositoryType;
import net.aicoder.speedcloud.business.config.dto.CodeRepositoryTypeAddDto;
import net.aicoder.speedcloud.business.config.dto.CodeRepositoryTypeCondition;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class CodeRepositoryTypeValidator implements Validator {

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
	    if(obj instanceof CodeRepositoryTypeAddDto){
            this.validateCodeRepositoryTypeAddDto((CodeRepositoryTypeAddDto)obj, errors);
        }
        if(obj instanceof PageSearchRequest){
            this.validateSearchDto((PageSearchRequest)obj, errors);
        }
	}
	
    public void validateSearchDto(PageSearchRequest<CodeRepositoryTypeCondition> search, Errors errors) {
        if(search.getSearchCondition() == null){
            search.setSearchCondition(new CodeRepositoryTypeCondition());
        }
    }

	/**
     * 实现Validator中的validate接口
     * @param codeRepositoryType 代码库类型
     * @param errors
     */
	public void validateCodeRepositoryTypeAddDto(CodeRepositoryTypeAddDto codeRepositoryType, Errors errors) {


		//把校验信息注册到Error的实现类里
		//验证必填

		//验证长度
		if(StringUtils.length(codeRepositoryType.getCode()) > 255){
			errors.rejectValue(CodeRepositoryType.PROPERTY_CODE,null,"代码最长255个字符");
		}
		if(StringUtils.length(codeRepositoryType.getName()) > 255){
			errors.rejectValue(CodeRepositoryType.PROPERTY_NAME,null,"名称最长255个字符");
		}
	}
}