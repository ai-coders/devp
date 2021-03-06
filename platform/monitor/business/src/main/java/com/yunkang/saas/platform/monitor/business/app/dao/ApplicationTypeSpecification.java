package com.yunkang.saas.platform.monitor.business.app.dao;

import com.yunkang.saas.platform.monitor.business.app.domain.ApplicationType;
import com.yunkang.saas.platform.monitor.business.app.dto.ApplicationTypeCondition;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ApplicationTypeSpecification implements Specification<ApplicationType>{

	private ApplicationTypeCondition condition;

	public ApplicationTypeSpecification(ApplicationTypeCondition condition){
		this.condition = condition;
	}

	@Override
	public Predicate toPredicate(Root<ApplicationType> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		List<Predicate> predicateList = new ArrayList<>();

		if(condition==null){
			return null;
		}

		tryAddCodePredicate(predicateList, root, cb);
		tryAddNamePredicate(predicateList, root, cb);
		tryAddIconPredicate(predicateList, root, cb);


		Predicate[] pre = new Predicate[predicateList.size()];
		pre = predicateList.toArray(pre);
		return cb.and(pre);
    }


	private void tryAddCodePredicate(List<Predicate> predicateList, Root<ApplicationType> root, CriteriaBuilder cb){
		if(StringUtils.isNotEmpty(condition.getCode())){
			predicateList.add(cb.like(root.get(ApplicationType.PROPERTY_CODE).as(String.class), "%"+condition.getCode()+"%"));
		}
	}
	private void tryAddNamePredicate(List<Predicate> predicateList, Root<ApplicationType> root, CriteriaBuilder cb){
		if(StringUtils.isNotEmpty(condition.getName())){
			predicateList.add(cb.like(root.get(ApplicationType.PROPERTY_NAME).as(String.class), "%"+condition.getName()+"%"));
		}
	}
	private void tryAddIconPredicate(List<Predicate> predicateList, Root<ApplicationType> root, CriteriaBuilder cb){
		if(StringUtils.isNotEmpty(condition.getIcon())){
			predicateList.add(cb.like(root.get(ApplicationType.PROPERTY_ICON).as(String.class), "%"+condition.getIcon()+"%"));
		}
	}
}


