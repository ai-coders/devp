package net.aicoder.speedcloud.asset.business.asset.info.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.*;
import net.aicoder.speedcloud.asset.business.asset.config.vo.AssetCategoryVO;
import net.aicoder.speedcloud.asset.business.asset.config.vo.AssetTypeVO;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;




/**
* IT资产的值对象
*/
@ApiModel(value = "展现IT资产的值对象")
public class AssetCmdbVO {

    @ApiModelProperty(value = "记录id")
    private Long id;


    @ApiModelProperty(value = "租户编号", notes = "[租户编号]")
    private Long tid;


    /**资产条码*/
    @ApiModelProperty(value = "资产条码")
    private String barcode;


    /**资产名称*/
    @ApiModelProperty(value = "资产名称", notes = "")
    private String name;


    /**资产代码*/
    @ApiModelProperty(value = "资产代码", notes = "")
    private String code;


    /**资产别名*/
    @ApiModelProperty(value = "资产别名", notes = "")
    private String alias;


    /**资产大类*/
    @ApiModelProperty(value = "资产大类")
    private Long category;
    private AssetCategoryVO categoryVO;


    /**资产大类代码*/
    @ApiModelProperty(value = "资产大类代码")
    private String categoryCode;


    /**资产分类*/
    @ApiModelProperty(value = "资产分类")
    private Long type;
    private AssetTypeVO typeVO;


    /**资产分类代码*/
    @ApiModelProperty(value = "资产分类代码")
    private String typeCode;


    /**计量单位*/
    @ApiModelProperty(value = "计量单位")
    private String unit;


    /**描述*/
    @ApiModelProperty(value = "描述", notes = "")
    private String description;


    /**状态*/
    @ApiModelProperty(value = "状态", notes = "")
    private String status;


    /**创建时间*/
    @ApiModelProperty(value = "创建时间", notes = "[创建时间]-启用时间(产品首次上线时间)")
    private Date createDate;


    /**到期时间*/
    @ApiModelProperty(value = "到期时间", notes = "[到期时间]-到期或报废时间")
    private Date expireDate;


    /**所在区域*/
    @ApiModelProperty(value = "所在区域", notes = "")
    private String assetArea;


    /**所在地址*/
    @ApiModelProperty(value = "所在地址", notes = "")
    private String assetLocation;


    /**获取模式*/
    @ApiModelProperty(value = "获取模式", notes = "")
    private String acquisitionMode;


    /**获取描述*/
    @ApiModelProperty(value = "获取描述", notes = "")
    private String acquisitionDesc;


    /**启用时间*/
    @ApiModelProperty(value = "启用时间", notes = "[启用时间]-启用时间(产品首次上线时间)")
    private Date goliveDate;


    /**notes*/
    @ApiModelProperty(value = "notes", notes = "")
    private String notes;


    public Long getTid(){
        return tid;
    }
    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getBarcode(){
        return barcode;
    }
    public void setBarcode(String barcode) {
        this.barcode = barcode;
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

    public String getAlias(){
        return alias;
    }
    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Long getCategory(){
        return category;
    }
    public void setCategory(Long category) {
        this.category = category;
    }
    public AssetCategoryVO getCategoryVO(){
        return categoryVO;
    }
    public void setCategoryVO(AssetCategoryVO categoryVO) {
        this.categoryVO = categoryVO;
    }

    public String getCategoryCode(){
        return categoryCode;
    }
    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public Long getType(){
        return type;
    }
    public void setType(Long type) {
        this.type = type;
    }
    public AssetTypeVO getTypeVO(){
        return typeVO;
    }
    public void setTypeVO(AssetTypeVO typeVO) {
        this.typeVO = typeVO;
    }

    public String getTypeCode(){
        return typeCode;
    }
    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getUnit(){
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus(){
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateDate(){
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getExpireDate(){
        return expireDate;
    }
    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public String getAssetArea(){
        return assetArea;
    }
    public void setAssetArea(String assetArea) {
        this.assetArea = assetArea;
    }

    public String getAssetLocation(){
        return assetLocation;
    }
    public void setAssetLocation(String assetLocation) {
        this.assetLocation = assetLocation;
    }

    public String getAcquisitionMode(){
        return acquisitionMode;
    }
    public void setAcquisitionMode(String acquisitionMode) {
        this.acquisitionMode = acquisitionMode;
    }

    public String getAcquisitionDesc(){
        return acquisitionDesc;
    }
    public void setAcquisitionDesc(String acquisitionDesc) {
        this.acquisitionDesc = acquisitionDesc;
    }

    public Date getGoliveDate(){
        return goliveDate;
    }
    public void setGoliveDate(Date goliveDate) {
        this.goliveDate = goliveDate;
    }

    public String getNotes(){
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
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