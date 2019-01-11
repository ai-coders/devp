package com.yunkang.saas.application.business.application.dao;

import com.yunkang.saas.application.business.application.domain.AppCategory;
import com.yunkang.saas.application.business.application.dto.AppCategoryCondition;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class AppCategorySpecification implements Specification<AppCategory>{

	AppCategoryCondition condition;

	public AppCategorySpecification(AppCategoryCondition condition){
		this.condition = condition;
	}

	@Override
	public Predicate toPredicate(Root<AppCategory> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		List<Predicate> predicateList = new ArrayList<>();

		if(condition==null){
			return null;
		}
       
		tryAddNamePredicate(predicateList, root, cb);
		tryAddCodePredicate(predicateList, root, cb);


		Predicate[] pre = new Predicate[predicateList.size()];
		pre = predicateList.toArray(pre);
		return cb.and(pre);
	}


	private void tryAddNamePredicate(List<Predicate> predicateList, Root<AppCategory> root, CriteriaBuilder cb){
		if(StringUtils.isNotEmpty(condition.getName())){
			predicateList.add(cb.like(root.get(AppCategory.PROPERTY_NAME).as(String.class), "%"+condition.getName()+"%"));
		}
	}
	private void tryAddCodePredicate(List<Predicate> predicateList, Root<AppCategory> root, CriteriaBuilder cb){
		if(StringUtils.isNotEmpty(condition.getCode())){
			predicateList.add(cb.like(root.get(AppCategory.PROPERTY_CODE).as(String.class), "%"+condition.getCode()+"%"));
		}
	}
}


