package net.aicoder.speedcloud.business.pipeline.task.dto;

import com.yunkang.saas.common.framework.eo.SaaSCondition;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


@ApiModel(value = "查询操作属性使用的DTO")
public class PipelineTaskActionPropertyCondition extends SaaSCondition{

	@ApiModelProperty(value = "租户id")
	private Long tid;
	@ApiModelProperty(value = "租户id最大值")
	private Long tidMax;
	@ApiModelProperty(value = "租户id最小值")
	private Long tidMin;
    @ApiModelProperty(value = "所属操作", notes = "")
    private Long taskType;
	@ApiModelProperty(value = "属性名称")
	private String name;
	@ApiModelProperty(value = "属性代码")
	private String code;
	@ApiModelProperty(value = "属性值", notes = "执行时最终使用的值")
	private String value;
	@ApiModelProperty(value = "排序")
	private Integer viewOrder;
	@ApiModelProperty(value = "排序最大值")
	private Integer viewOrderMax;
	@ApiModelProperty(value = "排序最小值")
	private Integer viewOrderMin;
	@ApiModelProperty(value = "类型")
	private String type;


	public Long getTid(){
		return tid;
	}
	public void setTid(Long tid) {
		this.tid = tid;
	}

	public Long getTidMin(){
		return tidMin;
	}
	public void setTidMin(Long tidMin) {
		this.tidMin = tidMin;
	}

	public Long getTidMax(){
		return tidMax;
	}
	public void setTidMax(Long tidMax) {
		this.tidMax = tidMax;
	}


    public Long getTaskType(){
        return taskType;
    }
    public void setTaskType(Long taskType) {
        this.taskType = taskType;
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


	public String getValue(){
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}


	public Integer getViewOrder(){
		return viewOrder;
	}
	public void setViewOrder(Integer viewOrder) {
		this.viewOrder = viewOrder;
	}

	public Integer getViewOrderMin(){
		return viewOrderMin;
	}
	public void setViewOrderMin(Integer viewOrderMin) {
		this.viewOrderMin = viewOrderMin;
	}

	public Integer getViewOrderMax(){
		return viewOrderMax;
	}
	public void setViewOrderMax(Integer viewOrderMax) {
		this.viewOrderMax = viewOrderMax;
	}


	public String getType(){
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}




	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
