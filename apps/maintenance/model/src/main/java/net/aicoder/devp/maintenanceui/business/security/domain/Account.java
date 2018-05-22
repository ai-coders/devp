package net.aicoder.devp.maintenanceui.business.security.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotEmpty;
import com.yunkang.saas.common.framework.eo.BaseEntity;



/**
 * 账号
 * @author icode
 */
@Entity
@Table
public class Account extends BaseEntity{

	public static final String PROPERTY_NICK_NAME = "nickName";
	public static final String PROPERTY_NAME = "name";
	public static final String PROPERTY_ACCOUNT_NAME = "accountName";
	public static final String PROPERTY_MOBILE = "mobile";
	public static final String PROPERTY_EMAIL = "email";
	public static final String PROPERTY_ENABLE = "enable";


    @Id
    @Column(name = "rid")
    private Long id;


    /**
    * 昵称
    * 
    */
    @Column(name = "nick_name")
	@NotNull(message = "昵称不能为空")
	@Size(max = 255, message = "昵称超长，最多255个字符")
	private String nickName;

    /**
    * 姓名
    * 
    */
    @Column(name = "name")
	@NotNull(message = "姓名不能为空")
	@Size(max = 255, message = "姓名超长，最多255个字符")
	private String name;

    /**
    * 账号
    * 
    */
    @Column(name = "account_name")
	@Size(max = 255, message = "账号超长，最多255个字符")
	private String accountName;

    /**
    * 手机号
    * 
    */
    @Column(name = "mobile")
	@Size(max = 255, message = "手机号超长，最多255个字符")
	private String mobile;

    /**
    * 邮箱
    * 
    */
    @Column(name = "email")
	@Size(max = 255, message = "邮箱超长，最多255个字符")
	private String email;

    /**
    * 已启用
    * 
    */
    @Column(name = "enable")
	@NotNull(message = "已启用不能为空")
	@Size(max = 255, message = "已启用超长，最多255个字符")
	private String enable;

	public String getNickName(){
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getName(){
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getAccountName(){
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getMobile(){
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail(){
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getEnable(){
		return enable;
	}
	public void setEnable(String enable) {
		this.enable = enable;
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

