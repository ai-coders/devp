package net.aicoder.devp.business.sys.service;


import com.yunkang.saas.common.jpa.GenericCrudService;
import net.aicoder.devp.business.sys.dao.DevpSysCmpDao;
import net.aicoder.devp.business.sys.dao.DevpSysCmpSpecification;
import net.aicoder.devp.business.sys.domain.DevpSysCmp;
import net.aicoder.devp.business.sys.dto.DevpSysCmpCondition;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


@Service("devpSysCmpService")
public class DevpSysCmpService  extends GenericCrudService<DevpSysCmp, Long, DevpSysCmpCondition, DevpSysCmpDao> {

	private static final Logger LOGGER = LoggerFactory.getLogger(DevpSysCmpService.class);

	@Override
	public Specification<DevpSysCmp> getSpecification(DevpSysCmpCondition condition) {
		return new DevpSysCmpSpecification(condition);
	}

	public Sort getDefaultSort(){

		Sort sort = new Sort(Sort.Direction.DESC, DevpSysCmp.PROPERTY_TID);
		return sort;
	}
}