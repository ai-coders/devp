package com.yunkang.saas.bootstrap.platform.business.tenant.domain;

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
 * 租户
 * @author icode
 */
@Entity(name = "platform_tenant")
@Table(appliesTo = "platform_tenant", comment = "[租户]")
//@DynamicUpdate
//@DynamicInsert
public class Tenant extends SaaSEntity<Long>{

	public static final String PROPERTY_TENANT_CODE = "tenantCode";
	public static final String PROPERTY_TENANT_TYPE = "tenantType";
	public static final String PROPERTY_NAME = "name";
	public static final String PROPERTY_COUNTRY = "country";
	public static final String PROPERTY_PROVINCE = "province";
	public static final String PROPERTY_CITY = "city";
	public static final String PROPERTY_ADDRESS = "address";
	public static final String PROPERTY_FAX = "fax";
	public static final String PROPERTY_TELEPHONE_NO = "telephoneNo";
	public static final String PROPERTY_CRM_CODE = "crmCode";
	public static final String PROPERTY_PREFIX_DOMAIN_NAME = "prefixDomainName";
	public static final String PROPERTY_MOBILE = "mobile";
	public static final String PROPERTY_STATUS = "status";


    @Id
    @Column(name = "id")
    private Long id;


    /**
    * 租户代号
    * 
    */
    @Column(name = "tenant_code", unique = true, updatable = false, nullable = false)
	@Size(max = 255, message = "租户代号超长，最多255个字符")
	private String tenantCode;

    /**
    * 租户类型
    * 
    */
    @Column(name = "tenant_type", updatable = false)
	private Long tenantType;

    /**
    * 租户名称
    * 
    */
    @Column(name = "name")
	@NotNull(message = "租户名称不能为空")
	@Size(max = 255, message = "租户名称超长，最多255个字符")
	private String name;

    /**
    * 国家
    * 
    */
    @Column(name = "country")
	@Size(max = 255, message = "国家超长，最多255个字符")
	private String country;

    /**
    * 省份
    * 
    */
    @Column(name = "province")
	@Size(max = 255, message = "省份超长，最多255个字符")
	private String province;

    /**
    * 市、县
    * 
    */
    @Column(name = "city")
	@Size(max = 255, message = "市、县超长，最多255个字符")
	private String city;

    /**
    * 详细地址
    * 
    */
    @Column(name = "address")
	@Size(max = 255, message = "详细地址超长，最多255个字符")
	private String address;

    /**
    * 传真
    * 
    */
    @Column(name = "fax")
	@Size(max = 255, message = "传真超长，最多255个字符")
	private String fax;

    /**
    * 联系电话
    * 
    */
    @Column(name = "telephone_no")
	@Size(max = 255, message = "联系电话超长，最多255个字符")
	private String telephoneNo;

    /**
    * CRM系统代码
    * 
    */
    @Column(name = "crm_code")
	@Size(max = 255, message = "CRM系统代码超长，最多255个字符")
	private String crmCode;

    /**
    * 域名前缀
    * 
    */
    @Column(name = "prefix_domain_name")
	@Size(max = 255, message = "域名前缀超长，最多255个字符")
	private String prefixDomainName;

    /**
    * 号码
    * 
    */
    @Column(name = "mobile")
	private Long mobile;

    /**
    * 启用
    * 
    */
    @Column(name = "status")
	private Boolean status;

	public String getTenantCode(){
		return tenantCode;
	}
	public void setTenantCode(String tenantCode) {
		this.tenantCode = tenantCode;
	}

	public Long getTenantType(){
		return tenantType;
	}
	public void setTenantType(Long tenantType) {
		this.tenantType = tenantType;
	}

	public String getName(){
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getCountry(){
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince(){
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity(){
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress(){
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getFax(){
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getTelephoneNo(){
		return telephoneNo;
	}
	public void setTelephoneNo(String telephoneNo) {
		this.telephoneNo = telephoneNo;
	}

	public String getCrmCode(){
		return crmCode;
	}
	public void setCrmCode(String crmCode) {
		this.crmCode = crmCode;
	}

	public String getPrefixDomainName(){
		return prefixDomainName;
	}
	public void setPrefixDomainName(String prefixDomainName) {
		this.prefixDomainName = prefixDomainName;
	}

	public Long getMobile(){
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public Boolean getStatus(){
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
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

