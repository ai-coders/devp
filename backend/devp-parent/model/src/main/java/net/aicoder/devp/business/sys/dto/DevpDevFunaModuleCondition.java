package net.aicoder.devp.business.sys.dto;

import com.yunkang.saas.common.framework.eo.SaaSCondition;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


@ApiModel(value = "查询功能模块使用的DTO")
public class DevpDevFunaModuleCondition extends SaaSCondition{

	@ApiModelProperty(value = "租户编号", notes = "[租户编号]")
	private Long tid;
	@ApiModelProperty(value = "租户编号最大值")
	private Long tidMax;
	@ApiModelProperty(value = "租户编号最小值")
	private Long tidMin;
	@ApiModelProperty(value = "模块名称", notes = "[模块名称]")
	private String name;
	@ApiModelProperty(value = "模块代码", notes = "[模块代码]")
	private String code;
	@ApiModelProperty(value = "模块别名", notes = "[模块别名]")
	private String alias;
	@ApiModelProperty(value = "模块描述", notes = "[模块描述]")
	private String description;
	@ApiModelProperty(value = "模块标志", notes = "[模块标志]-0:产品;1:模块;2:功能")
	private Integer mduFlag;
	@ApiModelProperty(value = "模块标志最大值")
	private Integer mduFlagMax;
	@ApiModelProperty(value = "模块标志最小值")
	private Integer mduFlagMin;
	@ApiModelProperty(value = "类型", notes = "[类型]")
	private String type;
	@ApiModelProperty(value = "构造型", notes = "[构造型]")
	private String stereotype;
	@ApiModelProperty(value = "访问控制范围", notes = "[访问控制范围]-访问控制范围:产品内可见，同模块可见，模块内可见")
	private String scope;
	@ApiModelProperty(value = "使用者", notes = "[使用者]")
	private String actor;
	@ApiModelProperty(value = "优先级", notes = "[优先级]")
	private String priority;
	@ApiModelProperty(value = "版本", notes = "[版本]-当前版本")
	private String version;
	@ApiModelProperty(value = "阶段", notes = "[阶段]-需求调研，需求分析,软件设计,软件开发，系统测试，功能交付")
	private String phase;
	@ApiModelProperty(value = "状态", notes = "[状态]-未开始,进行中,已完成,暂停,取消")
	private String status;
	@ApiModelProperty(value = "产品编号", notes = "[产品编号]")
	private Long prdRid;
	@ApiModelProperty(value = "产品编号最大值")
	private Long prdRidMax;
	@ApiModelProperty(value = "产品编号最小值")
	private Long prdRidMin;
	@ApiModelProperty(value = "父模块编号", notes = "[父模块编号]")
	private Long parentRid;
	@ApiModelProperty(value = "父模块编号最大值")
	private Long parentRidMax;
	@ApiModelProperty(value = "父模块编号最小值")
	private Long parentRidMin;
	@ApiModelProperty(value = "顺序号", notes = "[顺序号]")
	private Integer seq;
	@ApiModelProperty(value = "顺序号最大值")
	private Integer seqMax;
	@ApiModelProperty(value = "顺序号最小值")
	private Integer seqMin;
	@ApiModelProperty(value = "备注", notes = "[备注]")
	private String notes;
	@ApiModelProperty(value = "记录状态", notes = "[记录状态]-0-失效;1-生效;缺省为1")
	private Integer recordState;
	@ApiModelProperty(value = "记录状态最大值")
	private Integer recordStateMax;
	@ApiModelProperty(value = "记录状态最小值")
	private Integer recordStateMin;
	@ApiModelProperty(value = "创建用户代码", notes = "[创建用户代码]")
	private String createUcode;
	@ApiModelProperty(value = "创建用户姓名", notes = "[创建用户姓名]")
	private String createUname;
	@ApiModelProperty(value = "修改用户代码", notes = "[修改用户代码]")
	private String modifyUcode;
	@ApiModelProperty(value = "修改用户姓名", notes = "[修改用户姓名]")
	private String modifyUname;


	public Long getTid(){
		return tid;
	}
	public void setTid(Long tid) {
		this.tid = tid;
	}

	public Long getTidMin(){
		return tidMin;
	}
	public void setTidMin(Long tidMin) {
		this.tidMin = tidMin;
	}

	public Long getTidMax(){
		return tidMax;
	}
	public void setTidMax(Long tidMax) {
		this.tidMax = tidMax;
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


	public Integer getMduFlag(){
		return mduFlag;
	}
	public void setMduFlag(Integer mduFlag) {
		this.mduFlag = mduFlag;
	}

	public Integer getMduFlagMin(){
		return mduFlagMin;
	}
	public void setMduFlagMin(Integer mduFlagMin) {
		this.mduFlagMin = mduFlagMin;
	}

	public Integer getMduFlagMax(){
		return mduFlagMax;
	}
	public void setMduFlagMax(Integer mduFlagMax) {
		this.mduFlagMax = mduFlagMax;
	}


	public String getType(){
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}


	public String getStereotype(){
		return stereotype;
	}
	public void setStereotype(String stereotype) {
		this.stereotype = stereotype;
	}


	public String getScope(){
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}


	public String getActor(){
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}


	public String getPriority(){
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}


	public String getVersion(){
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}


	public String getPhase(){
		return phase;
	}
	public void setPhase(String phase) {
		this.phase = phase;
	}


	public String getStatus(){
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


	public Long getPrdRid(){
		return prdRid;
	}
	public void setPrdRid(Long prdRid) {
		this.prdRid = prdRid;
	}

	public Long getPrdRidMin(){
		return prdRidMin;
	}
	public void setPrdRidMin(Long prdRidMin) {
		this.prdRidMin = prdRidMin;
	}

	public Long getPrdRidMax(){
		return prdRidMax;
	}
	public void setPrdRidMax(Long prdRidMax) {
		this.prdRidMax = prdRidMax;
	}


	public Long getParentRid(){
		return parentRid;
	}
	public void setParentRid(Long parentRid) {
		this.parentRid = parentRid;
	}

	public Long getParentRidMin(){
		return parentRidMin;
	}
	public void setParentRidMin(Long parentRidMin) {
		this.parentRidMin = parentRidMin;
	}

	public Long getParentRidMax(){
		return parentRidMax;
	}
	public void setParentRidMax(Long parentRidMax) {
		this.parentRidMax = parentRidMax;
	}


	public Integer getSeq(){
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public Integer getSeqMin(){
		return seqMin;
	}
	public void setSeqMin(Integer seqMin) {
		this.seqMin = seqMin;
	}

	public Integer getSeqMax(){
		return seqMax;
	}
	public void setSeqMax(Integer seqMax) {
		this.seqMax = seqMax;
	}


	public String getNotes(){
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}


	public Integer getRecordState(){
		return recordState;
	}
	public void setRecordState(Integer recordState) {
		this.recordState = recordState;
	}

	public Integer getRecordStateMin(){
		return recordStateMin;
	}
	public void setRecordStateMin(Integer recordStateMin) {
		this.recordStateMin = recordStateMin;
	}

	public Integer getRecordStateMax(){
		return recordStateMax;
	}
	public void setRecordStateMax(Integer recordStateMax) {
		this.recordStateMax = recordStateMax;
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
