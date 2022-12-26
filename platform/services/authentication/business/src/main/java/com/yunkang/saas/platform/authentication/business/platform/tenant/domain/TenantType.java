package com.yunkang.saas.platform.authentication.business.platform.tenant.domain;

import com.yunkang.saas.common.jpa.BaseEntity;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;



/**
 * 租户类型
 * @author icode
 */
@Entity()
@Table(name = "platform_tenant_type")
//@DynamicUpdate
//@DynamicInsert
//@Where(clause="delete=0")
public class TenantType extends BaseEntity<Long>{

	public static final String PROPERTY_TENANT_TYPE_CODE = "tenantTypeCode";
	public static final String PROPERTY_NAME = "name";


    @Id
    @Column(name = "id")
    private Long id;


    /**
    * 租户类型编码
    * 
    */
    @Column(name = "tenant_type_code", nullable = false, updatable = true)
	@Size(max = 255, message = "租户类型编码超长，最多255个字符")
	private String tenantTypeCode;

    /**
    * 租户类型名称
    * 
    */
    @Column(name = "name", nullable = false, updatable = true)
	@Size(max = 255, message = "租户类型名称超长，最多255个字符")
	private String name;

	public String getTenantTypeCode(){
		return tenantTypeCode;
	}
	public void setTenantTypeCode(String tenantTypeCode) {
		this.tenantTypeCode = tenantTypeCode;
	}

	public String getName(){
		return name;
	}
	public void setName(String name) {
		this.name = name;
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

