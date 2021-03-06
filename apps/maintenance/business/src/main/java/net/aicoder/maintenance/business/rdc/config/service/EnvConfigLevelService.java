package net.aicoder.maintenance.business.rdc.config.service;


import com.yunkang.saas.common.jpa.GenericCrudService;

import net.aicoder.maintenance.business.rdc.config.dao.EnvConfigLevelDao;
import net.aicoder.maintenance.business.rdc.config.dao.EnvConfigLevelSpecification;
import net.aicoder.maintenance.business.rdc.config.domain.EnvConfigLevel;
import net.aicoder.maintenance.business.rdc.config.dto.EnvConfigLevelCondition;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


@Service("envConfigLevelService")
public class EnvConfigLevelService  extends GenericCrudService<EnvConfigLevel, String, EnvConfigLevelCondition, EnvConfigLevelDao> {

	private static final Logger LOGGER = LoggerFactory.getLogger(EnvConfigLevelService.class);

	@Override
	public Specification<EnvConfigLevel> getSpecification(EnvConfigLevelCondition condition) {
		return new EnvConfigLevelSpecification(condition);
	}

	public Sort getDefaultSort(){

		Sort sort = new Sort(Sort.Direction.DESC , EnvConfigLevel.PROPERTY_NAME);
		return sort;
	}
}