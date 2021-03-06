package net.aicoder.speedcloud.business.pipeline.vo;

import com.yunkang.saas.bootstrap.common.business.simpleconfig.vo.SimpleConfigVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;


/**
* 阶段执行节点的值对象
*/
@ApiModel(value = "展现阶段执行节点的值对象")
public class PipelineStageNodeVO {

    @ApiModelProperty(value = "记录id")
    private Long id;


    /**名称*/
    @ApiModelProperty(value = "名称")
    private String name;


    /**阶段*/
    @ApiModelProperty(value = "阶段")
    private Long stage;
    private PipelineStageVO stageVO;


    /**节点类型*/
    @ApiModelProperty(value = "节点类型", notes = "Task和Pipeline")
    private String objType;
    private SimpleConfigVO objTypeVO;


    @ApiModelProperty(value = "节点对象", notes = "节点关联的对象的ID")
    private Long objId;


    @ApiModelProperty(value = "执行排序")
    private Integer execOrder;

    private List<PipelineStageNodeParamVO> ParamList;


    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Long getStage(){
        return stage;
    }
    public void setStage(Long stage) {
        this.stage = stage;
    }
    public PipelineStageVO getStageVO(){
        return stageVO;
    }
    public void setStageVO(PipelineStageVO stageVO) {
        this.stageVO = stageVO;
    }

    public String getObjType(){
        return objType;
    }
    public void setObjType(String objType) {
        this.objType = objType;
    }
    public SimpleConfigVO getObjTypeVO(){
        return objTypeVO;
    }
    public void setObjTypeVO(SimpleConfigVO objTypeVO) {
        this.objTypeVO = objTypeVO;
    }

    public Long getObjId(){
        return objId;
    }
    public void setObjId(Long objId) {
        this.objId = objId;
    }

    public Integer getExecOrder(){
        return execOrder;
    }
    public void setExecOrder(Integer execOrder) {
        this.execOrder = execOrder;
    }

    public List<PipelineStageNodeParamVO> getParamList() {
        return ParamList;
    }
    public void setParamList(List<PipelineStageNodeParamVO> paramList) {
        ParamList = paramList;
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