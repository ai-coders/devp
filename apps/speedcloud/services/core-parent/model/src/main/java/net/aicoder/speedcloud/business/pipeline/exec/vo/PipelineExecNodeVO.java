package net.aicoder.speedcloud.business.pipeline.exec.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;




/**
* 运行实例节点的值对象
*/
@ApiModel(value = "展现运行实例节点的值对象")
public class PipelineExecNodeVO {

    @ApiModelProperty(value = "记录id")
    private Long id;


    /**编号*/
    @ApiModelProperty(value = "编号")
    private String code;


    /**节点名称*/
    @ApiModelProperty(value = "节点名称", notes = "节点或任务的名称")
    private String name;


    /**节点类型*/
    @ApiModelProperty(value = "节点类型", notes = "流水线、阶段、任务")
    private String nodeType;


    /**执行方式*/
    @ApiModelProperty(value = "执行方式", notes = "并行、串行")
    private String execMode;


    /**运行状态*/
    @ApiModelProperty(value = "运行状态", notes = "未开始、等待中、运行中、已结束")
    private String status;


    /**运行结果*/
    @ApiModelProperty(value = "运行结果", notes = "成功、失败")
    private String result;


    /**所属实例*/
    @ApiModelProperty(value = "所属实例")
    private Long exec;
    private PipelineExecInstanceVO execVO;


    /**结果消息*/
    @ApiModelProperty(value = "结果消息")
    private String resultMessage;

    /**结果相关的对象*/
    @ApiModelProperty(value = "结果相关的对象")
    private String resultRelationObj;


    /**开始时间*/
    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    /**调度时间*/
    @ApiModelProperty(value = "调度时间")
    private Date scheduleTime;

    /**结束时间*/
    @ApiModelProperty(value = "结束时间")
    private Date endTime;

    /**耗时(毫秒)*/
    @ApiModelProperty(value = "耗时")
    private Long millisecondsCost;


    /**上级节点*/
    @ApiModelProperty(value = "上级节点")
    private String parentId;


    @ApiModelProperty(value = "关联阶段节点", notes = "")
    private Long stageNode;


    @ApiModelProperty(value = "关联对象ID", notes = "具体流水线、阶段、任务的ID")
    private Long relationObjId;


    @ApiModelProperty(value = "自动运行", notes = "手动、自动")
    private Boolean autoStart;


    @ApiModelProperty(value = "节点排序")
    private Integer execIndex;


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

    public String getNodeType(){
        return nodeType;
    }
    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    public String getExecMode(){
        return execMode;
    }
    public void setExecMode(String execMode) {
        this.execMode = execMode;
    }

    public String getStatus(){
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getResult(){
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }

    public Long getExec(){
        return exec;
    }
    public void setExec(Long exec) {
        this.exec = exec;
    }
    public PipelineExecInstanceVO getExecVO(){
        return execVO;
    }
    public void setExecVO(PipelineExecInstanceVO execVO) {
        this.execVO = execVO;
    }

    public String getResultMessage(){
        return resultMessage;
    }
    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public String getResultRelationObj() {
        return resultRelationObj;
    }
    public void setResultRelationObj(String resultRelationObj) {
        this.resultRelationObj = resultRelationObj;
    }

    public Date getScheduleTime() {
        return scheduleTime;
    }
    public void setScheduleTime(Date scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public Date getStartTime(){
        return startTime;
    }
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getMillisecondsCost() {
        return millisecondsCost;
    }
    public void setMillisecondsCost(Long millisecondsCost) {
        this.millisecondsCost = millisecondsCost;
    }

    public String getParentId(){
        return parentId;
    }
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Long getStageNode(){
        return stageNode;
    }
    public void setStageNode(Long stageNode) {
        this.stageNode = stageNode;
    }

    public Long getRelationObjId(){
        return relationObjId;
    }
    public void setRelationObjId(Long relationObjId) {
        this.relationObjId = relationObjId;
    }

    public Boolean getAutoStart(){
        return autoStart;
    }
    public void setAutoStart(Boolean autoStart) {
        this.autoStart = autoStart;
    }

    public Integer getExecIndex(){
        return execIndex;
    }
    public void setExecIndex(Integer execIndex) {
        this.execIndex = execIndex;
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