package com.kingzoo.kingcat.project.icode4.business.security.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;


/**
  * 资源的Dto
  *
  */
public class ResourceDto {



    private String id;

    /**
    * 租户id
    */
    private String tenantId;

    /**
    * 上级ID
    */
	private String parentId;

    /**
    * 资源名称
    */
	private String name;

    /**
    * 展现顺序
    */
	private String orderIndex;

    /**
    * 资源链接
    */
	private String url;

    /**
    * 资源类型
    */
	private String type;

    /**
    * 资源代码
    */
	private String code;

    /**
    * 创建人id
    */
    private String createUid;

    /**
    * 创建人姓名
    */
    private String createUname;

    /**
    * 创建时间
    */
    private Date createAt;
	/**
    * 修改人id
    */
    private String modifyUid;

    /**
    * 修改人姓名
    */
    private String modifyUname;

    /**
    * 修改时间
    */
    private Date modifyAt;

	public String getParentId(){
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getName(){
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getOrderIndex(){
		return orderIndex;
	}
	public void setOrderIndex(String orderIndex) {
		this.orderIndex = orderIndex;
	}

	public String getUrl(){
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public String getType(){
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getCode(){
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getCreateUid() {
		return createUid;
	}
	public void setCreateUid(String createUid) {
		this.createUid = createUid;
	}

	public String getCreateUname() {
		return createUname;
	}
	public void setCreateUname(String createUname) {
		this.createUname = createUname;
	}

	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public String getModifyUid() {
        return modifyUid;
    }
    public void setModifyUid(String modifyUid) {
        this.modifyUid = modifyUid;
    }

    public String getModifyUname() {
        return modifyUname;
    }
    public void setModifyUname(String modifyUname) {
        this.modifyUname = modifyUname;
    }

	public Date getModifyAt() {
		return modifyAt;
	}
	public void setModifyAt(Date modifyAt) {
		this.modifyAt = modifyAt;
	}


	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
