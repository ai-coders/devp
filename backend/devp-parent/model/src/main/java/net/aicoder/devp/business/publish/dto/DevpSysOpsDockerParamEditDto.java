package net.aicoder.devp.business.publish.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 部署容器参数定义
 * @author icode
 */
@ApiModel(value = "修改部署容器参数定义使用的DTO")
public class DevpSysOpsDockerParamEditDto {


	/**租户编号*/
	@ApiModelProperty(value = "租户编号", required = false, notes = "[租户编号]")
	private Long tid;


	/**元素类型*/
	@ApiModelProperty(value = "元素类型", required = false, notes = "[元素类型]-SYS_OPS_DOCKER_PARAM")
	private String etype;


	/**系统元素名称*/
	@ApiModelProperty(value = "系统元素名称", required = false, notes = "[系统元素名称]-docker参数名称")
	private String name;


	/**参数代码*/
	@ApiModelProperty(value = "参数代码", required = false, notes = "[参数代码]")
	private String code;


	/**系统元素别名*/
	@ApiModelProperty(value = "系统元素别名", required = false, notes = "[系统元素别名]")
	private String alias;


	/**系统元素描述*/
	@ApiModelProperty(value = "系统元素描述", required = false, notes = "[系统元素描述]")
	private String description;


	/**记录状态*/
	@ApiModelProperty(value = "记录状态", required = false, notes = "[记录状态]-0-失效;1-生效;缺省为1")
	private Integer recordState;


	/**类型*/
	@ApiModelProperty(value = "类型", required = false, notes = "[类型]-环境变量")
	private String type;


	/**子类型*/
	@ApiModelProperty(value = "子类型", required = false, notes = "[子类型]")
	private String subType;


	/**参数值*/
	@ApiModelProperty(value = "参数值", required = false, notes = "[参数值]")
	private String value;


	/**备注*/
	@ApiModelProperty(value = "备注", required = false, notes = "[备注]")
	private String notes;


	/**产品编号*/
	@ApiModelProperty(value = "产品编号", required = false, notes = "[产品编号]")
	private Long prdRid;


	/**部署方案编号*/
	@ApiModelProperty(value = "部署方案编号", required = false, notes = "[部署方案编号]")
	private Long schemeRid;


	/**组件编号*/
	@ApiModelProperty(value = "组件编号", required = false, notes = "[组件编号]")
	private Long cmpRid;


	/**任务编号*/
	@ApiModelProperty(value = "任务编号", required = false, notes = "[任务编号]")
	private Long taskRid;


	/**容器编号*/
	@ApiModelProperty(value = "容器编号", required = false, notes = "[容器编号]")
	private Long dockerRid;


	/**顺序号*/
	@ApiModelProperty(value = "顺序号", required = false, notes = "[顺序号]")
	private Integer seq;


	/**创建用户代码*/
	@ApiModelProperty(value = "创建用户代码", required = false, notes = "[创建用户代码]")
	private String createUcode;


	/**创建用户姓名*/
	@ApiModelProperty(value = "创建用户姓名", required = false, notes = "[创建用户姓名]")
	private String createUname;


	/**修改用户代码*/
	@ApiModelProperty(value = "修改用户代码", required = false, notes = "[修改用户代码]")
	private String modifyUcode;


	/**修改用户姓名*/
	@ApiModelProperty(value = "修改用户姓名", required = false, notes = "[修改用户姓名]")
	private String modifyUname;



	public Long getTid(){
		return tid;
	}
	public void setTid(Long tid) {
		this.tid = tid;
	}


	public String getEtype(){
		return etype;
	}
	public void setEtype(String etype) {
		this.etype = etype;
	}


	public String getName(){
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public String getCode(){
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}


	public String getAlias(){
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}


	public String getDescription(){
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


	public Integer getRecordState(){
		return recordState;
	}
	public void setRecordState(Integer recordState) {
		this.recordState = recordState;
	}


	public String getType(){
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}


	public String getSubType(){
		return subType;
	}
	public void setSubType(String subType) {
		this.subType = subType;
	}


	public String getValue(){
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}


	public String getNotes(){
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}


	public Long getPrdRid(){
		return prdRid;
	}
	public void setPrdRid(Long prdRid) {
		this.prdRid = prdRid;
	}


	public Long getSchemeRid(){
		return schemeRid;
	}
	public void setSchemeRid(Long schemeRid) {
		this.schemeRid = schemeRid;
	}


	public Long getCmpRid(){
		return cmpRid;
	}
	public void setCmpRid(Long cmpRid) {
		this.cmpRid = cmpRid;
	}


	public Long getTaskRid(){
		return taskRid;
	}
	public void setTaskRid(Long taskRid) {
		this.taskRid = taskRid;
	}


	public Long getDockerRid(){
		return dockerRid;
	}
	public void setDockerRid(Long dockerRid) {
		this.dockerRid = dockerRid;
	}


	public Integer getSeq(){
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}


	public String getCreateUcode(){
		return createUcode;
	}
	public void setCreateUcode(String createUcode) {
		this.createUcode = createUcode;
	}


	public String getCreateUname(){
		return createUname;
	}
	public void setCreateUname(String createUname) {
		this.createUname = createUname;
	}


	public String getModifyUcode(){
		return modifyUcode;
	}
	public void setModifyUcode(String modifyUcode) {
		this.modifyUcode = modifyUcode;
	}


	public String getModifyUname(){
		return modifyUname;
	}
	public void setModifyUname(String modifyUname) {
		this.modifyUname = modifyUname;
	}


	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
