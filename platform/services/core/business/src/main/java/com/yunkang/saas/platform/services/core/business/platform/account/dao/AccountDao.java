package com.yunkang.saas.platform.services.core.business.platform.account.dao;

import com.yunkang.saas.common.jpa.BaseDao;
import com.yunkang.saas.platform.services.core.business.platform.account.domain.Account;
import org.springframework.stereotype.Repository;


/**
 * 账号的数据库操作
 * @author icode
 */
@Repository("accountDao")
public interface AccountDao extends BaseDao<Account, Long>{


}