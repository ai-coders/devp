package com.kingzoo.kingcat.project.icode4.business.microservice.controller.vo;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * 传输对象属性
 * @author icode
 */
public class TransModelPropertyAddRequest {

	public static final String PROPERTY_NAME = "name";
	public static final String PROPERTY_CODE = "code";
	public static final String PROPERTY_TYPE = "type";
	public static final String PROPERTY_TRANS_MODEL_ID = "transModelId";
	public static final String PROPERTY_EDITABLE = "editable";
	public static final String PROPERTY_NULLABLE = "nullable";
	public static final String PROPERTY_MEMO = "memo";
	public static final String PROPERTY_CORE_RELATION = "coreRelation";
	public static final String PROPERTY_DOMAIN_MODEL_ID = "domainModelId";
	public static final String PROPERTY_DOMAIN_MODEL_PROPERTY_ID = "domainModelPropertyId";

    /**
	 * 属性名
	 * 
     */
	@NotNull(message = "属性名不能为空")
	@Size(max = 255, message = "属性名超长，最多255个字符")
	private String name;

    /**
	 * 属性代码
	 * 
     */
	@NotNull(message = "属性代码不能为空")
	@Size(max = 255, message = "属性代码超长，最多255个字符")
	private String code;

    /**
	 * 属性类型
	 * 
     */
	@NotNull(message = "属性类型不能为空")
	@Size(max = 255, message = "属性类型超长，最多255个字符")
	private String type;

    /**
	 * 所属传输对象
	 * 
     */
	@NotNull(message = "所属传输对象不能为空")
	private String transModelId;
	private String transModelName;

    /**
	 * 可修改
	 * 
     */
	@NotNull(message = "可修改不能为空")
	private Boolean editable;

    /**
	 * 可为空
	 * 
     */
	@NotNull(message = "可为空不能为空")
	private Boolean nullable;

    /**
	 * 备注
	 * 
     */
	@Size(max = 255, message = "备注超长，最多255个字符")
	private String memo;

    /**
	 * 核心对象属性
	 * 
     */
	@NotNull(message = "核心对象属性不能为空")
	private Boolean coreRelation;

    /**
	 * 关联对象
	 * 
     */
	@NotNull(message = "关联对象不能为空")
	private String domainModelId;
	private String domainModelName;

    /**
	 * 关联对象属性
	 * 
     */
	@NotNull(message = "关联对象属性不能为空")
	private String domainModelPropertyId;
	private String domainModelPropertyName;


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

	public String getType(){
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getTransModelId(){
		return transModelId;
	}
	public void setTransModelId(String transModelId) {
		this.transModelId = transModelId;
	}
	public String getTransModelName(){
		return transModelName;
	}
	public void setTransModelName(String transModelName) {
		this.transModelName = transModelName;
	}

	public Boolean getEditable(){
		return editable;
	}
	public void setEditable(Boolean editable) {
		this.editable = editable;
	}

	public Boolean getNullable(){
		return nullable;
	}
	public void setNullable(Boolean nullable) {
		this.nullable = nullable;
	}

	public String getMemo(){
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Boolean getCoreRelation(){
		return coreRelation;
	}
	public void setCoreRelation(Boolean coreRelation) {
		this.coreRelation = coreRelation;
	}

	public String getDomainModelId(){
		return domainModelId;
	}
	public void setDomainModelId(String domainModelId) {
		this.domainModelId = domainModelId;
	}
	public String getDomainModelName(){
		return domainModelName;
	}
	public void setDomainModelName(String domainModelName) {
		this.domainModelName = domainModelName;
	}

	public String getDomainModelPropertyId(){
		return domainModelPropertyId;
	}
	public void setDomainModelPropertyId(String domainModelPropertyId) {
		this.domainModelPropertyId = domainModelPropertyId;
	}
	public String getDomainModelPropertyName(){
		return domainModelPropertyName;
	}
	public void setDomainModelPropertyName(String domainModelPropertyName) {
		this.domainModelPropertyName = domainModelPropertyName;
	}


	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
