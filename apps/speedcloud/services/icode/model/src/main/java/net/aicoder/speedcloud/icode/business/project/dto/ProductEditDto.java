package net.aicoder.speedcloud.icode.business.project.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 产品
 * @author icode
 */
@ApiModel(value = "修改产品使用的DTO")
@Setter @Getter
public class ProductEditDto {


	/**名称*/
	@ApiModelProperty(value = "名称", required = false, notes = "")
	private String productName;


	/**代码*/
	@ApiModelProperty(value = "代码", required = false, notes = "")
	private String productCode;


	/**描述*/
	@ApiModelProperty(value = "描述", required = false, notes = "")
	private String description;


	/**已失效*/
	@ApiModelProperty(value = "已失效", required = false)
	private Boolean disabled;



	public String getProductName(){
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getProductCode(){
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}


	public String getDescription(){
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


	public Boolean getDisabled(){
		return disabled;
	}
	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}


	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}