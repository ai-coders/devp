package com.yunkang.saas.platform.manage.business.platform.security.controller;


import com.yunkang.saas.bootstrap.application.business.security.domain.AccountRoleRelation;
import com.yunkang.saas.bootstrap.application.business.security.service.AccountRoleRelationService;
import com.yunkang.saas.bootstrap.platform.business.account.dto.AccountRoleRelationAddDto;
import com.yunkang.saas.bootstrap.platform.business.account.dto.AccountRoleRelationCondition;
import com.yunkang.saas.bootstrap.platform.business.account.dto.AccountRoleRelationEditDto;
import com.yunkang.saas.bootstrap.platform.business.account.vo.AccountRoleRelationVO;
import com.yunkang.saas.common.framework.web.controller.PageContent;
import com.yunkang.saas.common.framework.web.data.PageRequest;
import com.yunkang.saas.common.framework.web.data.PageRequestConvert;
import com.yunkang.saas.common.framework.web.data.PageSearchRequest;
import com.yunkang.saas.platform.manage.business.platform.security.valid.AccountRoleRelationValidator;
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
 * 管理账号角色关联
 * @author icode
 */
@RestController
@RequestMapping(value = "/platform/security/accountRoleRelation")
public class AccountRoleRelationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AccountRoleRelationController.class);


	@Autowired
	private AccountRoleRelationService accountRoleRelationService;


    @InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		webDataBinder.addValidators(new AccountRoleRelationValidator());
	}

	/**
	 * 新增账号角色关联
	 * @param accountRoleRelationAddDto
	 * @return
	 */
	@PostMapping
	@ResponseStatus( HttpStatus.CREATED )
	public AccountRoleRelationVO add(@RequestBody @Valid AccountRoleRelationAddDto accountRoleRelationAddDto){

		AccountRoleRelation accountRoleRelation = new AccountRoleRelation();

		BeanUtils.copyProperties(accountRoleRelationAddDto, accountRoleRelation);

		accountRoleRelationService.add(accountRoleRelation);

		return  initViewProperty(accountRoleRelation);

	}

	/**
	 * 删除账号角色关联,id以逗号分隔
	 * @param idArray
	 */
	@DeleteMapping(value="/{idArray}")
	public void delete(@PathVariable String idArray){

	    LOGGER.debug("delete accountRoleRelation :{}", idArray);

		String[] ids = idArray.split(",");
		for (String id : ids ){
			accountRoleRelationService.delete(Long.parseLong(id));
		}

	}

	/**
	 * 更新账号角色关联
	 * @param accountRoleRelationEditDto
	 * @param id
	 * @return
	 */
	@PutMapping(value="/{id}")
	public	AccountRoleRelationVO update(@RequestBody @Valid AccountRoleRelationEditDto accountRoleRelationEditDto, @PathVariable Long id){
		AccountRoleRelation accountRoleRelation = new AccountRoleRelation();
		BeanUtils.copyProperties(accountRoleRelationEditDto, accountRoleRelation);
		accountRoleRelation.setId(id);
		accountRoleRelationService.merge(accountRoleRelation);

		AccountRoleRelationVO vo = initViewProperty(accountRoleRelation);
		return  vo;
	}

	/**
	 * 根据ID查询账号角色关联
	 * @param id
	 * @return
	 */
	@GetMapping(value="/{id}")
	public  AccountRoleRelationVO get(@PathVariable Long id) {

		AccountRoleRelation accountRoleRelation = accountRoleRelationService.find(id);

		AccountRoleRelationVO vo = initViewProperty(accountRoleRelation);
		return vo;
	}

	/**
	 * 查询账号角色关联列表
	 * @param pageSearchRequest
	 * @return
	 */
	@PostMapping("/list")
	public PageContent<AccountRoleRelationVO> list(@RequestBody PageSearchRequest<AccountRoleRelationCondition> pageSearchRequest){

		PageRequest pageRequest = PageRequestConvert.convert(pageSearchRequest);

		Page<AccountRoleRelation> page = accountRoleRelationService.find(pageSearchRequest.getSearchCondition(), pageRequest);

		List<AccountRoleRelationVO> voList = new ArrayList<>();
		for(AccountRoleRelation accountRoleRelation : page.getContent()){
			voList.add(initViewProperty(accountRoleRelation));
		}

		PageContent<AccountRoleRelationVO> pageContent = new PageContent<>(voList, page.getTotalElements());
		LOGGER.debug("page Size :{}, total:{}", pageContent.getContent().size() ,pageContent.getTotal());
		return pageContent;

	}

	private AccountRoleRelationVO initViewProperty(AccountRoleRelation accountRoleRelation){
	    AccountRoleRelationVO vo = new AccountRoleRelationVO();

        BeanUtils.copyProperties(accountRoleRelation, vo);

	    //初始化其他对象
        return vo;
	}




}
