package net.aicoder.devp.maintenance.business.deploy.deploy.controller;

import com.yunkang.saas.common.framework.web.controller.PageContent;
import com.yunkang.saas.common.framework.web.data.PageRequest;
import com.yunkang.saas.common.framework.web.data.PageSearchRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.aicoder.devp.deploy.business.deploy.dto.DevpSysDpySchemeCondition;
import net.aicoder.devp.deploy.business.deploy.dto.DevpSysDpySchemeAddDto;
import net.aicoder.devp.deploy.business.deploy.dto.DevpSysDpySchemeEditDto;
import net.aicoder.devp.deploy.business.deploy.vo.DevpSysDpySchemeVO;
import net.aicoder.devp.maintenance.business.deploy.deploy.service.DevpSysDpySchemeRibbonService;
import net.aicoder.devp.maintenance.business.deploy.deploy.valid.DevpSysDpySchemeValidator;
import net.aicoder.devp.security.business.security.service.SecurityUtil;

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
 * 管理产品部署方案
 * @author icode
 */
@Api(description = "产品部署方案", tags = "DevpSysDpyScheme")
@RestController
@RequestMapping(value = "/deploy/devpSysDpyScheme")
public class DevpSysDpySchemeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DevpSysDpySchemeController.class);


	@Autowired
	private DevpSysDpySchemeRibbonService devpSysDpySchemeRibbonService;

	@Autowired
	DevpSysDpySchemeValidator devpSysDpySchemeValidator;

    @InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		webDataBinder.addValidators(devpSysDpySchemeValidator);
	}

	/**
	 * 新增产品部署方案
	 * @param devpSysDpySchemeAddDto
	 * @return
	 */
	@ApiOperation(value = "新增", notes = "新增产品部署方案", httpMethod = "POST")
	@PostMapping
	@ResponseStatus( HttpStatus.CREATED )
	public DevpSysDpySchemeVO add(@RequestBody DevpSysDpySchemeAddDto devpSysDpySchemeAddDto){
		devpSysDpySchemeAddDto.setTid(SecurityUtil.getAccount().getTenantId());
		return  devpSysDpySchemeRibbonService.add(devpSysDpySchemeAddDto);
	}

	/**
	 * 删除产品部署方案,id以逗号分隔
	 * @param idArray
	 */
	@ApiOperation(value = "删除", notes = "删除产品部署方案", httpMethod = "DELETE")
	@DeleteMapping(value="/{idArray}")
	public void delete(@PathVariable String idArray){

	    LOGGER.debug("delete devpSysDpyScheme :{}", idArray);

		String[] ids = idArray.split(",");
		for (String id : ids ){
			devpSysDpySchemeRibbonService.delete(Long.parseLong(id));
		}

	}

	/**
	 * 更新产品部署方案
	 * @param devpSysDpySchemeEditDto
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "修改", notes = "修改产产品部署方案(修改全部字段,未传入置空)", httpMethod = "PUT")
	@PutMapping(value="/{id}")
	public DevpSysDpySchemeVO update(@RequestBody DevpSysDpySchemeEditDto devpSysDpySchemeEditDto, @ApiParam(value = "要查询的产品部署方案id") @PathVariable Long id){

		DevpSysDpySchemeVO vo = devpSysDpySchemeRibbonService.merge(id, devpSysDpySchemeEditDto);

		return  vo;
	}

	/**
	 * 根据ID查询产品部署方案
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "查询", notes = "根据ID查询产品部署方案", httpMethod = "GET")
	@GetMapping(value="/{id}")
	public DevpSysDpySchemeVO get(@ApiParam(value = "要查询的产品部署方案id") @PathVariable Long id) {

		DevpSysDpySchemeVO vo = devpSysDpySchemeRibbonService.find(id);
		return vo;
	}

	/**
	 * 查询产品部署方案列表
	 * @param pageSearchRequest
	 * @return
	 */
	@ApiOperation(value = "查询", notes = "根据条件查询产品部署方案列表", httpMethod = "POST")
	@PostMapping("/list")
	public PageContent<DevpSysDpySchemeVO> list(@RequestBody PageSearchRequest<DevpSysDpySchemeCondition> pageSearchRequest){


		PageContent<DevpSysDpySchemeVO> pageContent = devpSysDpySchemeRibbonService.list(pageSearchRequest);

		LOGGER.debug("page Size :{}, total:{}", pageContent.getContent().size() ,pageContent.getTotal());
		return pageContent;

	}


}