package net.aicoder.devp.business.deploy.dao;

import net.aicoder.devp.business.deploy.domain.DevpSysDpyResInstHost;
import net.aicoder.devp.business.deploy.dto.DevpSysDpyResInstHostCondition;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;

public class DevpSysDpyResInstHostSpecification implements Specification<DevpSysDpyResInstHost>{

	private DevpSysDpyResInstHostCondition condition;

	public DevpSysDpyResInstHostSpecification(DevpSysDpyResInstHostCondition condition){
		this.condition = condition;
	}

	@Override
	public Predicate toPredicate(Root<DevpSysDpyResInstHost> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		List<Predicate> predicateList = new ArrayList<>();

		if(condition==null){
			return null;
		}

		tryAddTidPredicate(predicateList, root, cb);
		tryAddEtypePredicate(predicateList, root, cb);
		tryAddNamePredicate(predicateList, root, cb);
		tryAddCodePredicate(predicateList, root, cb);
		tryAddAliasPredicate(predicateList, root, cb);
		tryAddDescriptionPredicate(predicateList, root, cb);
		tryAddRecordStatePredicate(predicateList, root, cb);
		tryAddFlagPredicate(predicateList, root, cb);
		tryAddTypePredicate(predicateList, root, cb);
		tryAddSubTypePredicate(predicateList, root, cb);
		tryAddStatusPredicate(predicateList, root, cb);
		tryAddNotesPredicate(predicateList, root, cb);
		tryAddPrdRidPredicate(predicateList, root, cb);
		tryAddSchemeRidPredicate(predicateList, root, cb);
		tryAddInstRidPredicate(predicateList, root, cb);
		tryAddSeqPredicate(predicateList, root, cb);
		tryAddHostRidPredicate(predicateList, root, cb);


		Predicate[] pre = new Predicate[predicateList.size()];
		pre = predicateList.toArray(pre);
		return cb.and(pre);
    }


	private void tryAddTidPredicate(List<Predicate> predicateList, Root<DevpSysDpyResInstHost> root, CriteriaBuilder cb){
		if (null != condition.getTid() ) {
			predicateList.add(cb.equal(root.get(DevpSysDpyResInstHost.PROPERTY_TID).as(Long.class), condition.getTid()));
		}
	}
	private void tryAddEtypePredicate(List<Predicate> predicateList, Root<DevpSysDpyResInstHost> root, CriteriaBuilder cb){
		if(StringUtils.isNotEmpty(condition.getEtype())){
			predicateList.add(cb.like(root.get(DevpSysDpyResInstHost.PROPERTY_ETYPE).as(String.class), "%"+condition.getEtype()+"%"));
		}
	}
	private void tryAddNamePredicate(List<Predicate> predicateList, Root<DevpSysDpyResInstHost> root, CriteriaBuilder cb){
		if(StringUtils.isNotEmpty(condition.getName())){
			predicateList.add(cb.like(root.get(DevpSysDpyResInstHost.PROPERTY_NAME).as(String.class), "%"+condition.getName()+"%"));
		}
	}
	private void tryAddCodePredicate(List<Predicate> predicateList, Root<DevpSysDpyResInstHost> root, CriteriaBuilder cb){
		if(StringUtils.isNotEmpty(condition.getCode())){
			predicateList.add(cb.like(root.get(DevpSysDpyResInstHost.PROPERTY_CODE).as(String.class), "%"+condition.getCode()+"%"));
		}
	}
	private void tryAddAliasPredicate(List<Predicate> predicateList, Root<DevpSysDpyResInstHost> root, CriteriaBuilder cb){
		if(StringUtils.isNotEmpty(condition.getAlias())){
			predicateList.add(cb.like(root.get(DevpSysDpyResInstHost.PROPERTY_ALIAS).as(String.class), "%"+condition.getAlias()+"%"));
		}
	}
	private void tryAddDescriptionPredicate(List<Predicate> predicateList, Root<DevpSysDpyResInstHost> root, CriteriaBuilder cb){
		if(StringUtils.isNotEmpty(condition.getDescription())){
			predicateList.add(cb.like(root.get(DevpSysDpyResInstHost.PROPERTY_DESCRIPTION).as(String.class), "%"+condition.getDescription()+"%"));
		}
	}
	private void tryAddRecordStatePredicate(List<Predicate> predicateList, Root<DevpSysDpyResInstHost> root, CriteriaBuilder cb){
		if (null != condition.getRecordState() ) {
			predicateList.add(cb.equal(root.get(DevpSysDpyResInstHost.PROPERTY_RECORD_STATE).as(Integer.class), condition.getRecordState()));
		}
	}
	private void tryAddFlagPredicate(List<Predicate> predicateList, Root<DevpSysDpyResInstHost> root, CriteriaBuilder cb){
		if(StringUtils.isNotEmpty(condition.getFlag())){
			predicateList.add(cb.like(root.get(DevpSysDpyResInstHost.PROPERTY_FLAG).as(String.class), "%"+condition.getFlag()+"%"));
		}
	}
	private void tryAddTypePredicate(List<Predicate> predicateList, Root<DevpSysDpyResInstHost> root, CriteriaBuilder cb){
		if(StringUtils.isNotEmpty(condition.getType())){
			predicateList.add(cb.like(root.get(DevpSysDpyResInstHost.PROPERTY_TYPE).as(String.class), "%"+condition.getType()+"%"));
		}
	}
	private void tryAddSubTypePredicate(List<Predicate> predicateList, Root<DevpSysDpyResInstHost> root, CriteriaBuilder cb){
		if(StringUtils.isNotEmpty(condition.getSubType())){
			predicateList.add(cb.like(root.get(DevpSysDpyResInstHost.PROPERTY_SUB_TYPE).as(String.class), "%"+condition.getSubType()+"%"));
		}
	}
	private void tryAddStatusPredicate(List<Predicate> predicateList, Root<DevpSysDpyResInstHost> root, CriteriaBuilder cb){
		if(StringUtils.isNotEmpty(condition.getStatus())){
			predicateList.add(cb.like(root.get(DevpSysDpyResInstHost.PROPERTY_STATUS).as(String.class), "%"+condition.getStatus()+"%"));
		}
	}
	private void tryAddNotesPredicate(List<Predicate> predicateList, Root<DevpSysDpyResInstHost> root, CriteriaBuilder cb){
		if(StringUtils.isNotEmpty(condition.getNotes())){
			predicateList.add(cb.like(root.get(DevpSysDpyResInstHost.PROPERTY_NOTES).as(String.class), "%"+condition.getNotes()+"%"));
		}
	}
	private void tryAddPrdRidPredicate(List<Predicate> predicateList, Root<DevpSysDpyResInstHost> root, CriteriaBuilder cb){
		if (null != condition.getPrdRid() ) {
			predicateList.add(cb.equal(root.get(DevpSysDpyResInstHost.PROPERTY_PRD_RID).as(Long.class), condition.getPrdRid()));
		}
	}
	private void tryAddSchemeRidPredicate(List<Predicate> predicateList, Root<DevpSysDpyResInstHost> root, CriteriaBuilder cb){
		if (null != condition.getSchemeRid() ) {
			predicateList.add(cb.equal(root.get(DevpSysDpyResInstHost.PROPERTY_SCHEME_RID).as(Long.class), condition.getSchemeRid()));
		}
	}
	private void tryAddInstRidPredicate(List<Predicate> predicateList, Root<DevpSysDpyResInstHost> root, CriteriaBuilder cb){
		if (null != condition.getInstRid() ) {
			predicateList.add(cb.equal(root.get(DevpSysDpyResInstHost.PROPERTY_INST_RID).as(Long.class), condition.getInstRid()));
		}
	}
	private void tryAddSeqPredicate(List<Predicate> predicateList, Root<DevpSysDpyResInstHost> root, CriteriaBuilder cb){
		if (null != condition.getSeq() ) {
			predicateList.add(cb.equal(root.get(DevpSysDpyResInstHost.PROPERTY_SEQ).as(Integer.class), condition.getSeq()));
		}
	}
	private void tryAddHostRidPredicate(List<Predicate> predicateList, Root<DevpSysDpyResInstHost> root, CriteriaBuilder cb){
		if (null != condition.getHostRid() ) {
			predicateList.add(cb.equal(root.get(DevpSysDpyResInstHost.PROPERTY_HOST_RID).as(Long.class), condition.getHostRid()));
		}
	}
}

