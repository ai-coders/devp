package net.aicoder.speedcloud.business.pipeline.exec.dao;

import net.aicoder.speedcloud.business.pipeline.exec.domain.PipelineExecNode;
import net.aicoder.speedcloud.business.pipeline.exec.dto.PipelineExecNodeCondition;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PipelineExecNodeSpecification implements Specification<PipelineExecNode>{

	private PipelineExecNodeCondition condition;

	public PipelineExecNodeSpecification(PipelineExecNodeCondition condition){
		this.condition = condition;
	}

	@Override
	public Predicate toPredicate(Root<PipelineExecNode> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		List<Predicate> predicateList = new ArrayList<>();

		if(condition==null){
			return null;
		}

		tryAddTidPredicate(predicateList, root, cb);
		tryAddCodePredicate(predicateList, root, cb);
		tryAddNamePredicate(predicateList, root, cb);
		tryAddNodeTypePredicate(predicateList, root, cb);
		tryAddExecModePredicate(predicateList, root, cb);
		tryAddStatusPredicate(predicateList, root, cb);
		tryAddResultPredicate(predicateList, root, cb);
		tryAddExecPredicate(predicateList, root, cb);
		tryAddResultMessagePredicate(predicateList, root, cb);
		tryAddStartTimePredicate(predicateList, root, cb);
		tryAddParentIdPredicate(predicateList, root, cb);
		tryAddRelationObjIdPredicate(predicateList, root, cb);
		tryAddAutoStartPredicate(predicateList, root, cb);
		tryAddExecIndexPredicate(predicateList, root, cb);


		Predicate[] pre = new Predicate[predicateList.size()];
		pre = predicateList.toArray(pre);
		return cb.and(pre);
    }


	private void tryAddTidPredicate(List<Predicate> predicateList, Root<PipelineExecNode> root, CriteriaBuilder cb){

		if (null != condition.getTid() ) {
			predicateList.add(cb.equal(root.get(PipelineExecNode.PROPERTY_TID).as(Long.class), condition.getTid()));
		}

		if (null != condition.getTidMax() ) {
			predicateList.add(cb.greaterThanOrEqualTo(root.get(PipelineExecNode.PROPERTY_TID).as(Long.class), condition.getTidMax()));
		}

		if (null != condition.getTidMin() ) {
			predicateList.add(cb.lessThan(root.get(PipelineExecNode.PROPERTY_TID).as(Long.class), condition.getTidMin()));
		}
	}
	private void tryAddCodePredicate(List<Predicate> predicateList, Root<PipelineExecNode> root, CriteriaBuilder cb){
		if(StringUtils.isNotEmpty(condition.getCode())){
			predicateList.add(cb.like(root.get(PipelineExecNode.PROPERTY_CODE).as(String.class), "%"+condition.getCode()+"%"));
		}
	}
	private void tryAddNamePredicate(List<Predicate> predicateList, Root<PipelineExecNode> root, CriteriaBuilder cb){
		if(StringUtils.isNotEmpty(condition.getName())){
			predicateList.add(cb.like(root.get(PipelineExecNode.PROPERTY_NAME).as(String.class), "%"+condition.getName()+"%"));
		}
	}
	private void tryAddNodeTypePredicate(List<Predicate> predicateList, Root<PipelineExecNode> root, CriteriaBuilder cb){
		if(StringUtils.isNotEmpty(condition.getNodeType())){
			predicateList.add(cb.like(root.get(PipelineExecNode.PROPERTY_NODE_TYPE).as(String.class), "%"+condition.getNodeType()+"%"));
		}
	}
	private void tryAddExecModePredicate(List<Predicate> predicateList, Root<PipelineExecNode> root, CriteriaBuilder cb){
		if(StringUtils.isNotEmpty(condition.getExecMode())){
			predicateList.add(cb.like(root.get(PipelineExecNode.PROPERTY_EXEC_MODE).as(String.class), "%"+condition.getExecMode()+"%"));
		}
	}
	private void tryAddStatusPredicate(List<Predicate> predicateList, Root<PipelineExecNode> root, CriteriaBuilder cb){
		if(StringUtils.isNotEmpty(condition.getStatus())){
			predicateList.add(cb.like(root.get(PipelineExecNode.PROPERTY_STATUS).as(String.class), "%"+condition.getStatus()+"%"));
		}
	}
	private void tryAddResultPredicate(List<Predicate> predicateList, Root<PipelineExecNode> root, CriteriaBuilder cb){
		if(StringUtils.isNotEmpty(condition.getResult())){
			predicateList.add(cb.like(root.get(PipelineExecNode.PROPERTY_RESULT).as(String.class), "%"+condition.getResult()+"%"));
		}
	}
	private void tryAddExecPredicate(List<Predicate> predicateList, Root<PipelineExecNode> root, CriteriaBuilder cb){
	    if (null != condition.getExec() ) {
            predicateList.add(cb.equal(root.get(PipelineExecNode.PROPERTY_EXEC).as(Long.class), condition.getExec()));
        }
	}
	private void tryAddResultMessagePredicate(List<Predicate> predicateList, Root<PipelineExecNode> root, CriteriaBuilder cb){
		if(StringUtils.isNotEmpty(condition.getResultMessage())){
			predicateList.add(cb.like(root.get(PipelineExecNode.PROPERTY_RESULT_MESSAGE).as(String.class), "%"+condition.getResultMessage()+"%"));
		}
	}
	private void tryAddStartTimePredicate(List<Predicate> predicateList, Root<PipelineExecNode> root, CriteriaBuilder cb){

		if (null != condition.getStartTime() ) {
			predicateList.add(cb.equal(root.get(PipelineExecNode.PROPERTY_START_TIME).as(Date.class), condition.getStartTime()));
		}

		if (null != condition.getStartTimeStart() ) {
			predicateList.add(cb.greaterThanOrEqualTo(root.get(PipelineExecNode.PROPERTY_START_TIME).as(Date.class), condition.getStartTimeStart()));
		}

		if (null != condition.getStartTimeEnd() ) {
			predicateList.add(cb.lessThan(root.get(PipelineExecNode.PROPERTY_START_TIME).as(Date.class), condition.getStartTimeEnd()));
		}
	}
	private void tryAddParentIdPredicate(List<Predicate> predicateList, Root<PipelineExecNode> root, CriteriaBuilder cb){
		if(StringUtils.isNotEmpty(condition.getParentId())){
			predicateList.add(cb.equal(root.get(PipelineExecNode.PROPERTY_PARENT_ID).as(String.class), condition.getParentId()));
		}
	}
	private void tryAddRelationObjIdPredicate(List<Predicate> predicateList, Root<PipelineExecNode> root, CriteriaBuilder cb){
	    if (null != condition.getRelationObjId() ) {
            predicateList.add(cb.equal(root.get(PipelineExecNode.PROPERTY_RELATION_OBJ_ID).as(Long.class), condition.getRelationObjId()));
        }
	}
	private void tryAddAutoStartPredicate(List<Predicate> predicateList, Root<PipelineExecNode> root, CriteriaBuilder cb){
		if (null != condition.getAutoStart() ) {
			predicateList.add(cb.equal(root.get(PipelineExecNode.PROPERTY_AUTO_START).as(Boolean.class), condition.getAutoStart()));
		}
	}
	private void tryAddExecIndexPredicate(List<Predicate> predicateList, Root<PipelineExecNode> root, CriteriaBuilder cb){

		if (null != condition.getExecIndex() ) {
			predicateList.add(cb.equal(root.get(PipelineExecNode.PROPERTY_EXEC_INDEX).as(Integer.class), condition.getExecIndex()));
		}

		if (null != condition.getExecIndexMax() ) {
			predicateList.add(cb.greaterThanOrEqualTo(root.get(PipelineExecNode.PROPERTY_EXEC_INDEX).as(Integer.class), condition.getExecIndexMax()));
		}

		if (null != condition.getExecIndexMin() ) {
			predicateList.add(cb.lessThan(root.get(PipelineExecNode.PROPERTY_EXEC_INDEX).as(Integer.class), condition.getExecIndexMin()));
		}
	}
}


