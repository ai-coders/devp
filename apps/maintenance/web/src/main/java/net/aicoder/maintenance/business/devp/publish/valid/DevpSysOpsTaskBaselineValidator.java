package net.aicoder.maintenance.business.devp.publish.valid;


import com.yunkang.saas.common.framework.web.data.PageSearchRequest;
import net.aicoder.devp.business.publish.dto.DevpSysOpsTaskBaselineAddDto;
import net.aicoder.devp.business.publish.dto.DevpSysOpsTaskBaselineEditDto;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class DevpSysOpsTaskBaselineValidator implements Validator {

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
	    if(obj instanceof DevpSysOpsTaskBaselineAddDto){
            this.validateAddDto((DevpSysOpsTaskBaselineAddDto)obj, errors);
        }
	}

	/**
     * 验证新增信息
     * @param devpSysOpsTaskBaseline 基线设置
     * @param errors
     */
	public void validateAddDto(DevpSysOpsTaskBaselineAddDto devpSysOpsTaskBaseline, Errors errors) {


		//把校验信息注册到Error的实现类里
		//验证必填
		if (null == devpSysOpsTaskBaseline.getTid() ) {
			errors.rejectValue("tid", "EMPTY_TID", "租户编号不能为空");
		}
		if(StringUtils.isEmpty(devpSysOpsTaskBaseline.getEtype())){
			errors.rejectValue("etype", "EMPTY_ETYPE", "元素类型不能为空");
		}
       
		if(StringUtils.isEmpty(devpSysOpsTaskBaseline.getName())){
			errors.rejectValue("name", "EMPTY_NAME", "系统元素名称不能为空");
		}
       
		if (null == devpSysOpsTaskBaseline.getPrdRid() ) {
			errors.rejectValue("prdRid", "EMPTY_PRD_RID", "产品编号不能为空");
		}
		if (null == devpSysOpsTaskBaseline.getSchemeRid() ) {
			errors.rejectValue("schemeRid", "EMPTY_SCHEME_RID", "部署方案编号不能为空");
		}
		if (null == devpSysOpsTaskBaseline.getCmpRid() ) {
			errors.rejectValue("cmpRid", "EMPTY_CMP_RID", "组件编号不能为空");
		}
		if (null == devpSysOpsTaskBaseline.getTaskRid() ) {
			errors.rejectValue("taskRid", "EMPTY_TASK_RID", "任务编号不能为空");
		}

		//验证长度
		if(StringUtils.length(devpSysOpsTaskBaseline.getEtype()) > 255){
			errors.rejectValue("etype", null, "元素类型最长255个字符");
		}
		if(StringUtils.length(devpSysOpsTaskBaseline.getName()) > 255){
			errors.rejectValue("name", null, "系统元素名称最长255个字符");
		}
		if(StringUtils.length(devpSysOpsTaskBaseline.getCode()) > 255){
			errors.rejectValue("code", null, "系统元素代码最长255个字符");
		}
		if(StringUtils.length(devpSysOpsTaskBaseline.getAlias()) > 255){
			errors.rejectValue("alias", null, "系统元素别名最长255个字符");
		}
		if(StringUtils.length(devpSysOpsTaskBaseline.getDescription()) > 255){
			errors.rejectValue("description", null, "系统元素描述最长255个字符");
		}
		if(StringUtils.length(devpSysOpsTaskBaseline.getType()) > 255){
			errors.rejectValue("type", null, "类型最长255个字符");
		}
		if(StringUtils.length(devpSysOpsTaskBaseline.getSubType()) > 255){
			errors.rejectValue("subType", null, "子类型最长255个字符");
		}
		if(StringUtils.length(devpSysOpsTaskBaseline.getCmType()) > 255){
			errors.rejectValue("cmType", null, "代码仓库类型最长255个字符");
		}
		if(StringUtils.length(devpSysOpsTaskBaseline.getCmRepository()) > 255){
			errors.rejectValue("cmRepository", null, "仓库地址最长255个字符");
		}
		if(StringUtils.length(devpSysOpsTaskBaseline.getCmTag()) > 255){
			errors.rejectValue("cmTag", null, "分支标识最长255个字符");
		}
		if(StringUtils.length(devpSysOpsTaskBaseline.getCmUser()) > 255){
			errors.rejectValue("cmUser", null, "用户名最长255个字符");
		}
		if(StringUtils.length(devpSysOpsTaskBaseline.getCmPassword()) > 255){
			errors.rejectValue("cmPassword", null, "密码最长255个字符");
		}
		if(StringUtils.length(devpSysOpsTaskBaseline.getSubDir()) > 255){
			errors.rejectValue("subDir", null, "子目录最长255个字符");
		}
		if(StringUtils.length(devpSysOpsTaskBaseline.getBaseline()) > 255){
			errors.rejectValue("baseline", null, "基线标识最长255个字符");
		}
		if(StringUtils.length(devpSysOpsTaskBaseline.getSvnFromUrl()) > 255){
			errors.rejectValue("svnFromUrl", null, "来源代码路径最长255个字符");
		}
		if(StringUtils.length(devpSysOpsTaskBaseline.getSvnToUrl()) > 255){
			errors.rejectValue("svnToUrl", null, "目标基线路径最长255个字符");
		}
		if(StringUtils.length(devpSysOpsTaskBaseline.getOperType()) > 255){
			errors.rejectValue("operType", null, "操作方式最长255个字符");
		}
		if(StringUtils.length(devpSysOpsTaskBaseline.getStatus()) > 255){
			errors.rejectValue("status", null, "状态最长255个字符");
		}
		if(StringUtils.length(devpSysOpsTaskBaseline.getNotes()) > 255){
			errors.rejectValue("notes", null, "备注最长255个字符");
		}
		if(StringUtils.length(devpSysOpsTaskBaseline.getCreateUcode()) > 255){
			errors.rejectValue("createUcode", null, "创建用户代码最长255个字符");
		}
		if(StringUtils.length(devpSysOpsTaskBaseline.getCreateUname()) > 255){
			errors.rejectValue("createUname", null, "创建用户姓名最长255个字符");
		}
		if(StringUtils.length(devpSysOpsTaskBaseline.getModifyUcode()) > 255){
			errors.rejectValue("modifyUcode", null, "修改用户代码最长255个字符");
		}
		if(StringUtils.length(devpSysOpsTaskBaseline.getModifyUname()) > 255){
			errors.rejectValue("modifyUname", null, "修改用户姓名最长255个字符");
		}
	}
}