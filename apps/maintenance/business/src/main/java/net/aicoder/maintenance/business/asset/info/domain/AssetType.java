package net.aicoder.maintenance.business.asset.info.domain;

import com.yunkang.saas.common.jpa.BaseEntity;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Table;
import org.hibernate.validator.constraints.NotEmpty;
import com.yunkang.saas.common.framework.eo.GenericBaseEntity;



/**
 * 资产分类
 * @author icode
 */
@Entity
@Table(appliesTo = "asset_type", comment = "[资产分类]")
//@DynamicUpdate
//@DynamicInsert
public class AssetType extends BaseEntity<Long>{

	public static final String PROPERTY_TID = "tid";
	public static final String PROPERTY_NUM = "num";
	public static final String PROPERTY_NAME = "name";
	public static final String PROPERTY_CODE = "code";
	public static final String PROPERTY_USE_MONTH = "useMonth";
	public static final String PROPERTY_VIEW_INDEX = "viewIndex";
	public static final String PROPERTY_PARENT_CODE = "parentCode";
	public static final String PROPERTY_DESCRIPTION = "description";


    @Id
    @Column(name = "id")
    private Long id;


    /**
    * 租户id
    * 
    */
    @Column(name = "tid", nullable = false, updatable = false)
	private Long tid;

    /**
    * 编号
    * 
    */
    @Column(name = "num", nullable = true, updatable = true)
	@Size(max = 255, message = "编号超长，最多255个字符")
	private String num;

    /**
    * 名称
    * 
    */
    @Column(name = "name", nullable = true, updatable = true)
	@Size(max = 255, message = "名称超长，最多255个字符")
	private String name;

    /**
    * 代码
    * 
    */
    @Column(name = "code", nullable = false, updatable = true)
	@Size(max = 255, message = "代码超长，最多255个字符")
	private String code;

    /**
    * 年限(月)
    * 
    */
    @Column(name = "use_month", nullable = true, updatable = true)
	private Integer useMonth;

    /**
    * 展现顺序
    * 
    */
    @Column(name = "view_index", nullable = true, updatable = true)
	@Size(max = 255, message = "展现顺序超长，最多255个字符")
	private String viewIndex;

    /**
    * 上级代码
    * 最上级的时候，显示的是大类的code
    */
    @Column(name = "parent_code", nullable = true, updatable = true)
	@Size(max = 255, message = "上级代码超长，最多255个字符")
	private String parentCode;

    /**
    * 说明
    * 
    */
    @Column(name = "description", nullable = true, updatable = true, length=1999, columnDefinition = "TEXT")
	private String description;

	public Long getTid(){
		return tid;
	}
	public void setTid(Long tid) {
		this.tid = tid;
	}

	public String getNum(){
		return num;
	}
	public void setNum(String num) {
		this.num = num;
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

	public Integer getUseMonth(){
		return useMonth;
	}
	public void setUseMonth(Integer useMonth) {
		this.useMonth = useMonth;
	}

	public String getViewIndex(){
		return viewIndex;
	}
	public void setViewIndex(String viewIndex) {
		this.viewIndex = viewIndex;
	}

	public String getParentCode(){
		return parentCode;
	}
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getDescription(){
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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

