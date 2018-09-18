package net.aicoder.speedcloud.business.pipeline.exec.service;


import com.yunkang.saas.common.jpa.GenericCrudService;
import net.aicoder.speedcloud.business.pipeline.exec.dao.PipelineExecInstanceNodeDao;
import net.aicoder.speedcloud.business.pipeline.exec.dao.PipelineExecInstanceNodeSpecification;
import net.aicoder.speedcloud.business.pipeline.exec.domain.PipelineExecInstance;
import net.aicoder.speedcloud.business.pipeline.exec.domain.PipelineExecInstanceNode;
import net.aicoder.speedcloud.business.pipeline.exec.dto.PipelineExecInstanceNodeCondition;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("pipelineExecInstanceNodeService")
public class PipelineExecInstanceNodeService  extends GenericCrudService<PipelineExecInstanceNode, Long, PipelineExecInstanceNodeCondition, PipelineExecInstanceNodeDao> {

	private static final Logger LOGGER = LoggerFactory.getLogger(PipelineExecInstanceNodeService.class);


	public List<PipelineExecInstanceNode> findChildNode(Long parentNodeId){
		return dao.findByParentIdOrderByExecIndex(parentNodeId);
	}

	/**
	 * 查找下一个可执行的子节点
	 * @param parentNodeId
	 * @return
	 */
	public PipelineExecInstanceNode findNextWaitingChildNode(Long parentNodeId){

		Pageable pageable = new PageRequest(0 ,1);

		List<PipelineExecInstanceNode> nodeList = dao.findByParentIdAndStatusOrderByExecIndex(parentNodeId, PipelineExecInstanceNodeStatus.WAIT, pageable);

		PipelineExecInstanceNode result = null;

		if(CollectionUtils.isNotEmpty(nodeList)){
			result = nodeList.get(0);
		}

		return result;
	}

	/**
	 * 查询还没开始执行的实例
	 * @param tid
	 * @return
	 */
	public List<PipelineExecInstanceNode> findPreparedJob(Long tid){
		return dao.findByTidAndStatus(tid, PipelineExecInstanceNodeStatus.PREPARED);
	}

	/**
	 * 查询处于等待中的实例
	 * @param tid
	 * @return
	 */
	public List<PipelineExecInstanceNode> findWaitingJob(Long tid){
		return dao.findByTidAndStatus(tid, PipelineExecInstanceNodeStatus.WAIT);
	}

	@Override
	public Specification<PipelineExecInstanceNode> getSpecification(PipelineExecInstanceNodeCondition condition) {
		return new PipelineExecInstanceNodeSpecification(condition);
	}

	public Sort getDefaultSort(){

		Sort sort = new Sort(Sort.Direction.DESC, PipelineExecInstanceNode.PROPERTY_CODE);
		return sort;
	}
}