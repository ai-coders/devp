package net.aicoder.speedcloud.icode.business.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;


/**
* 领域对象的值对象
*/
@ApiModel(value = "展现领域对象的值对象")
@Setter @Getter
public class EntityVO {

    @ApiModelProperty(value = "记录id")
    private String id;


    @ApiModelProperty(value = "实体代码", notes = "")
    private String code;


    @ApiModelProperty(value = "实体名称", notes = "")
    private String name;


    @ApiModelProperty(value = "描述", notes = "")
    private String description;


    @ApiModelProperty(value = "父对象")
    private String parentEntity;


    /**所属聚合*/
    @ApiModelProperty(value = "所属聚合")
    private String aggregate;


    /**所属领域*/
    @ApiModelProperty(value = "所属领域")
    private String domain;
    private DomainVO domainVO;

    /**实体的行为*/
    @ApiModelProperty(value = "实体的行为")
    List<EntityActionVO> actionList;

    /**实体的属性*/
    @ApiModelProperty(value = "实体的属性")
    List<EntityPropertyVO> propertyList;


    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}