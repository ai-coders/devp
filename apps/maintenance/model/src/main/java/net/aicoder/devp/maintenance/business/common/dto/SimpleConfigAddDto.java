package net.aicoder.devp.maintenance.business.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;




/**
 * 通用配置
 * @author icode
 */
@ApiModel(value = "新增通用配置使用的DTO")
public class SimpleConfigAddDto {

    /**
	 * 租户ID
	 * 
     */
	@ApiModelProperty(value = "租户ID", required = false)
	private Long tid;

    /**
	 * 配置类型
	 * 
     */
	@NotNull(message = "配置类型不能为空")
	@ApiModelProperty(value = "配置类型", required = true)
	@Size(max = 255, message = "配置类型超长，最多255个字符")
	private String configType;

    /**
	 * 展现名称
	 * 
     */
	@NotNull(message = "展现名称不能为空")
	@ApiModelProperty(value = "展现名称", required = true)
	@Size(max = 255, message = "展现名称超长，最多255个字符")
	private String displayName;

    /**
	 * 参数代码
	 * 
     */
	@NotNull(message = "参数代码不能为空")
	@ApiModelProperty(value = "参数代码", required = true)
	@Size(max = 255, message = "参数代码超长，最多255个字符")
	private String code;

    /**
	 * 参数值
	 * 
     */
	@NotNull(message = "参数值不能为空")
	@ApiModelProperty(value = "参数值", required = true)
	@Size(max = 255, message = "参数值超长，最多255个字符")
	private String value;

    /**
	 * 参数说明
	 * 
     */
	@ApiModelProperty(value = "参数说明", required = false)
	private String description;

    /**
	 * 展现顺序
	 * 
     */
	@ApiModelProperty(value = "展现顺序", required = false)
	private Integer vIndex;


	public Long getTid(){
		return tid;
	}
	public void setTid(Long tid) {
		this.tid = tid;
	}

	public String getConfigType(){
		return configType;
	}
	public void setConfigType(String configType) {
		this.configType = configType;
	}

	public String getDisplayName(){
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getCode(){
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getValue(){
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	public String getDescription(){
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getVIndex(){
		return vIndex;
	}
	public void setVIndex(Integer vIndex) {
		this.vIndex = vIndex;
	}


	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
