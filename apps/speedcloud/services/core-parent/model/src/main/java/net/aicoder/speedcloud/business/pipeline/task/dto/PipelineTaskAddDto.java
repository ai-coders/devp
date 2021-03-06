package net.aicoder.speedcloud.business.pipeline.task.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;


/**
 * 任务
 * @author icode
 */
@ApiModel(value = "新增任务使用的DTO")
public class PipelineTaskAddDto {

    /**租户id*/
	@ApiModelProperty(value = "租户id", required = false)
	private Long tid;

    /**任务名称*/
	@ApiModelProperty(value = "任务名称", required = true)
	private String name;

    /**任务类型*/
	@ApiModelProperty(value = "任务类型", required = false)
    private String taskType;

    /**执行计划*/
	@ApiModelProperty(value = "执行计划", required = false, notes = "手工，每日，每周")
    private String execType;

    /**执行开始时间*/
	@ApiModelProperty(value = "执行开始时间", required = false, notes = "数据格式 HH:ss")
	private String taskStartTime;

    /**执行日*/
	@ApiModelProperty(value = "执行日", required = false, notes = "1,2,3,4,5,6,7")
	private String taskDayOfWeeks;

    /**任务描述*/
	@ApiModelProperty(value = "任务描述", required = false)
	private String description;

    /**所属产品*/
	@ApiModelProperty(value = "所属产品", required = false)
	private Long project;


	/**步骤的操作列表*/
	@ApiModelProperty(value = "步骤的操作列表", required = true)
	List<PipelineTaskActionAddDto> actions;

	/**步骤的参数列表*/
	@ApiModelProperty(value = "步骤的参数列表", required = true)
	List<PipelineTaskParamAddDto> params;

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

    public String getTaskType(){
        return taskType;
    }
    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getExecType(){
        return execType;
    }
    public void setExecType(String execType) {
        this.execType = execType;
    }

	public String getTaskStartTime(){
		return taskStartTime;
	}
	public void setTaskStartTime(String taskStartTime) {
		this.taskStartTime = taskStartTime;
	}

	public String getTaskDayOfWeeks(){
		return taskDayOfWeeks;
	}
	public void setTaskDayOfWeeks(String taskDayOfWeeks) {
		this.taskDayOfWeeks = taskDayOfWeeks;
	}

	public String getDescription(){
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Long getProject(){
        return project;
    }
    public void setProject(Long project) {
        this.project = project;
    }

	public List<PipelineTaskActionAddDto> getActions() {
		return actions;
	}
	public void setActions(List<PipelineTaskActionAddDto> actions) {
		this.actions = actions;
	}

	public List<PipelineTaskParamAddDto> getParams() {
		return params;
	}
	public void setParams(List<PipelineTaskParamAddDto> params) {
		this.params = params;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
