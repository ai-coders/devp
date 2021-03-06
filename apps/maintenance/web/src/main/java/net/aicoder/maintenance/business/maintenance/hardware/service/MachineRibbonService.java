package net.aicoder.maintenance.business.maintenance.hardware.service;

import com.yunkang.saas.common.framework.exception.BusinessException;
import com.yunkang.saas.common.framework.web.controller.PageContent;
import com.yunkang.saas.common.framework.web.data.PageSearchRequest;

import net.aicoder.maintenance.business.hardware.dto.MachineAddDto;
import net.aicoder.maintenance.business.hardware.dto.MachineCondition;
import net.aicoder.maintenance.business.hardware.dto.MachineEditDto;
import net.aicoder.maintenance.business.hardware.vo.MachineVO;
import net.aicoder.maintenance.spi.hardware.MachineRibbon;
import net.aicoder.maintenance.spi.hardware.result.MachinePageResult;
import net.aicoder.maintenance.spi.hardware.result.MachineResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("machineRibbonService")
public class MachineRibbonService  {

	private static final Logger LOGGER = LoggerFactory.getLogger(MachineRibbonService.class);

	@Autowired
	private MachineRibbon machineRibbon;


	public MachineVO add(MachineAddDto addDto){

		MachineResult result = machineRibbon.add(addDto);

		if(!result.isSuccess()){
			throw new BusinessException("DEPLOY", "HARDWARE", result.getCode()+"", result.getMessage());
		}
		return result.getData();
	
	}

	public void delete(Long id){
		if(null == id){
			LOGGER.warn("try delete T by empty id. Code need check");
			return ;
		}
		LOGGER.debug("delete t:{}", id);
		MachineResult result = machineRibbon.delete(id);
		if(!result.isSuccess()){
			throw new BusinessException("DEPLOY", "HARDWARE", result.getCode()+"", result.getMessage());
		}
	}
	public MachineVO merge(Long id, MachineEditDto editDto){
		MachineResult result = machineRibbon.update(id, editDto);

		if(!result.isSuccess()){
			throw new BusinessException("DEPLOY", "HARDWARE", result.getCode()+"", result.getMessage());
		}

		return result.getData();
	}
	public MachineVO find(Long id){
		MachineResult result = machineRibbon.get(id);

		if(!result.isSuccess()){
			throw new BusinessException("DEPLOY", "HARDWARE", result.getCode()+"", result.getMessage());
		}

		return result.getData();
	}

	public PageContent<MachineVO> list(PageSearchRequest<MachineCondition> pageSearchRequest) {
		MachinePageResult result = machineRibbon.list(pageSearchRequest);

		if(!result.isSuccess()){
			throw new BusinessException("DEPLOY", "HARDWARE", result.getCode()+"", result.getMessage());
		}

		return result.getData();
	}
}
