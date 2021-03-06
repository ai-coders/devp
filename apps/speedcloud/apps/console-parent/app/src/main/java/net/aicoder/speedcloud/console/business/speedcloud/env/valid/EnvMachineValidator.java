package net.aicoder.speedcloud.console.business.speedcloud.env.valid;


import net.aicoder.speedcloud.business.env.dto.EnvMachineAddDto;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class EnvMachineValidator implements Validator {

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
	    if(obj instanceof EnvMachineAddDto){
            this.validateAddDto((EnvMachineAddDto)obj, errors);
        }
	}

	/**
     * 验证新增信息
     * @param envMachine 环境设备关联
     * @param errors
     */
	public void validateAddDto(EnvMachineAddDto envMachine, Errors errors) {


		//把校验信息注册到Error的实现类里
		//验证必填
		if (null == envMachine.getTid() ) {
			errors.rejectValue("tid", "EMPTY_TID", "租户id不能为空");
		}

		//验证长度
	}
}