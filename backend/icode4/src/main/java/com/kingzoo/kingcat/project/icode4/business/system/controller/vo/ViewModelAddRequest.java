package com.kingzoo.kingcat.project.icode4.business.system.controller.vo;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * 展现对象
 * @author icode
 */
public class ViewModelAddRequest {

	public static final String PROPERTY_NAME = "name";
	public static final String PROPERTY_CODE = "code";
	public static final String PROPERTY_MEMO = "memo";
	public static final String PROPERTY_MODEL_TYPE_ID = "modelTypeId";
	public static final String PROPERTY_DESCIPTION = "description";
	public static final String PROPERTY_DOMAIN_MODEL_ID = "domainModelId";

    /**
	 * 对象名称
	 * 
     */
	@NotNull(message = "对象名称不能为空")
	@Size(max = 255, message = "对象名称超长，最多255个字符")
	private String name;

    /**
	 * 对象代码
	 * 
     */
	@NotNull(message = "对象代码不能为空")
	@Size(max = 255, message = "对象代码超长，最多255个字符")
	private String code;

    /**
	 * 备注
	 * 
     */
	@NotNull(message = "备注不能为空")
	@Size(max = 255, message = "备注超长，最多255个字符")
	private String memo;

    /**
	 * 对象类型
	 * 
     */
	@NotNull(message = "对象类型不能为空")
	private String modelTypeId;
	private String modelTypeName;

    /**
	 * 描述
	 * 
     */
	@NotNull(message = "描述不能为空")
	@Size(max = 255, message = "描述超长，最多255个字符")
	private String description;

    /**
	 * 所属领域对象
	 * 
     */
	@NotNull(message = "所属领域对象不能为空")
	private String domainModelId;
	private String domainModelName;


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

	public String getMemo(){
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getModelTypeId(){
		return modelTypeId;
	}
	public void setModelTypeId(String modelTypeId) {
		this.modelTypeId = modelTypeId;
	}
	public String getModelTypeName(){
		return modelTypeName;
	}
	public void setModelTypeName(String modelTypeName) {
		this.modelTypeName = modelTypeName;
	}

	public String getDescription(){
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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


	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
