package net.aicoder.speedcloud.asset.business.asset.info.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;


/**
 * IT资产归属
 * @author icode
 */
@ApiModel(value = "新增IT资产归属使用的DTO")
public class AssetOwnershipAddDto {

    /**租户编号*/
	@ApiModelProperty(value = "租户编号", required = false, notes = "[租户编号]")
	private Long tid;

    /**资产名称*/
	@ApiModelProperty(value = "资产名称", required = false, notes = "")
	private String name;

    /**资产代码*/
	@ApiModelProperty(value = "资产代码", required = false, notes = "")
	private String code;

    /**资产大类*/
	@ApiModelProperty(value = "资产大类", required = false)
	private Long category;

    /**资产分类*/
	@ApiModelProperty(value = "资产分类", required = false)
	private Long type;

    /**资产分类代码*/
	@ApiModelProperty(value = "资产分类代码", required = false, notes = "")
	private String typeCode;

    /**资产分类名称*/
	@ApiModelProperty(value = "资产分类名称", required = false, notes = "")
	private String typeName;

    /**资产部门*/
	@ApiModelProperty(value = "资产部门", required = false, notes = "")
	private String assetDept;

    /**资产负责人*/
	@ApiModelProperty(value = "资产负责人", required = false, notes = "")
	private String assetManager;

    /**使用部门*/
	@ApiModelProperty(value = "使用部门", required = false, notes = "")
	private String useDept;

    /**使用负责人*/
	@ApiModelProperty(value = "使用负责人", required = false, notes = "")
	private String useManager;

    /**操作部门*/
	@ApiModelProperty(value = "操作部门", required = false, notes = "")
	private String opsDept;

    /**操作负责人*/
	@ApiModelProperty(value = "操作负责人", required = false, notes = "")
	private String opsManager;

    /**业务线*/
	@ApiModelProperty(value = "业务线", required = false, notes = "")
	private String bizLine;

    /**业务负责人*/
	@ApiModelProperty(value = "业务负责人", required = false, notes = "")
	private String bizManager;

    /**启用时间*/
	@ApiModelProperty(value = "启用时间", required = false, notes = "[启用时间]-启用时间(产品首次上线时间)")
	@Temporal(TemporalType.DATE)
	private Date goliveDate;

    /**主要客户*/
	@ApiModelProperty(value = "主要客户", required = false, notes = "")
	private String majorCust;

    /**客户负责人*/
	@ApiModelProperty(value = "客户负责人", required = false, notes = "")
	private String custManager;

    /**客户使用情况*/
	@ApiModelProperty(value = "客户使用情况", required = false, notes = "")
	private String custUsage;

    /**供应商*/
	@ApiModelProperty(value = "供应商", required = false, notes = "")
	private String acquisitionProvider;


	public Long getTid(){
		return tid;
	}
	public void setTid(Long tid) {
		this.tid = tid;
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

	public Long getCategory(){
        return category;
    }
    public void setCategory(Long category) {
        this.category = category;
    }

	public Long getType(){
        return type;
    }
    public void setType(Long type) {
        this.type = type;
    }

	public String getTypeCode(){
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getTypeName(){
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getAssetDept(){
		return assetDept;
	}
	public void setAssetDept(String assetDept) {
		this.assetDept = assetDept;
	}

	public String getAssetManager(){
		return assetManager;
	}
	public void setAssetManager(String assetManager) {
		this.assetManager = assetManager;
	}

	public String getUseDept(){
		return useDept;
	}
	public void setUseDept(String useDept) {
		this.useDept = useDept;
	}

	public String getUseManager(){
		return useManager;
	}
	public void setUseManager(String useManager) {
		this.useManager = useManager;
	}

	public String getOpsDept(){
		return opsDept;
	}
	public void setOpsDept(String opsDept) {
		this.opsDept = opsDept;
	}

	public String getOpsManager(){
		return opsManager;
	}
	public void setOpsManager(String opsManager) {
		this.opsManager = opsManager;
	}

	public String getBizLine(){
		return bizLine;
	}
	public void setBizLine(String bizLine) {
		this.bizLine = bizLine;
	}

	public String getBizManager(){
		return bizManager;
	}
	public void setBizManager(String bizManager) {
		this.bizManager = bizManager;
	}

	public Date getGoliveDate(){
		return goliveDate;
	}
	public void setGoliveDate(Date goliveDate) {
		this.goliveDate = goliveDate;
	}

	public String getMajorCust(){
		return majorCust;
	}
	public void setMajorCust(String majorCust) {
		this.majorCust = majorCust;
	}

	public String getCustManager(){
		return custManager;
	}
	public void setCustManager(String custManager) {
		this.custManager = custManager;
	}

	public String getCustUsage(){
		return custUsage;
	}
	public void setCustUsage(String custUsage) {
		this.custUsage = custUsage;
	}

	public String getAcquisitionProvider(){
		return acquisitionProvider;
	}
	public void setAcquisitionProvider(String acquisitionProvider) {
		this.acquisitionProvider = acquisitionProvider;
	}


	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
