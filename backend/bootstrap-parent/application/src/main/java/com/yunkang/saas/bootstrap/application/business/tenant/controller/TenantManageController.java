package com.yunkang.saas.bootstrap.application.business.tenant.controller;

import com.yunkang.saas.bootstrap.application.business.tenant.service.TenantManageService;
import com.yunkang.saas.bootstrap.platform.business.tenant.domain.Tenant;
import com.yunkang.saas.bootstrap.platform.business.tenant.domain.TenantType;
import com.yunkang.saas.bootstrap.platform.business.tenant.dto.TenantAddDto;
import com.yunkang.saas.bootstrap.platform.business.tenant.dto.TenantCondition;
import com.yunkang.saas.bootstrap.platform.business.tenant.dto.TenantEditDto;
import com.yunkang.saas.bootstrap.platform.business.tenant.service.TenantService;
import com.yunkang.saas.bootstrap.platform.business.tenant.service.TenantTypeService;
import com.yunkang.saas.bootstrap.platform.business.tenant.valid.TenantValidator;
import com.yunkang.saas.bootstrap.platform.business.tenant.vo.TenantTypeVO;
import com.yunkang.saas.bootstrap.platform.business.tenant.vo.TenantVO;
import com.yunkang.saas.common.framework.app.ApplicationProperties;
import com.yunkang.saas.common.framework.web.controller.PageContent;
import com.yunkang.saas.common.framework.web.data.PageRequest;
import com.yunkang.saas.common.framework.web.data.PageRequestConvert;
import com.yunkang.saas.common.framework.web.data.PageSearchRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * 管理租户
 * @author icode
 */
@Api(description = "租户", tags = "Tenant")
@RestController
@RequestMapping(value = "/application/tenant/tenant")
public class TenantManageController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TenantManageController.class);

	@Autowired
	private ApplicationProperties applicationProperties;

	@Autowired
	private TenantService tenantService;

	@Autowired
	private TenantManageService tenantManageService;

	@Autowired
	private TenantTypeService tenantTypeService;

	@Autowired
	private TenantValidator tenantValidator;

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		webDataBinder.addValidators(tenantValidator);
	}

	/**
	 * 租户开通应用
	 * @param tenantAddDto
	 * @return
	 */
	@ApiOperation(value = "新增", notes = "新增租户", httpMethod = "POST")
	@PostMapping
	@ResponseStatus( HttpStatus.CREATED )
	public TenantVO add(TenantAddDto tenantAddDto){

		Tenant tenant = new Tenant();
		BeanUtils.copyProperties(tenantAddDto, tenant);

		tenantManageService.createTenant(tenant, applicationProperties.getCode());

		return  initViewProperty(tenant);
	}


	/**
	 * 更新租户
	 * @param tenantEditDto
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "修改", notes = "修改产租户(修改全部字段,未传入置空)", httpMethod = "PUT")
	@PutMapping(value="/{id}")
	public	TenantVO update(@RequestBody @Valid TenantEditDto tenantEditDto, @PathVariable Long id){
		Tenant tenant = new Tenant();
		BeanUtils.copyProperties(tenantEditDto, tenant);
		tenant.setId(id);
		tenantService.merge(tenant);

		TenantVO vo = initViewProperty(tenant);
		return  vo;
	}



	/**
	 * 查询租户列表
	 * @param pageSearchRequest
	 * @return
	 */
	@ApiOperation(value = "查询", notes = "根据条件查询租户列表", httpMethod = "POST")
	@PostMapping("/list")
	public PageContent<TenantVO> list(@RequestBody PageSearchRequest<TenantCondition> pageSearchRequest){

		PageRequest pageRequest = PageRequestConvert.convert(pageSearchRequest);

		Page<Tenant> page = tenantService.find(pageSearchRequest.getSearchCondition(), pageRequest);

		List<TenantVO> voList = new ArrayList<>();
		for(Tenant tenant : page.getContent()){
			voList.add(initViewProperty(tenant));
		}

		PageContent<TenantVO> pageContent = new PageContent<>(voList, page.getTotalElements());
		LOGGER.debug("page Size :{}, total:{}", pageContent.getContent().size() ,pageContent.getTotal());
		return pageContent;

	}

	/**
	 * 查询租户列表
	 * @param pageSearchRequest
	 * @return
	 */
	@ApiOperation(value = "查询", notes = "根据条件快速查询租户列表", httpMethod = "POST")
	@PostMapping(value = "/list", params = "query")

	public PageContent<TenantVO> query(@RequestBody PageSearchRequest<TenantCondition> pageSearchRequest){
		return null;
	}


	private TenantVO initViewProperty(Tenant tenant){
	    TenantVO vo = new TenantVO();

        BeanUtils.copyProperties(tenant, vo);

	    //初始化其他对象
	    initTenantTypePropertyGroup(vo, tenant);
        return vo;
	}


	private void initTenantTypePropertyGroup(TenantVO tenantVO, Tenant tenant){
	
		TenantType tenantType = tenantTypeService.find(tenant.getTenantType());
		if(tenantType == null){
			return;
		}
		TenantTypeVO tenantTypeVO = new TenantTypeVO();
		BeanUtils.copyProperties(tenantType, tenantTypeVO);

		tenantVO.setTenantTypeVO(tenantTypeVO);

	}


}
