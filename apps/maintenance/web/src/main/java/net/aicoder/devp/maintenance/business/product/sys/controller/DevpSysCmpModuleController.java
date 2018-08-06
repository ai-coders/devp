package net.aicoder.devp.maintenance.business.product.sys.controller;

import com.yunkang.saas.common.framework.web.controller.PageContent;
import com.yunkang.saas.common.framework.web.data.PageRequest;
import com.yunkang.saas.common.framework.web.data.PageSearchRequest;
import com.yunkang.saas.security.local.business.service.SecurityUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.aicoder.devp.product.business.sys.dto.DevpSysCmpModuleCondition;
import net.aicoder.devp.product.business.sys.dto.DevpSysCmpModuleAddDto;
import net.aicoder.devp.product.business.sys.dto.DevpSysCmpModuleEditDto;
import net.aicoder.devp.product.business.sys.vo.DevpSysCmpModuleVO;
import net.aicoder.devp.maintenance.business.product.sys.service.DevpSysCmpModuleRibbonService;
import net.aicoder.devp.maintenance.business.product.sys.valid.DevpSysCmpModuleValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.WebDataBinder;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * 管理组件对应模块
 * @author icode
 */
@Api(description = "组件对应模块", tags = "DevpSysCmpModule")
@RestController
@RequestMapping(value = "/sys/devpSysCmpModule")
public class DevpSysCmpModuleController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DevpSysCmpModuleController.class);


	@Autowired
	private DevpSysCmpModuleRibbonService devpSysCmpModuleRibbonService;

	@Autowired
	DevpSysCmpModuleValidator devpSysCmpModuleValidator;

    @InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		webDataBinder.addValidators(devpSysCmpModuleValidator);
	}

	/**
	 * 新增组件对应模块
	 * @param devpSysCmpModuleAddDto
	 * @return
	 */
	@ApiOperation(value = "新增", notes = "新增组件对应模块", httpMethod = "POST")
	@PostMapping
	@ResponseStatus( HttpStatus.CREATED )
	public DevpSysCmpModuleVO add(@RequestBody DevpSysCmpModuleAddDto devpSysCmpModuleAddDto){
		devpSysCmpModuleAddDto.setTid(SecurityUtil.getAccount().getTenantId());
		return  devpSysCmpModuleRibbonService.add(devpSysCmpModuleAddDto);
	}

	/**
	 * 删除组件对应模块,id以逗号分隔
	 * @param idArray
	 */
	@ApiOperation(value = "删除", notes = "删除组件对应模块", httpMethod = "DELETE")
	@DeleteMapping(value="/{idArray}")
	public void delete(@PathVariable String idArray){

	    LOGGER.debug("delete devpSysCmpModule :{}", idArray);

		String[] ids = idArray.split(",");
		for (String id : ids ){
			devpSysCmpModuleRibbonService.delete(Long.parseLong(id));
		}

	}

	/**
	 * 更新组件对应模块
	 * @param devpSysCmpModuleEditDto
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "修改", notes = "修改产组件对应模块(修改全部字段,未传入置空)", httpMethod = "PUT")
	@PutMapping(value="/{id}")
	public DevpSysCmpModuleVO update(@RequestBody DevpSysCmpModuleEditDto devpSysCmpModuleEditDto, @ApiParam(value = "要查询的组件对应模块id") @PathVariable Long id){

		DevpSysCmpModuleVO vo = devpSysCmpModuleRibbonService.merge(id, devpSysCmpModuleEditDto);

		return  vo;
	}

	/**
	 * 根据ID查询组件对应模块
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "查询", notes = "根据ID查询组件对应模块", httpMethod = "GET")
	@GetMapping(value="/{id}")
	public DevpSysCmpModuleVO get(@ApiParam(value = "要查询的组件对应模块id") @PathVariable Long id) {

		DevpSysCmpModuleVO vo = devpSysCmpModuleRibbonService.find(id);
		return vo;
	}

	/**
	 * 查询组件对应模块列表
	 * @param pageSearchRequest
	 * @return
	 */
	@ApiOperation(value = "查询", notes = "根据条件查询组件对应模块列表", httpMethod = "POST")
	@PostMapping("/list")
	public PageContent<DevpSysCmpModuleVO> list(@RequestBody PageSearchRequest<DevpSysCmpModuleCondition> pageSearchRequest){


		PageContent<DevpSysCmpModuleVO> pageContent = devpSysCmpModuleRibbonService.list(pageSearchRequest);

		LOGGER.debug("page Size :{}, total:{}", pageContent.getContent().size() ,pageContent.getTotal());
		return pageContent;

	}


}
