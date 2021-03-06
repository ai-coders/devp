package net.aicoder.devp.business.ops.service;


import com.yunkang.saas.common.jpa.GenericCrudService;
import net.aicoder.devp.business.ops.dao.DevpOpsAttachmentDao;
import net.aicoder.devp.business.ops.dao.DevpOpsAttachmentSpecification;
import net.aicoder.devp.business.ops.domain.DevpOpsAttachment;
import net.aicoder.devp.business.ops.dto.DevpOpsAttachmentCondition;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


@Service("devpOpsAttachmentService")
public class DevpOpsAttachmentService  extends GenericCrudService<DevpOpsAttachment, Long, DevpOpsAttachmentCondition, DevpOpsAttachmentDao> {

	private static final Logger LOGGER = LoggerFactory.getLogger(DevpOpsAttachmentService.class);

	@Override
	public Specification<DevpOpsAttachment> getSpecification(DevpOpsAttachmentCondition condition) {
		return new DevpOpsAttachmentSpecification(condition);
	}

	public Sort getDefaultSort(){

		Sort sort = new Sort(Sort.Direction.DESC, DevpOpsAttachment.PROPERTY_TID);
		return sort;
	}
}