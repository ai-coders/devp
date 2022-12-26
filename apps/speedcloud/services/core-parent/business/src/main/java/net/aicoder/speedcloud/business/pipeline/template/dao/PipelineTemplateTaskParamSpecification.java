package net.aicoder.speedcloud.business.pipeline.template.dao;

import net.aicoder.speedcloud.business.pipeline.template.domain.PipelineTemplateTaskParam;
import net.aicoder.speedcloud.business.pipeline.template.dto.PipelineTemplateTaskParamCondition;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class PipelineTemplateTaskParamSpecification implements Specification<PipelineTemplateTaskParam>{

	private PipelineTemplateTaskParamCondition condition;

	public PipelineTemplateTaskParamSpecification(PipelineTemplateTaskParamCondition condition){
		this.condition = condition;
	}

	@Override
	public Predicate toPredicate(Root<PipelineTemplateTaskParam> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		List<Predicate> predicateList = new ArrayList<>();

		if(condition==null){
			return null;
		}

		tryAddTidPredicate(predicateList, root, cb);
		tryAddTaskPredicate(predicateList, root, cb);
		tryAddNamePredicate(predicateList, root, cb);
		tryAddTypePredicate(predicateList, root, cb);
		tryAddDefaultValuePredicate(predicateList, root, cb);
		tryAddViewOrderPredicate(predicateList, root, cb);
		tryAddDescriptionPredicate(predicateList, root, cb);
		tryAddDeletablePredicate(predicateList, root, cb);
		tryAddEnumValuePredicate(predicateList, root, cb);
		tryAddValuePredicate(predicateList, root, cb);


		Predicate[] pre = new Predicate[predicateList.size()];
		pre = predicateList.toArray(pre);
		return cb.and(pre);
    }


	private void tryAddTidPredicate(List<Predicate> predicateList, Root<PipelineTemplateTaskParam> root, CriteriaBuilder cb){
        if (null != condition.getTid() ) {
            predicateList.add(cb.equal(root.get(PipelineTemplateTaskParam.PROPERTY_TID).as(Long.class), condition.getTid()));
        }  
	}
	private void tryAddTaskPredicate(List<Predicate> predicateList, Root<PipelineTemplateTaskParam> root, CriteriaBuilder cb){
	    if (null != condition.getTask() ) {
            predicateList.add(cb.equal(root.get(PipelineTemplateTaskParam.PROPERTY_TASK).as(String.class), condition.getTask()));
        }
	}
	private void tryAddNamePredicate(List<Predicate> predicateList, Root<PipelineTemplateTaskParam> root, CriteriaBuilder cb){
		if(StringUtils.isNotEmpty(condition.getName())){
			predicateList.add(cb.like(root.get(PipelineTemplateTaskParam.PROPERTY_NAME).as(String.class), "%"+condition.getName()+"%"));
		}
	}
	private void tryAddTypePredicate(List<Predicate> predicateList, Root<PipelineTemplateTaskParam> root, CriteriaBuilder cb){
		if(StringUtils.isNotEmpty(condition.getType())){
			predicateList.add(cb.like(root.get(PipelineTemplateTaskParam.PROPERTY_TYPE).as(String.class), "%"+condition.getType()+"%"));
		}
	}
	private void tryAddDefaultValuePredicate(List<Predicate> predicateList, Root<PipelineTemplateTaskParam> root, CriteriaBuilder cb){
		if(StringUtils.isNotEmpty(condition.getDefaultValue())){
			predicateList.add(cb.like(root.get(PipelineTemplateTaskParam.PROPERTY_DEFAULT_VALUE).as(String.class), "%"+condition.getDefaultValue()+"%"));
		}
	}
	private void tryAddViewOrderPredicate(List<Predicate> predicateList, Root<PipelineTemplateTaskParam> root, CriteriaBuilder cb){

		if (null != condition.getViewOrder() ) {
			predicateList.add(cb.equal(root.get(PipelineTemplateTaskParam.PROPERTY_VIEW_ORDER).as(Integer.class), condition.getViewOrder()));
		}

		if (null != condition.getViewOrderMax() ) {
			predicateList.add(cb.greaterThanOrEqualTo(root.get(PipelineTemplateTaskParam.PROPERTY_VIEW_ORDER).as(Integer.class), condition.getViewOrderMax()));
		}

		if (null != condition.getViewOrderMin() ) {
			predicateList.add(cb.lessThan(root.get(PipelineTemplateTaskParam.PROPERTY_VIEW_ORDER).as(Integer.class), condition.getViewOrderMin()));
		}
	}
	private void tryAddDescriptionPredicate(List<Predicate> predicateList, Root<PipelineTemplateTaskParam> root, CriteriaBuilder cb){
		if(StringUtils.isNotEmpty(condition.getDescription())){
			predicateList.add(cb.like(root.get(PipelineTemplateTaskParam.PROPERTY_DESCRIPTION).as(String.class), "%"+condition.getDescription()+"%"));
		}
	}
	private void tryAddDeletablePredicate(List<Predicate> predicateList, Root<PipelineTemplateTaskParam> root, CriteriaBuilder cb){
		if (null != condition.getDeletable() ) {
			predicateList.add(cb.equal(root.get(PipelineTemplateTaskParam.PROPERTY_DELETABLE).as(Boolean.class), condition.getDeletable()));
		}
	}
	private void tryAddEnumValuePredicate(List<Predicate> predicateList, Root<PipelineTemplateTaskParam> root, CriteriaBuilder cb){
		if(StringUtils.isNotEmpty(condition.getEnumValue())){
			predicateList.add(cb.like(root.get(PipelineTemplateTaskParam.PROPERTY_ENUM_VALUE).as(String.class), "%"+condition.getEnumValue()+"%"));
		}
	}
	private void tryAddValuePredicate(List<Predicate> predicateList, Root<PipelineTemplateTaskParam> root, CriteriaBuilder cb){
		if(StringUtils.isNotEmpty(condition.getValue())){
			predicateList.add(cb.like(root.get(PipelineTemplateTaskParam.PROPERTY_VALUE).as(String.class), "%"+condition.getValue()+"%"));
		}
	}
}


