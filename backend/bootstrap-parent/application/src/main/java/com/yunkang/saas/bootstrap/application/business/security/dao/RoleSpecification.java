package com.yunkang.saas.bootstrap.application.business.security.dao;


import com.yunkang.saas.bootstrap.application.business.security.domain.Role;
import com.yunkang.saas.bootstrap.platform.business.account.dto.RoleCondition;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class RoleSpecification implements Specification<Role>{

	RoleCondition condition;

	public RoleSpecification(RoleCondition condition){
		this.condition = condition;
	}

	@Override
	public Predicate toPredicate(Root<Role> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		List<Predicate> predicateList = new ArrayList<>();

		if(condition==null){
			return null;
		}
       
		tryAddNamePredicate(predicateList, root, cb);
		tryAddDescriptionPredicate(predicateList, root, cb);
		tryAddTenantIdPredicate(predicateList, root, cb);
		tryAddAppIdPredicate(predicateList, root, cb);

		Predicate[] pre = new Predicate[predicateList.size()];
		pre = predicateList.toArray(pre);
		return cb.and(pre);
	}


	private void tryAddNamePredicate(List<Predicate> predicateList, Root<Role> root, CriteriaBuilder cb){
		if(StringUtils.isNotEmpty(condition.getName())){
			predicateList.add(cb.like(root.get(Role.PROPERTY_NAME).as(String.class), "%"+condition.getName()+"%"));
		}
	}
	private void tryAddDescriptionPredicate(List<Predicate> predicateList, Root<Role> root, CriteriaBuilder cb){
		if(StringUtils.isNotEmpty(condition.getDescription())){
			predicateList.add(cb.like(root.get(Role.PROPERTY_DESCRIPTION).as(String.class), "%"+condition.getDescription()+"%"));
		}
	}
	private void tryAddTenantIdPredicate(List<Predicate> predicateList, Root<Role> root, CriteriaBuilder cb){
		if(null != condition.getTid()){
			predicateList.add(cb.equal(root.get(Role.PROPERTY_TENANT_ID).as(Long.class), condition.getTid()));
		}
	}
	private void tryAddAppIdPredicate(List<Predicate> predicateList, Root<Role> root, CriteriaBuilder cb){
		if(null != condition.getAppCode()){
			predicateList.add(cb.equal(root.get(Role.PROPERTY_APP_CODE).as(Long.class), condition.getAppCode()));
		}
	}
}


