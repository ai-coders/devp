package net.aicoder.speedcloud.console.business.jointjs.dao;

import net.aicoder.speedcloud.console.business.jointjs.domain.JointData;
import net.aicoder.speedcloud.console.business.jointjs.dto.JointDataCondition;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class JointDataSpecification implements Specification<JointData>{

	private JointDataCondition condition;

	public JointDataSpecification(JointDataCondition condition){
		this.condition = condition;
	}

	@Override
	public Predicate toPredicate(Root<JointData> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		List<Predicate> predicateList = new ArrayList<>();

		if(condition==null){
			return null;
		}

		tryAddTidPredicate(predicateList, root, cb);
		tryAddSchemePredicate(predicateList, root, cb);
		tryAddViewJsonPredicate(predicateList, root, cb);
		tryAddTypePredicate(predicateList, root, cb);


		Predicate[] pre = new Predicate[predicateList.size()];
		pre = predicateList.toArray(pre);
		return cb.and(pre);
    }


	private void tryAddTidPredicate(List<Predicate> predicateList, Root<JointData> root, CriteriaBuilder cb){

		if (null != condition.getTid() ) {
			predicateList.add(cb.equal(root.get(JointData.PROPERTY_TID).as(Long.class), condition.getTid()));
		}
	}
	private void tryAddSchemePredicate(List<Predicate> predicateList, Root<JointData> root, CriteriaBuilder cb){

		if (null != condition.getScheme() ) {
			predicateList.add(cb.equal(root.get(JointData.PROPERTY_SCHEME).as(Long.class), condition.getScheme()));
		}

		if (null != condition.getSchemeMax() ) {
			predicateList.add(cb.greaterThanOrEqualTo(root.get(JointData.PROPERTY_SCHEME).as(Long.class), condition.getSchemeMax()));
		}

		if (null != condition.getSchemeMin() ) {
			predicateList.add(cb.lessThan(root.get(JointData.PROPERTY_SCHEME).as(Long.class), condition.getSchemeMin()));
		}
	}
	private void tryAddViewJsonPredicate(List<Predicate> predicateList, Root<JointData> root, CriteriaBuilder cb){
		if(StringUtils.isNotEmpty(condition.getViewJson())){
			predicateList.add(cb.like(root.get(JointData.PROPERTY_VIEW_JSON).as(String.class), "%"+condition.getViewJson()+"%"));
		}
	}
	private void tryAddTypePredicate(List<Predicate> predicateList, Root<JointData> root, CriteriaBuilder cb){
		if(StringUtils.isNotEmpty(condition.getType())){
			predicateList.add(cb.like(root.get(JointData.PROPERTY_TYPE).as(String.class), "%"+condition.getType()+"%"));
		}
	}
}


