package net.aicoder.devp.business.deploy.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;




/**
* 部署主机节点的值对象
*/
@ApiModel(value = "展现部署主机节点的值对象")
public class DevpSysDpyHostVO {

    @ApiModelProperty(value = "记录id")
    private Long id;


    @ApiModelProperty(value = "租户编号", notes = "[租户编号]")
    private Long tid;


    /**元素类型*/
    @ApiModelProperty(value = "元素类型", notes = "[元素类型]-SYS_DPY_RES_INST // 关联资源实例")
    private String etype;


    /**系统元素名称*/
    @ApiModelProperty(value = "系统元素名称", notes = "[系统元素名称]")
    private String name;


    /**系统元素代码*/
    @ApiModelProperty(value = "系统元素代码", notes = "[系统元素代码]")
    private String code;


    /**系统元素别名*/
    @ApiModelProperty(value = "系统元素别名", notes = "[系统元素别名]")
    private String alias;


    /**系统元素描述*/
    @ApiModelProperty(value = "系统元素描述", notes = "[系统元素描述]")
    private String description;


    @ApiModelProperty(value = "记录状态", notes = "[记录状态]-0-失效;1-生效;缺省为1")
    private Integer recordState;


    /**主机标识*/
    @ApiModelProperty(value = "主机标识", notes = "[主机标识]-同一个部署方案中不能重复")
    private String flag;


    /**类型*/
    @ApiModelProperty(value = "类型", notes = "[类型]")
    private String type;


    /**子类型*/
    @ApiModelProperty(value = "子类型", notes = "[子类型]")
    private String subType;


    /**状态*/
    @ApiModelProperty(value = "状态", notes = "[状态]")
    private String status;


    /**内部访问地址*/
    @ApiModelProperty(value = "内部访问地址", notes = "[内部访问地址]-内部访问地址，如：内网IP")
    private String intAccessAddr;


    /**外部访问地址*/
    @ApiModelProperty(value = "外部访问地址", notes = "[外部访问地址]-内部访问地址，如：内网IP")
    private String extAccessAddr;


    /**备注*/
    @ApiModelProperty(value = "备注", notes = "[备注]")
    private String notes;


    @ApiModelProperty(value = "产品编号", notes = "[产品编号]")
    private Long prdRid;


    @ApiModelProperty(value = "部署方案编号", notes = "[部署方案编号]")
    private Long schemeRid;


    @ApiModelProperty(value = "顺序号", notes = "[顺序号]")
    private Integer seq;


    @ApiModelProperty(value = "关联IT资产编号", notes = "[关联IT资产编号]")
    private Long assetRid;


    /**关联IT资产元素类型*/
    @ApiModelProperty(value = "关联IT资产元素类型", notes = "[关联IT资产元素类型]")
    private String assetEtype;


    /**关联IT资产类型代码*/
    @ApiModelProperty(value = "关联IT资产类型代码", notes = "[关联IT资产类型代码]")
    private String assetTypeCode;


    /**创建用户代码*/
    @ApiModelProperty(value = "创建用户代码", notes = "[创建用户代码]")
    private String createUcode;


    /**创建用户姓名*/
    @ApiModelProperty(value = "创建用户姓名", notes = "[创建用户姓名]")
    private String createUname;


    /**修改用户代码*/
    @ApiModelProperty(value = "修改用户代码", notes = "[修改用户代码]")
    private String modifyUcode;


    /**修改用户姓名*/
    @ApiModelProperty(value = "修改用户姓名", notes = "[修改用户姓名]")
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

    public String getFlag(){
        return flag;
    }
    public void setFlag(String flag) {
        this.flag = flag;
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

    public String getStatus(){
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getIntAccessAddr(){
        return intAccessAddr;
    }
    public void setIntAccessAddr(String intAccessAddr) {
        this.intAccessAddr = intAccessAddr;
    }

    public String getExtAccessAddr(){
        return extAccessAddr;
    }
    public void setExtAccessAddr(String extAccessAddr) {
        this.extAccessAddr = extAccessAddr;
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

    public Integer getSeq(){
        return seq;
    }
    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Long getAssetRid(){
        return assetRid;
    }
    public void setAssetRid(Long assetRid) {
        this.assetRid = assetRid;
    }

    public String getAssetEtype(){
        return assetEtype;
    }
    public void setAssetEtype(String assetEtype) {
        this.assetEtype = assetEtype;
    }

    public String getAssetTypeCode(){
        return assetTypeCode;
    }
    public void setAssetTypeCode(String assetTypeCode) {
        this.assetTypeCode = assetTypeCode;
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


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}