package net.aicoder.devp.business.deploy.service;


import com.yunkang.saas.common.jpa.GenericCrudService;
import net.aicoder.devp.business.deploy.dao.DevpSysDpySchemeDao;
import net.aicoder.devp.business.deploy.dao.DevpSysDpySchemeSpecification;
import net.aicoder.devp.business.deploy.domain.DevpSysDpyScheme;
import net.aicoder.devp.business.deploy.dto.DevpSysDpySchemeCondition;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


@Service("devpSysDpySchemeService")
public class DevpSysDpySchemeService  extends GenericCrudService<DevpSysDpyScheme, Long, DevpSysDpySchemeCondition, DevpSysDpySchemeDao> {

	private static final Logger LOGGER = LoggerFactory.getLogger(DevpSysDpySchemeService.class);

	@Override
	public Specification<DevpSysDpyScheme> getSpecification(DevpSysDpySchemeCondition condition) {
		return new DevpSysDpySchemeSpecification(condition);
	}

	public Sort getDefaultSort(){

		Sort sort = new Sort(Sort.Direction.DESC, DevpSysDpyScheme.PROPERTY_TID);
		return sort;
	}
}