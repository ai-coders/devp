package com.yunkang.saas.bootstrap.application.business.resource.service;


import com.yunkang.saas.bootstrap.application.business.resource.dao.ResourceDao;
import com.yunkang.saas.bootstrap.application.business.resource.dao.ResourceSpecification;
import com.yunkang.saas.bootstrap.application.business.resource.domain.Resource;
import com.yunkang.saas.bootstrap.application.business.resource.dto.ResourceCondition;
import com.yunkang.saas.bootstrap.application.business.security.domain.AccountRoleRelation;
import com.yunkang.saas.bootstrap.application.business.security.domain.RoleResourceRelation;
import com.yunkang.saas.bootstrap.application.business.security.service.AccountRoleRelationService;
import com.yunkang.saas.bootstrap.application.business.security.service.RoleResourceRelationService;
import com.yunkang.saas.bootstrap.platform.business.account.dto.AccountRoleRelationCondition;
import com.yunkang.saas.bootstrap.platform.business.account.dto.RoleResourceRelationCondition;
import com.yunkang.saas.common.jpa.GenericCrudService;
import com.yunkang.saas.common.util.IdSnowflake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service("resourceService")
public class ResourceService  extends GenericCrudService<Resource, Long, ResourceCondition, ResourceDao> {

	private static final Logger LOGGER = LoggerFactory.getLogger(Resource.class);

	@Autowired
	private AccountRoleRelationService accountRoleRelationService;

	@Autowired
	private RoleResourceRelationService roleResourceRelationService;

	@Autowired
	private ResourceService resourceService;

	public void add(Resource resource){

		if(resource.getId() == null) {
			resource.setId(IdSnowflake.getLocalInstance().nextId(getClass()));
		}

		dao.save(resource);

	}


	public int countByCode(Long code){
		return dao.countByCode(code);
	}
	public Resource findByCode(Long code){
		return dao.findByCode(code);
	}

	public Resource findByCodeAndAppCode(Resource resource){
		return dao.findByCodeAndAppCode(resource.getCode(), resource.getAppCode());
	}

	/**
	 * 获取树形资源
	 * @param accountId
	 * @return
	 */
	public List<Resource> findAllResourceByAccountId(Long accountId){


		//得到账号的所有角色
		AccountRoleRelationCondition accountRoleCondition = new AccountRoleRelationCondition();
		accountRoleCondition.setAccountId(accountId);
		List<AccountRoleRelation> roleMappings = accountRoleRelationService.findAll(accountRoleCondition);


		//开始时准备获取所有资源
		List<Resource> resourceList = new ArrayList<>();

		Set<Long> resourceKeySet = new HashSet<>();

		for(AccountRoleRelation roleMapping : roleMappings){
			RoleResourceRelationCondition roleResourceCondition = new RoleResourceRelationCondition();
			roleResourceCondition.setRoleId(roleMapping.getRoleId());

			//
			List<RoleResourceRelation>  RoleResourceRelationList = roleResourceRelationService.findAll(roleResourceCondition);

			//得到所有额资源ID
			for(RoleResourceRelation RoleResourceRelation:RoleResourceRelationList){
				resourceKeySet.add(RoleResourceRelation.getResourceId());
			}
		}

		for(Long key : resourceKeySet){
			Resource resource = resourceService.find(key);

			if(resource!=null) {
				resourceList.add(resource);
			}else{
				LOGGER.info("can not find resource for id:{}", key);
			}
		}

		return resourceList;

	}

	@Override
	public Specification<Resource> getSpecification(ResourceCondition condition) {
		return new ResourceSpecification(condition);
	}

	public Sort getDefaultSort(){

		Sort sort = new Sort(Sort.Direction.ASC , Resource.PROPERTY_ORDER_INDEX, Resource.PROPERTY_CODE);
		return sort;
	}
}