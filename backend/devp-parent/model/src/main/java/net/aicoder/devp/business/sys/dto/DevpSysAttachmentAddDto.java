package net.aicoder.devp.business.sys.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 附件
 * @author icode
 */
@ApiModel(value = "新增附件使用的DTO")
public class DevpSysAttachmentAddDto {

    /**租户编号*/
	@ApiModelProperty(value = "租户编号", required = false, notes = "[租户编号]")
	private Long tid;

    /**元素类型*/
	@ApiModelProperty(value = "元素类型", required = false, notes = "[元素类型]")
	private String etype;

    /**附件名称*/
	@ApiModelProperty(value = "附件名称", required = false, notes = "[附件名称]")
	private String name;

    /**附件代码*/
	@ApiModelProperty(value = "附件代码", required = false, notes = "[附件代码]")
	private String code;

    /**附件别名*/
	@ApiModelProperty(value = "附件别名", required = false, notes = "[附件别名]")
	private String alias;

    /**附件描述*/
	@ApiModelProperty(value = "附件描述", required = false, notes = "[附件描述]")
	private String description;

    /**记录状态*/
	@ApiModelProperty(value = "记录状态", required = false, notes = "[记录状态]-0-失效;1-生效;缺省为1")
	private Integer recordState;

    /**类型*/
	@ApiModelProperty(value = "类型", required = false, notes = "[类型]-配置文件(依据模板创建)；工作成果物；参考资料；其它")
	private String type;

    /**子类型*/
	@ApiModelProperty(value = "子类型", required = false, notes = "[子类型]")
	private String subType;

    /**文件类型*/
	@ApiModelProperty(value = "文件类型", required = false, notes = "[文件类型]")
	private String fileType;

    /**访问方式*/
	@ApiModelProperty(value = "访问方式", required = false, notes = "[访问方式]")
	private String accessType;

    /**工作空间*/
	@ApiModelProperty(value = "工作空间", required = false, notes = "[工作空间]")
	private String workspace;

    /**访问路径*/
	@ApiModelProperty(value = "访问路径", required = false, notes = "[访问路径]")
	private String path;

    /**访问地址*/
	@ApiModelProperty(value = "访问地址", required = false, notes = "[访问地址]")
	private String fileName;

    /**附件版本*/
	@ApiModelProperty(value = "附件版本", required = false, notes = "[附件版本]-当前版本")
	private String fileVersion;

    /**关联记录编号*/
	@ApiModelProperty(value = "关联记录编号", required = false, notes = "[关联记录编号]")
	private Long objRid;

    /**顺序号*/
	@ApiModelProperty(value = "顺序号", required = false, notes = "[顺序号]")
	private Integer seq;

    /**模板编号*/
	@ApiModelProperty(value = "模板编号", required = false, notes = "[模板编号]")
	private Long tplRid;

    /**文件创建器*/
	@ApiModelProperty(value = "文件创建器", required = false, notes = "[文件创建器]")
	private String fileCreater;

    /**文件编辑器*/
	@ApiModelProperty(value = "文件编辑器", required = false, notes = "[文件编辑器]")
	private String fileEditor;

    /**是否可修改*/
	@ApiModelProperty(value = "是否可修改", required = false, notes = "[是否可修改]-0:不可修改；1：可修改")
	private Integer revisability;

    /**创建用户代码*/
	@ApiModelProperty(value = "创建用户代码", required = false, notes = "[创建用户代码]")
	private String createUcode;

    /**创建用户姓名*/
	@ApiModelProperty(value = "创建用户姓名", required = false, notes = "[创建用户姓名]")
	private String createUname;

    /**修改用户代码*/
	@ApiModelProperty(value = "修改用户代码", required = false, notes = "[修改用户代码]")
	private String cmodifyUcode;

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

	public Integer getSeq(){
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public Long getTplRid(){
		return tplRid;
	}
	public void setTplRid(Long tplRid) {
		this.tplRid = tplRid;
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
