package com.yunkang.saas.bootstrap.platform.business.application.domain;

import com.yunkang.saas.common.jpa.SaaSEntity;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * 应用密码
 * @author icode
 */
@Entity(name = "platform_application_password")
@Table(appliesTo = "platform_application_password", comment = "[应用密码]")
//@DynamicUpdate
//@DynamicInsert
public class ApplicationPassword extends SaaSEntity<Long>{

	public static final String PROPERTY_APP_ID = "appId";
	public static final String PROPERTY_ACCESS_ID = "accessId";
	public static final String PROPERTY_ACCESS_KEY = "accessKey";


    @Id
    @Column(name = "id")
    private Long id;


    /**
    * 应用Id
    * 
    */
    @Column(name = "app_id")
	@NotNull(message = "应用Id不能为空")
	private Long appId;

    /**
    * 访问ID
    * 
    */
    @Column(name = "access_id")
	@NotNull(message = "访问ID不能为空")
	@Size(max = 255, message = "访问ID超长，最多255个字符")
	private String accessId;

    /**
    * 访问密码
    * 
    */
    @Column(name = "access_key")
	@NotNull(message = "访问密码不能为空")
	@Size(max = 255, message = "访问密码超长，最多255个字符")
	private String accessKey;

	public Long getAppId(){
		return appId;
	}
	public void setAppId(Long appId) {
		this.appId = appId;
	}

	public String getAccessId(){
		return accessId;
	}
	public void setAccessId(String accessId) {
		this.accessId = accessId;
	}

	public String getAccessKey(){
		return accessKey;
	}
	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
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

