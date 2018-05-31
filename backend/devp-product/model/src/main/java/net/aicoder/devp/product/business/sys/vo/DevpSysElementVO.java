package net.aicoder.devp.product.business.sys.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;




/**
* 系统元素的值对象
*/
@ApiModel(value = "展现系统元素的值对象")
public class DevpSysElementVO {

    @ApiModelProperty(value = "记录id")
    private Long id;

    @ApiModelProperty(value = "租户编号")
    /**
    * 租户编号
    * [租户编号]
    */
    private Long tid;

    @ApiModelProperty(value = "系统元素名称")
    /**
    * 系统元素名称
    * [系统元素名称]
    */
    private String name;

    @ApiModelProperty(value = "系统元素代码")
    /**
    * 系统元素代码
    * [系统元素代码]
    */
    private String code;

    @ApiModelProperty(value = "系统元素别名")
    /**
    * 系统元素别名
    * [系统元素别名]
    */
    private String alias;

    @ApiModelProperty(value = "系统元素描述")
    /**
    * 系统元素描述
    * [系统元素描述]
    */
    private String description;

    @ApiModelProperty(value = "系统元素所属类型标识")
    /**
    * 系统元素所属类型标识
    * [系统元素所属类型标识]-CMP-组件,IDE-开发,DPY-部署
    */
    private String elmFlag;

    @ApiModelProperty(value = "类型")
    /**
    * 类型
    * [类型]-SYS-系统/目录，SUB-子系统/子目录，CMPELM-组件,IDEPRJ-开发工程,ENV-环境
    */
    private String type;

    @ApiModelProperty(value = "子类型")
    /**
    * 子类型
    * [子类型]-ENV：NODE,DEVICE,EXEENV,DOCKER
    */
    private String subType;

    @ApiModelProperty(value = "构造型")
    /**
    * 构造型
    * [构造型]
    */
    private String stereotype;

    @ApiModelProperty(value = "范围")
    /**
    * 范围
    * [范围]-访问控制范围:产品内可见，同模块可见，模块内可见
    */
    private String scope;

    @ApiModelProperty(value = "版本")
    /**
    * 版本
    * [版本]-当前版本
    */
    private String version;

    @ApiModelProperty(value = "阶段")
    /**
    * 阶段
    * [阶段]-系统调研,系统设计,系统开发,试运行,系统运维,已停用
    */
    private String phase;

    @ApiModelProperty(value = "状态")
    /**
    * 状态
    * [状态]-未开始,进行中,已完成,暂停,取消
    */
    private String status;

    @ApiModelProperty(value = "产品编号")
    /**
    * 产品编号
    * [产品编号]
    */
    private Long prdRid;

    @ApiModelProperty(value = "父包编号")
    /**
    * 父包编号
    * [父包编号]
    */
    private Long parentRid;

    @ApiModelProperty(value = "顺序号")
    /**
    * 顺序号
    * [顺序号]
    */
    private Integer seq;

    @ApiModelProperty(value = "是否为共享组件")
    /**
    * 是否为共享组件
    * [是否为共享组件]-0:不共享；1：共享
    */
    private Integer sharedComponent;

    @ApiModelProperty(value = "是否提供共享服务")
    /**
    * 是否提供共享服务
    * [是否提供共享服务]-0:不共享；1：共享
    */
    private Integer sharedService;

    @ApiModelProperty(value = "备注")
    /**
    * 备注
    * [备注]
    */
    private String notes;

    @ApiModelProperty(value = "记录状态")
    /**
    * 记录状态
    * [记录状态]-0-失效;1-生效;缺省为1
    */
    private Integer recordState;

    @ApiModelProperty(value = "创建用户代码")
    /**
    * 创建用户代码
    * [创建用户代码]
    */
    private String createUcode;

    @ApiModelProperty(value = "修改用户代码")
    /**
    * 修改用户代码
    * [修改用户代码]
    */
    private String modifyUcode;


    public Long getTid(){
        return tid;
    }
    public void setTid(Long tid) {
        this.tid = tid;
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
    public String getElmFlag(){
        return elmFlag;
    }
    public void setElmFlag(String elmFlag) {
        this.elmFlag = elmFlag;
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
    public String getCreateUcode(){
        return createUcode;
    }
    public void setCreateUcode(String createUcode) {
        this.createUcode = createUcode;
    }
    public String getModifyUcode(){
        return modifyUcode;
    }
    public void setModifyUcode(String modifyUcode) {
        this.modifyUcode = modifyUcode;
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