package com.yunkang.saas.platform.authentication.business.platform.tenant.dao;

import com.yunkang.saas.common.jpa.BaseDao;
import com.yunkang.saas.platform.authentication.business.platform.tenant.domain.TenantAdminAccount;
import org.springframework.stereotype.Repository;


/**
 * 租户管理员账号的数据库操作
 * @author icode
 */
@Repository("tenantAdminAccountDao")
public interface TenantAdminAccountDao extends BaseDao<TenantAdminAccount, Long>{


}