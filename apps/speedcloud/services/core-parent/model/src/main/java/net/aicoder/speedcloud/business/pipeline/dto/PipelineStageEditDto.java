package net.aicoder.speedcloud.business.pipeline.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 阶段
 * @author icode
 */
@ApiModel(value = "修改阶段使用的DTO")
public class PipelineStageEditDto {


	/**所属流水线*/
	@ApiModelProperty(value = "所属流水线", required = false)
	private Long pipeline;


	/**阶段名称*/
	@ApiModelProperty(value = "阶段名称", required = false)
	private String name;


	/**流转方式*/
	@ApiModelProperty(value = "流转方式", required = false, notes = "流转到下一阶段方式:自动、手动")
    private String flowType;


	/**执行方式*/
	@ApiModelProperty(value = "执行方式", required = false, notes = "并行、串行、")
    private String execMode;


	/**执行排序*/
	@ApiModelProperty(value = "执行排序", required = false)
	private Integer execOrder;



	public Long getPipeline(){
        return pipeline;
    }
    public void setPipeline(Long pipeline) {
        this.pipeline = pipeline;
    }


	public String getName(){
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


    public String getFlowType(){
        return flowType;
    }
    public void setFlowType(String flowType) {
        this.flowType = flowType;
    }


    public String getExecMode(){
        return execMode;
    }
    public void setExecMode(String execMode) {
        this.execMode = execMode;
    }


	public Integer getExecOrder(){
		return execOrder;
	}
	public void setExecOrder(Integer execOrder) {
		this.execOrder = execOrder;
	}


	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
