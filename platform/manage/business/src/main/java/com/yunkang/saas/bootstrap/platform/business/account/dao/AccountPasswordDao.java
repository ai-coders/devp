package com.yunkang.saas.bootstrap.platform.business.account.dao;

import com.yunkang.saas.common.jpa.BaseDao;
import com.yunkang.saas.bootstrap.platform.business.account.domain.AccountPassword;
import org.springframework.stereotype.Repository;


/**
 * 账号密码的数据库操作
 * @author icode
 */
@Repository("accountPasswordDao")
public interface AccountPasswordDao extends BaseDao<AccountPassword, Long>{

    AccountPassword findByAccountId(Long accountId);

}
