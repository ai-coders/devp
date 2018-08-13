package com.yunkang.saas.platform.business.common.service;



import com.yunkang.saas.common.jpa.GenericCrudService;
import com.yunkang.saas.platform.business.common.dao.AttachmentDao;
import com.yunkang.saas.platform.business.common.dao.AttachmentSpecification;
import com.yunkang.saas.platform.business.common.domain.Attachment;
import com.yunkang.saas.platform.business.common.dto.AttachmentCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


@Service("attachmentService")
public class AttachmentService  extends GenericCrudService<Attachment, Long, AttachmentCondition, AttachmentDao> {

	private static final Logger LOGGER = LoggerFactory.getLogger(AttachmentService.class);

	@Override
	public Specification<Attachment> getSpecification(AttachmentCondition condition) {
		return new AttachmentSpecification(condition);
	}

	public Sort getDefaultSort(){

		Sort sort = new Sort(Sort.Direction.DESC , Attachment.PROPERTY_NAME);
		return sort;
	}
}