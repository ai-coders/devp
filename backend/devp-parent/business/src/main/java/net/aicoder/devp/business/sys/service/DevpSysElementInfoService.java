package net.aicoder.devp.business.sys.service;


import com.yunkang.saas.common.jpa.GenericCrudService;
import net.aicoder.devp.business.sys.dao.DevpSysElementInfoDao;
import net.aicoder.devp.business.sys.dao.DevpSysElementInfoSpecification;
import net.aicoder.devp.business.sys.domain.DevpSysElementInfo;
import net.aicoder.devp.business.sys.dto.DevpSysElementInfoCondition;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


@Service("devpSysElementInfoService")
public class DevpSysElementInfoService  extends GenericCrudService<DevpSysElementInfo, Long, DevpSysElementInfoCondition, DevpSysElementInfoDao> {

	private static final Logger LOGGER = LoggerFactory.getLogger(DevpSysElementInfoService.class);

	@Override
	public Specification<DevpSysElementInfo> getSpecification(DevpSysElementInfoCondition condition) {
		return new DevpSysElementInfoSpecification(condition);
	}

	public Sort getDefaultSort(){

		Sort sort = new Sort(Sort.Direction.DESC, DevpSysElementInfo.PROPERTY_TID);
		return sort;
	}
}