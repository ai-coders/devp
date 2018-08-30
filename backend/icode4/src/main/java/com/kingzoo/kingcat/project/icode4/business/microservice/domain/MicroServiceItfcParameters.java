package com.kingzoo.kingcat.project.icode4.business.microservice.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * 微服务接口参数
 * @author icode
 */
@Entity
@Table
public class MicroServiceItfcParameters {

	public static final String PROPERTY_VIEW_INDEX = "viewIndex";
	public static final String PROPERTY_NAME = "name";
	public static final String PROPERTY_CODE = "code";
	public static final String PROPERTY_TYPE = "type";
	public static final String PROPERTY_PATH_MAPPING = "pathMapping";
	public static final String PROPERTY_MEMO = "memo";
	public static final String PROPERTY_MICRO_SERVICE_ITFC_ID = "microServiceItfcId";
	public static final String PROPERTY_REQUIRED = "required";


    @Id
    private String id;


    /**
    * 排序
    * 
    */
    @Column(name = "view_index")
	@NotNull(message = "排序不能为空")
	private Integer viewIndex;

    /**
    * 参数名称
    * 
    */
    @Column(name = "name")
	@NotNull(message = "参数名称不能为空")
	@Size(max = 255, message = "参数名称超长，最多255个字符")
	private String name;

    /**
    * 代码
    * 
    */
    @Column(name = "code")
	@NotNull(message = "代码不能为空")
	@Size(max = 255, message = "代码超长，最多255个字符")
	private String code;

    /**
    * 参数类型
    * 
    */
    @Column(name = "type")
	@NotNull(message = "参数类型不能为空")
	@Size(max = 255, message = "参数类型超长，最多255个字符")
	private String type;

    /**
    * 路径映射
    * 
    */
    @Column(name = "path_mapping")
	@Size(max = 255, message = "路径映射超长，最多255个字符")
	private String pathMapping;

    /**
    * 备注
    * 
    */
    @Column(name = "memo")
	@Size(max = 255, message = "备注超长，最多255个字符")
	private String memo;

    /**
    * 所属微服务接口
    * 
    */
    @Column(name = "micro_service_itfcId")
	@NotNull(message = "所属微服务接口不能为空")
	private String microServiceItfcId;
	@Transient
	private String microServiceItfcName;

    /**
    * 必填
    * 
    */
    @Column(name = "required")
	@NotNull(message = "必填不能为空")
	private Boolean required;

	public Integer getViewIndex(){
		return viewIndex;
	}
	public void setViewIndex(Integer viewIndex) {
		this.viewIndex = viewIndex;
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

	public String getType(){
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getPathMapping(){
		return pathMapping;
	}
	public void setPathMapping(String pathMapping) {
		this.pathMapping = pathMapping;
	}

	public String getMemo(){
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getMicroServiceItfcId(){
		return microServiceItfcId;
	}
	public void setMicroServiceItfcId(String microServiceItfcId) {
		this.microServiceItfcId = microServiceItfcId;
	}
	public String getMicroServiceItfcName(){
		return microServiceItfcName;
	}
	public void setMicroServiceItfcName(String microServiceItfcName) {
		this.microServiceItfcName = microServiceItfcName;
	}

	public Boolean getRequired(){
		return required;
	}
	public void setRequired(Boolean required) {
		this.required = required;
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