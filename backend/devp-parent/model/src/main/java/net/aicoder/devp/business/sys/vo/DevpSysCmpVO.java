package net.aicoder.devp.business.sys.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;


/**
* 系统组件的值对象
*/
@ApiModel(value = "展现系统组件的值对象")
public class DevpSysCmpVO {

    @ApiModelProperty(value = "记录id")
    private Long id;


    @ApiModelProperty(value = "租户编号", notes = "[租户编号]")
    private Long tid;


    /**元素类型*/
    @ApiModelProperty(value = "元素类型", notes = "[元素类型]- SYSTEM// 系统 SUB_SYS// 子系统 SYS_CMP// 组件 ")
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


    /**类型*/
    @ApiModelProperty(value = "类型", notes = "[类型]")
    private String type;


    /**子类型*/
    @ApiModelProperty(value = "子类型", notes = "[子类型]")
    private String subType;


    /**构造型*/
    @ApiModelProperty(value = "构造型", notes = "[构造型]")
    private String stereotype;


    /**范围*/
    @ApiModelProperty(value = "范围", notes = "[范围]-访问控制范围:产品内可见，同模块可见，模块内可见")
    private String scope;


    /**版本*/
    @ApiModelProperty(value = "版本", notes = "[版本]-当前版本")
    private String version;


    /**阶段*/
    @ApiModelProperty(value = "阶段", notes = "[阶段]-系统调研,系统设计,系统开发,试运行,系统运维,已停用")
    private String phase;


    /**状态*/
    @ApiModelProperty(value = "状态", notes = "[状态]-未开始,进行中,已完成,暂停,取消")
    private String status;


    /**备注*/
    @ApiModelProperty(value = "备注", notes = "[备注]")
    private String notes;


    @ApiModelProperty(value = "可安装组件", notes = "[可安装组件]-是否为可安装组件，0:不可独立安装；1：可安装")
    private Integer installable;


    @ApiModelProperty(value = "共享组件", notes = "[共享组件]-是否为共享组件，0:不共享；1：共享")
    private Integer sharedComponent;


    @ApiModelProperty(value = "共享服务", notes = "[共享服务]-是否提供共享服务，0:不共享；1：共享")
    private Integer sharedService;


    @ApiModelProperty(value = "产品编号", notes = "[产品编号]")
    private Long prdRid;


    @ApiModelProperty(value = "父包编号", notes = "[父包编号]")
    private Long parentRid;


    @ApiModelProperty(value = "顺序号", notes = "[顺序号]")
    private Integer seq;


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


    @ApiModelProperty(value = "组件包含的组件")
    private List<DevpSysCmpVO> devpSysCmpList;

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

    public String getNotes(){
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getInstallable(){
        return installable;
    }
    public void setInstallable(Integer installable) {
        this.installable = installable;
    }

    public Integer getSharedComponent(){
        return sharedComponent;
    }
    public void setSharedComponent(Integer sharedComponent) {
        this.sharedComponent = sharedComponent;
    }

    public Integer getSharedService(){
        return sharedService;
    }
    public void setSharedService(Integer sharedService) {
        this.sharedService = sharedService;
    }

    public Long getPrdRid(){
        return prdRid;
    }
    public void setPrdRid(Long prdRid) {
        this.prdRid = prdRid;
    }

    public Long getParentRid(){
        return parentRid;
    }
    public void setParentRid(Long parentRid) {
        this.parentRid = parentRid;
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

    public List<DevpSysCmpVO> getDevpSysCmpList() {
        return devpSysCmpList;
    }
    public void setDevpSysCmpList(List<DevpSysCmpVO> devpSysCmpList) {
        this.devpSysCmpList = devpSysCmpList;
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