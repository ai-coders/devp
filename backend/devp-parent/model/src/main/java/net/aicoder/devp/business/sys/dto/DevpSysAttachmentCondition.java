package net.aicoder.devp.business.sys.dto;

import com.yunkang.saas.common.framework.eo.SaaSCondition;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


@ApiModel(value = "查询附件使用的DTO")
public class DevpSysAttachmentCondition extends SaaSCondition{

	@ApiModelProperty(value = "租户编号", notes = "[租户编号]")
	private Long tid;
	@ApiModelProperty(value = "租户编号最大值")
	private Long tidMax;
	@ApiModelProperty(value = "租户编号最小值")
	private Long tidMin;
	@ApiModelProperty(value = "元素类型", notes = "[元素类型]")
	private String etype;
	@ApiModelProperty(value = "附件名称", notes = "[附件名称]")
	private String name;
	@ApiModelProperty(value = "附件代码", notes = "[附件代码]")
	private String code;
	@ApiModelProperty(value = "附件别名", notes = "[附件别名]")
	private String alias;
	@ApiModelProperty(value = "附件描述", notes = "[附件描述]")
	private String description;
	@ApiModelProperty(value = "记录状态", notes = "[记录状态]-0-失效;1-生效;缺省为1")
	private Integer recordState;
	@ApiModelProperty(value = "记录状态最大值")
	private Integer recordStateMax;
	@ApiModelProperty(value = "记录状态最小值")
	private Integer recordStateMin;
	@ApiModelProperty(value = "类型", notes = "[类型]-配置文件(依据模板创建)；工作成果物；参考资料；其它")
	private String type;
	@ApiModelProperty(value = "子类型", notes = "[子类型]")
	private String subType;
	@ApiModelProperty(value = "文件类型", notes = "[文件类型]")
	private String fileType;
	@ApiModelProperty(value = "访问方式", notes = "[访问方式]")
	private String accessType;
	@ApiModelProperty(value = "工作空间", notes = "[工作空间]")
	private String workspace;
	@ApiModelProperty(value = "访问路径", notes = "[访问路径]")
	private String path;
	@ApiModelProperty(value = "访问地址", notes = "[访问地址]")
	private String fileName;
	@ApiModelProperty(value = "附件版本", notes = "[附件版本]-当前版本")
	private String fileVersion;
	@ApiModelProperty(value = "关联记录编号", notes = "[关联记录编号]")
	private Long objRid;
	@ApiModelProperty(value = "关联记录编号最大值")
	private Long objRidMax;
	@ApiModelProperty(value = "关联记录编号最小值")
	private Long objRidMin;
	@ApiModelProperty(value = "顺序号", notes = "[顺序号]")
	private Integer seq;
	@ApiModelProperty(value = "顺序号最大值")
	private Integer seqMax;
	@ApiModelProperty(value = "顺序号最小值")
	private Integer seqMin;
	@ApiModelProperty(value = "模板编号", notes = "[模板编号]")
	private Long tplRid;
	@ApiModelProperty(value = "模板编号最大值")
	private Long tplRidMax;
	@ApiModelProperty(value = "模板编号最小值")
	private Long tplRidMin;
	@ApiModelProperty(value = "文件创建器", notes = "[文件创建器]")
	private String fileCreater;
	@ApiModelProperty(value = "文件编辑器", notes = "[文件编辑器]")
	private String fileEditor;
	@ApiModelProperty(value = "是否可修改", notes = "[是否可修改]-0:不可修改；1：可修改")
	private Integer revisability;
	@ApiModelProperty(value = "是否可修改最大值")
	private Integer revisabilityMax;
	@ApiModelProperty(value = "是否可修改最小值")
	private Integer revisabilityMin;
	@ApiModelProperty(value = "创建用户代码", notes = "[创建用户代码]")
	private String createUcode;
	@ApiModelProperty(value = "创建用户姓名", notes = "[创建用户姓名]")
	private String createUname;
	@ApiModelProperty(value = "修改用户代码", notes = "[修改用户代码]")
	private String cmodifyUcode;
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


	public String getFileType(){
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}


	public String getAccessType(){
		return accessType;
	}
	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}


	public String getWorkspace(){
		return workspace;
	}
	public void setWorkspace(String workspace) {
		this.workspace = workspace;
	}


	public String getPath(){
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}


	public String getFileName(){
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public String getFileVersion(){
		return fileVersion;
	}
	public void setFileVersion(String fileVersion) {
		this.fileVersion = fileVersion;
	}


	public Long getObjRid(){
		return objRid;
	}
	public void setObjRid(Long objRid) {
		this.objRid = objRid;
	}

	public Long getObjRidMin(){
		return objRidMin;
	}
	public void setObjRidMin(Long objRidMin) {
		this.objRidMin = objRidMin;
	}

	public Long getObjRidMax(){
		return objRidMax;
	}
	public void setObjRidMax(Long objRidMax) {
		this.objRidMax = objRidMax;
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


	public Long getTplRid(){
		return tplRid;
	}
	public void setTplRid(Long tplRid) {
		this.tplRid = tplRid;
	}

	public Long getTplRidMin(){
		return tplRidMin;
	}
	public void setTplRidMin(Long tplRidMin) {
		this.tplRidMin = tplRidMin;
	}

	public Long getTplRidMax(){
		return tplRidMax;
	}
	public void setTplRidMax(Long tplRidMax) {
		this.tplRidMax = tplRidMax;
	}


	public String getFileCreater(){
		return fileCreater;
	}
	public void setFileCreater(String fileCreater) {
		this.fileCreater = fileCreater;
	}


	public String getFileEditor(){
		return fileEditor;
	}
	public void setFileEditor(String fileEditor) {
		this.fileEditor = fileEditor;
	}


	public Integer getRevisability(){
		return revisability;
	}
	public void setRevisability(Integer revisability) {
		this.revisability = revisability;
	}

	public Integer getRevisabilityMin(){
		return revisabilityMin;
	}
	public void setRevisabilityMin(Integer revisabilityMin) {
		this.revisabilityMin = revisabilityMin;
	}

	public Integer getRevisabilityMax(){
		return revisabilityMax;
	}
	public void setRevisabilityMax(Integer revisabilityMax) {
		this.revisabilityMax = revisabilityMax;
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


	public String getCmodifyUcode(){
		return cmodifyUcode;
	}
	public void setCmodifyUcode(String cmodifyUcode) {
		this.cmodifyUcode = cmodifyUcode;
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
