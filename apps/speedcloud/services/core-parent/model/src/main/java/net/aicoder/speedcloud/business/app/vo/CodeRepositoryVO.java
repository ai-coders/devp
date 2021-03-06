package net.aicoder.speedcloud.business.app.vo;

import com.yunkang.saas.bootstrap.common.business.simpleconfig.vo.SimpleConfigVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.aicoder.speedcloud.business.config.vo.DevelopTypeVO;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;




/**
* 代码库的值对象
*/
@ApiModel(value = "展现代码库的值对象")
public class CodeRepositoryVO {

    @ApiModelProperty(value = "记录id")
    private Long id;


    /**名称*/
    @ApiModelProperty(value = "名称")
    private String name;


    /**类型*/
    @ApiModelProperty(value = "类型", notes = "git,svn")
    private String type;
    private SimpleConfigVO typeVO;


    /**url*/
    @ApiModelProperty(value = "url")
    private String url;


    /**开发模式*/
    @ApiModelProperty(value = "开发模式")
    private Long developType;
    private DevelopTypeVO developTypeVO;


    /**用户名*/
    @ApiModelProperty(value = "用户名")
    private String username;


    /**描述*/
    @ApiModelProperty(value = "描述")
    private String description;


    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getType(){
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public SimpleConfigVO getTypeVO(){
        return typeVO;
    }
    public void setTypeVO(SimpleConfigVO typeVO) {
        this.typeVO = typeVO;
    }

    public String getUrl(){
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public Long getDevelopType(){
        return developType;
    }
    public void setDevelopType(Long developType) {
        this.developType = developType;
    }
    public DevelopTypeVO getDevelopTypeVO(){
        return developTypeVO;
    }
    public void setDevelopTypeVO(DevelopTypeVO developTypeVO) {
        this.developTypeVO = developTypeVO;
    }

    public String getUsername(){
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
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