package net.aicoder.speedcloud.business.app.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 应用开发配置
 * @author icode
 */
@ApiModel(value = "新增应用开发配置使用的DTO")
public class AppDevelopConfigAddDto {

    /**租户id*/
	@ApiModelProperty(value = "租户id", required = false)
	private Long tid;

    /**应用*/
	@ApiModelProperty(value = "应用", required = false)
	private Long app;

    /**代码*/
	@ApiModelProperty(value = "代码", required = false, notes = "")
	private Long code;

    /**测试环境DB*/
	@ApiModelProperty(value = "测试环境DB", required = false)
	private String testDatabase;

    /**测试环境域名*/
	@ApiModelProperty(value = "测试环境域名", required = false)
	private String testDomainName;

    /**生产环境DB*/
	@ApiModelProperty(value = "生产环境DB", required = false)
	private String productionDatabase;

    /**生产环境域名*/
	@ApiModelProperty(value = "生产环境域名", required = false)
	private String productionDomainName;


	public Long getTid(){
		return tid;
	}
	public void setTid(Long tid) {
		this.tid = tid;
	}

	public Long getApp(){
        return app;
    }
    public void setApp(Long app) {
        this.app = app;
    }

	public Long getCode(){
        return code;
    }
    public void setCode(Long code) {
        this.code = code;
    }

	public String getTestDatabase(){
		return testDatabase;
	}
	public void setTestDatabase(String testDatabase) {
		this.testDatabase = testDatabase;
	}

	public String getTestDomainName(){
		return testDomainName;
	}
	public void setTestDomainName(String testDomainName) {
		this.testDomainName = testDomainName;
	}

	public String getProductionDatabase(){
		return productionDatabase;
	}
	public void setProductionDatabase(String productionDatabase) {
		this.productionDatabase = productionDatabase;
	}

	public String getProductionDomainName(){
		return productionDomainName;
	}
	public void setProductionDomainName(String productionDomainName) {
		this.productionDomainName = productionDomainName;
	}


	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
