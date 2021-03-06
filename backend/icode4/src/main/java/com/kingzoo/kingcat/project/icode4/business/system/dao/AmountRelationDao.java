package com.kingzoo.kingcat.project.icode4.business.system.dao;

import com.kingzoo.kingcat.commons.framework.spring.jpa.SimpleJpaRepository;
import com.kingzoo.kingcat.project.icode4.business.system.domain.AmountRelation;
import com.kingzoo.kingcat.project.icode4.business.system.vo.AmountRelationCondition;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * 数量关系的数据库操作
 * @author icode
 */
@Repository("amountRelationDao")
public class AmountRelationDao extends SimpleJpaRepository<AmountRelation, String, AmountRelationCondition> {

	@Override
	public Specification<AmountRelation> buildQuery(final AmountRelationCondition condition){

		return new AmountRelationSpecification(condition);
	}
}

class AmountRelationSpecification implements Specification<AmountRelation>{

	AmountRelationCondition condition;

	public AmountRelationSpecification(AmountRelationCondition condition){
		this.condition = condition;
	}

	@Override
	public Predicate toPredicate(Root<AmountRelation> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		List<Predicate> predicateList = new ArrayList<>();

		if(condition==null){
			return null;
		}
       
		tryAddCodePredicate(predicateList, root, cb);
		tryAddNamePredicate(predicateList, root, cb);


		Predicate[] pre = new Predicate[predicateList.size()];
		pre = predicateList.toArray(pre);
		return cb.and(pre);
	}


	private void tryAddCodePredicate(List<Predicate> predicateList, Root<AmountRelation> root, CriteriaBuilder cb){
		if(StringUtils.isNotEmpty(condition.getCode())){
			predicateList.add(cb.like(root.get(AmountRelation.PROPERTY_CODE).as(String.class), "%"+condition.getCode()+"%"));
		}
	}
	private void tryAddNamePredicate(List<Predicate> predicateList, Root<AmountRelation> root, CriteriaBuilder cb){
		if(StringUtils.isNotEmpty(condition.getName())){
			predicateList.add(cb.like(root.get(AmountRelation.PROPERTY_NAME).as(String.class), "%"+condition.getName()+"%"));
		}
	}
}

