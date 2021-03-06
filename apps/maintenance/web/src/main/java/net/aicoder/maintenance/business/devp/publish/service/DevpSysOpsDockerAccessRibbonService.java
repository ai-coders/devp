package net.aicoder.maintenance.business.devp.publish.service;

import com.yunkang.saas.common.framework.exception.BusinessException;
import com.yunkang.saas.common.framework.web.controller.PageContent;
import com.yunkang.saas.common.framework.web.data.PageSearchRequest;
import net.aicoder.devp.client.publish.DevpSysOpsDockerAccessRibbon;
import net.aicoder.devp.client.publish.result.DevpSysOpsDockerAccessPageResult;
import net.aicoder.devp.client.publish.result.DevpSysOpsDockerAccessResult;
import net.aicoder.devp.business.publish.dto.DevpSysOpsDockerAccessCondition;
import net.aicoder.devp.business.publish.dto.DevpSysOpsDockerAccessAddDto;
import net.aicoder.devp.business.publish.dto.DevpSysOpsDockerAccessEditDto;
import net.aicoder.devp.business.publish.vo.DevpSysOpsDockerAccessVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("devpSysOpsDockerAccessRibbonService")
public class DevpSysOpsDockerAccessRibbonService  {

	private static final Logger LOGGER = LoggerFactory.getLogger(DevpSysOpsDockerAccessRibbonService.class);


	@Autowired
	private DevpSysOpsDockerAccessRibbon devpSysOpsDockerAccessRibbon;


	public DevpSysOpsDockerAccessVO add(DevpSysOpsDockerAccessAddDto addDto){
		DevpSysOpsDockerAccessResult result = devpSysOpsDockerAccessRibbon.add(addDto);

		if(!result.isSuccess()){
			throw new BusinessException("DEVP", "PUBLISH", result.getCode()+"", result.getMessage());
		}
		return result.getData();
	
	}

	public void delete(Long id){
		if(null == id){
			LOGGER.warn("try delete T by empty id. Code need check");
			return ;
		}
		LOGGER.debug("delete t:{}", id);
		DevpSysOpsDockerAccessResult result = devpSysOpsDockerAccessRibbon.delete(id);
		if(!result.isSuccess()){
			throw new BusinessException("DEVP", "PUBLISH", result.getCode()+"", result.getMessage());
		}
	}
	public DevpSysOpsDockerAccessVO merge(Long id, DevpSysOpsDockerAccessEditDto editDto){
		DevpSysOpsDockerAccessResult result = devpSysOpsDockerAccessRibbon.update(id, editDto);

		if(!result.isSuccess()){
			throw new BusinessException("DEVP", "PUBLISH", result.getCode()+"", result.getMessage());
		}

		return result.getData();
	}
	public DevpSysOpsDockerAccessVO find(Long id){
		DevpSysOpsDockerAccessResult result = devpSysOpsDockerAccessRibbon.get(id);

		if(!result.isSuccess()){
			throw new BusinessException("DEVP", "PUBLISH", result.getCode()+"", result.getMessage());
		}

		return result.getData();
	}

	public PageContent<DevpSysOpsDockerAccessVO> list(PageSearchRequest<DevpSysOpsDockerAccessCondition> pageSearchRequest) {
		DevpSysOpsDockerAccessPageResult result = devpSysOpsDockerAccessRibbon.list(pageSearchRequest);

		if(!result.isSuccess()){
			throw new BusinessException("DEVP", "PUBLISH", result.getCode()+"", result.getMessage());
		}

		return result.getData();
	}
}
