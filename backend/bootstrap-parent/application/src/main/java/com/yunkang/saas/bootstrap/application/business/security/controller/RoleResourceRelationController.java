package com.yunkang.saas.bootstrap.application.business.security.controller;

import com.yunkang.saas.bootstrap.application.business.security.SaaSUtil;
import com.yunkang.saas.bootstrap.application.business.security.domain.RoleResourceRelation;
import com.yunkang.saas.bootstrap.application.business.security.service.RoleResourceRelationService;
import com.yunkang.saas.bootstrap.application.business.security.valid.RoleResourceRelationValidator;

import com.yunkang.saas.bootstrap.platform.business.account.dto.RoleResourceRelationAddDto;
import com.yunkang.saas.bootstrap.platform.business.account.dto.RoleResourceRelationCondition;
import com.yunkang.saas.bootstrap.platform.business.account.dto.RoleResourceRelationEditDto;

import com.yunkang.saas.bootstrap.platform.business.account.vo.RoleResourceRelationVO;
import com.yunkang.saas.common.framework.web.controller.PageContent;
import com.yunkang.saas.common.framework.web.data.PageRequest;
import com.yunkang.saas.common.framework.web.data.PageRequestConvert;
import com.yunkang.saas.common.framework.web.data.PageSearchRequest;
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
 * 管理角色资源关系
 * @author icode
 */
@RestController("applicationRoleResourceRelationController")
@RequestMapping(value = "/application/security/roleResourceRelation")
public class RoleResourceRelationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(RoleResourceRelationController.class);

	@Autowired
	private SaaSUtil saaSUtil;

	@Autowired
	private RoleResourceRelationService roleResourceRelationService;


    @InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		webDataBinder.addValidators(new RoleResourceRelationValidator());
	}

	/**
	 * 新增角色资源关系
	 * @param roleResourceRelationAddDto
	 * @return
	 */
	@PostMapping
	@ResponseStatus( HttpStatus.CREATED )
	public RoleResourceRelationVO add(@RequestBody @Valid RoleResourceRelationAddDto roleResourceRelationAddDto){
		RoleResourceRelation roleResourceRelation = new RoleResourceRelation();
		BeanUtils.copyProperties(roleResourceRelationAddDto, roleResourceRelation);

		saaSUtil.fillSaaSEntity(roleResourceRelation);

		roleResourceRelationService.add(roleResourceRelation);

		return  initViewProperty(roleResourceRelation);
	}

	/**
	 * 删除角色资源关系,id以逗号分隔
	 * @param idArray
	 */
	@DeleteMapping(value="/{idArray}")
	public void delete(@PathVariable String idArray){

	    LOGGER.debug("delete roleResourceRelation :{}", idArray);

		String[] ids = idArray.split(",");
		for (String id : ids ){
			roleResourceRelationService.delete(Long.parseLong(id));
		}

	}

	/**
	 * 更新角色资源关系
	 * @param roleResourceRelationEditDto
	 * @param id
	 * @return
	 */
	@PutMapping(value="/{id}")
	public	RoleResourceRelationVO update(@RequestBody @Valid RoleResourceRelationEditDto roleResourceRelationEditDto, @PathVariable Long id){
		RoleResourceRelation roleResourceRelation = new RoleResourceRelation();
		BeanUtils.copyProperties(roleResourceRelationEditDto, roleResourceRelation);
		roleResourceRelation.setId(id);
		roleResourceRelationService.merge(roleResourceRelation);

		RoleResourceRelationVO vo = initViewProperty(roleResourceRelation);
		return  vo;
	}

	/**
	 * 根据ID查询角色资源关系
	 * @param id
	 * @return
	 */
	@GetMapping(value="/{id}")
	public  RoleResourceRelationVO get(@PathVariable Long id) {

		RoleResourceRelation roleResourceRelation = roleResourceRelationService.find(id);

		RoleResourceRelationVO vo = initViewProperty(roleResourceRelation);
		return vo;
	}

	/**
	 * 查询角色资源关系列表
	 * @param pageSearchRequest
	 * @return
	 */
	@PostMapping("/list")
	public PageContent<RoleResourceRelationVO> list(@RequestBody PageSearchRequest<RoleResourceRelationCondition> pageSearchRequest){

		PageRequest pageRequest = PageRequestConvert.convert(pageSearchRequest);

		Page<RoleResourceRelation> page = roleResourceRelationService.find(pageSearchRequest.getSearchCondition(), pageRequest);

		List<RoleResourceRelationVO> voList = new ArrayList<>();
		for(RoleResourceRelation roleResourceRelation : page.getContent()){
			voList.add(initViewProperty(roleResourceRelation));
		}

		PageContent<RoleResourceRelationVO> pageContent = new PageContent<>(voList, page.getTotalElements());
		LOGGER.debug("page Size :{}, total:{}", pageContent.getContent().size() ,pageContent.getTotal());
		return pageContent;

	}

	private RoleResourceRelationVO initViewProperty(RoleResourceRelation roleResourceRelation){
	    RoleResourceRelationVO vo = new RoleResourceRelationVO();

        BeanUtils.copyProperties(roleResourceRelation, vo);

	    //初始化其他对象
        return vo;
	}




}
