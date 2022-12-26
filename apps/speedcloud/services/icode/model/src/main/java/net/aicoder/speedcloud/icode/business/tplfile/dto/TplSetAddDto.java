package net.aicoder.speedcloud.icode.business.tplfile.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 公共代码模板集合
 * @author icode
 */
@ApiModel(value = "新增公共代码模板集合使用的DTO")
@Setter @Getter
public class TplSetAddDto {

    /**租户id*/
	@ApiModelProperty(value = "租户id", required = false)
	private Long tid;

    /**集合代码*/
	@ApiModelProperty(value = "集合代码", required = false, notes = "")
	private String code;

    /**集合名称*/
	@ApiModelProperty(value = "集合名称", required = false, notes = "")
	private String name;

    /**parent_id*/
	@ApiModelProperty(value = "parent_id", required = false, notes = "")
	private String parentId;

    /**集合类型*/
	@ApiModelProperty(value = "集合类型", required = false, notes = "")
	private String type;

    /**集合描述*/
	@ApiModelProperty(value = "集合描述", required = false, notes = "")
	private String description;


	public Long getTid(){
		return tid;
	}
	public void setTid(Long tid) {
		this.tid = tid;
	}

	public String getCode(){
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getName(){
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getParentId(){
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getType(){
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getDescription(){
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}