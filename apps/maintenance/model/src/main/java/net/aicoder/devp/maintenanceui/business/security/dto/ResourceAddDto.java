package net.aicoder.devp.maintenanceui.business.security.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;




/**
 * 资源
 * @author icode
 */
@ApiModel(value = "新增资源使用的DTO")
public class ResourceAddDto {

	private Long id;
    /**
	 * 资源名
	 * 
     */
	@ApiModelProperty(value = "资源名", required = false)
	@Size(max = 255, message = "资源名超长，最多255个字符")
	private String name;

    /**
	 * 资源链接
	 * 
     */
	@ApiModelProperty(value = "资源链接", required = false)
	@Size(max = 255, message = "资源链接超长，最多255个字符")
	private String url;

    /**
	 * 资源类型
	 * 
     */
	@ApiModelProperty(value = "资源类型", required = false)
	@Size(max = 255, message = "资源类型超长，最多255个字符")
	private String type;

    /**
	 * 资源代码
	 * 
     */
	@ApiModelProperty(value = "资源代码", required = false)
	@Size(max = 255, message = "资源代码超长，最多255个字符")
	private String code;

    /**
	 * 父节点
	 * 
     */
	@ApiModelProperty(value = "父节点", required = false)
	private Long parentId;

    /**
	 * 排序
	 * 
     */
	@ApiModelProperty(value = "排序", required = false)
	private Integer orderIndex;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getName(){
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getUrl(){
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public String getType(){
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getCode(){
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public Long getParentId(){
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Integer getOrderIndex(){
		return orderIndex;
	}
	public void setOrderIndex(Integer orderIndex) {
		this.orderIndex = orderIndex;
	}


	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
