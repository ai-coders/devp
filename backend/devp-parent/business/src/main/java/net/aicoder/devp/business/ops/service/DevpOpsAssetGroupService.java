package net.aicoder.devp.business.ops.service;


import com.yunkang.saas.common.jpa.GenericCrudService;
import net.aicoder.devp.business.ops.dao.DevpOpsAssetGroupDao;
import net.aicoder.devp.business.ops.dao.DevpOpsAssetGroupSpecification;
import net.aicoder.devp.business.ops.domain.DevpOpsAssetGroup;
import net.aicoder.devp.business.ops.dto.DevpOpsAssetGroupCondition;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


@Service("devpOpsAssetGroupService")
public class DevpOpsAssetGroupService  extends GenericCrudService<DevpOpsAssetGroup, Long, DevpOpsAssetGroupCondition, DevpOpsAssetGroupDao> {

	private static final Logger LOGGER = LoggerFactory.getLogger(DevpOpsAssetGroupService.class);

	@Override
	public Specification<DevpOpsAssetGroup> getSpecification(DevpOpsAssetGroupCondition condition) {
		return new DevpOpsAssetGroupSpecification(condition);
	}

	public Sort getDefaultSort(){

		Sort sort = new Sort(Sort.Direction.DESC, DevpOpsAssetGroup.PROPERTY_TID);
		return sort;
	}
}