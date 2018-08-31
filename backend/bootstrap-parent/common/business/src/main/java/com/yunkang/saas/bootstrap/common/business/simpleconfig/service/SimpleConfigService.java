package com.yunkang.saas.bootstrap.common.business.simpleconfig.service;


import com.yunkang.saas.bootstrap.common.business.simpleconfig.dao.SimpleConfigDao;
import com.yunkang.saas.bootstrap.common.business.simpleconfig.dao.SimpleConfigSpecification;
import com.yunkang.saas.bootstrap.common.business.simpleconfig.domain.SimpleConfig;
import com.yunkang.saas.bootstrap.common.business.simpleconfig.dto.SimpleConfigCondition;
import com.yunkang.saas.common.jpa.GenericCrudService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("simpleConfigService")
public class SimpleConfigService  extends GenericCrudService<SimpleConfig, Long, SimpleConfigCondition, SimpleConfigDao> {

	private static final Logger LOGGER = LoggerFactory.getLogger(SimpleConfigService.class);

	@Override
	public Specification<SimpleConfig> getSpecification(SimpleConfigCondition condition) {
		return new SimpleConfigSpecification(condition);
	}

	List<SimpleConfig> findByConfigType(String typeCode){
		return dao.findByConfigType(typeCode);
	}

	public SimpleConfig findByConfigTypeAndCode(String typeCode, String code){
		return dao.findByConfigTypeAndCode(typeCode, code);
	}

	public Sort getDefaultSort(){

		Sort sort = new Sort(Sort.Direction.DESC , SimpleConfig.PROPERTY_CONFIG_TYPE);
		return sort;
	}
}