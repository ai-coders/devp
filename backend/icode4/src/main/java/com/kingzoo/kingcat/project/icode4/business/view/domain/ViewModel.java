package com.kingzoo.kingcat.project.icode4.business.view.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * 展现对象
 * @author icode
 */
@Entity
@Table
public class ViewModel {

	public static final String PROPERTY_NAME = "name";
	public static final String PROPERTY_CODE = "code";
	public static final String PROPERTY_MEMO = "memo";
	public static final String PROPERTY_DESCIPTION = "description";
	public static final String PROPERTY_VIEW_INDEX = "viewIndex";
	public static final String PROPERTY_DOMAIN_MODEL_ID = "domainModelId";
	public static final String PROPERTY_MODULE_ID = "moduleId";


    @Id
    private String id;


    /**
    * 对象名称
    * 
    */
    @Column(name = "name")
	@NotNull(message = "对象名称不能为空")
	@Size(max = 255, message = "对象名称超长，最多255个字符")
	private String name;

    /**
    * 对象代码
    * 
    */
    @Column(name = "code")
	@NotNull(message = "对象代码不能为空")
	@Size(max = 255, message = "对象代码超长，最多255个字符")
	private String code;

    /**
    * 备注
    * 
    */
    @Column(name = "memo")
	@NotNull(message = "备注不能为空")
	@Size(max = 255, message = "备注超长，最多255个字符")
	private String memo;

    /**
    * 描述
    * 
    */
    @Column(name = "description")
	@NotNull(message = "描述不能为空")
	private String description;

    /**
    * 展现排序
    * 
    */
    @Column(name = "view_index")
	private Integer viewIndex;

    /**
    * 所属领域对象
    * 
    */
    @Column(name = "domain_modelId")
	private String domainModelId;
	@Transient
	private String domainModelName;

    /**
    * 所属模块ID
    * 
    */
    @Column(name = "moduleId")
	@NotNull(message = "所属模块ID不能为空")
	private String moduleId;
	@Transient
	private String moduleName;

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

	public String getDescription(){
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getViewIndex(){
		return viewIndex;
	}
	public void setViewIndex(Integer viewIndex) {
		this.viewIndex = viewIndex;
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

	public String getModuleId(){
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	public String getModuleName(){
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}