package com.yunkang.saas.platform.business.platform.application.dao;

import com.yunkang.saas.platform.business.platform.application.dto.ApplicationPasswordCondition;
import com.yunkang.saas.platform.business.platform.application.domain.ApplicationPassword;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;

public class ApplicationPasswordSpecification implements Specification<ApplicationPassword>{

	private ApplicationPasswordCondition condition;

	public ApplicationPasswordSpecification(ApplicationPasswordCondition condition){
		this.condition = condition;
	}

	@Override
	public Predicate toPredicate(Root<ApplicationPassword> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		List<Predicate> predicateList = new ArrayList<>();

		if(condition==null){
			return null;
		}

		tryAddAccessIdPredicate(predicateList, root, cb);


		Predicate[] pre = new Predicate[predicateList.size()];
		pre = predicateList.toArray(pre);
		return cb.and(pre);
    }


	private void tryAddAccessIdPredicate(List<Predicate> predicateList, Root<ApplicationPassword> root, CriteriaBuilder cb){
		if(StringUtils.isNotEmpty(condition.getAccessId())){
			predicateList.add(cb.like(root.get(ApplicationPassword.PROPERTY_ACCESS_ID).as(String.class), "%"+condition.getAccessId()+"%"));
		}
	}
}


