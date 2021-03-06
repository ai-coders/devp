package net.aicoder.devp.business.ops.service;


import com.yunkang.saas.common.jpa.GenericCrudService;
import net.aicoder.devp.business.ops.dao.DevpOpsCiGroupDao;
import net.aicoder.devp.business.ops.dao.DevpOpsCiGroupSpecification;
import net.aicoder.devp.business.ops.domain.DevpOpsCiGroup;
import net.aicoder.devp.business.ops.dto.DevpOpsCiGroupCondition;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


@Service("devpOpsCiGroupService")
public class DevpOpsCiGroupService  extends GenericCrudService<DevpOpsCiGroup, Long, DevpOpsCiGroupCondition, DevpOpsCiGroupDao> {

	private static final Logger LOGGER = LoggerFactory.getLogger(DevpOpsCiGroupService.class);

	@Override
	public Specification<DevpOpsCiGroup> getSpecification(DevpOpsCiGroupCondition condition) {
		return new DevpOpsCiGroupSpecification(condition);
	}

	public Sort getDefaultSort(){

		Sort sort = new Sort(Sort.Direction.DESC, DevpOpsCiGroup.PROPERTY_TID);
		return sort;
	}
}