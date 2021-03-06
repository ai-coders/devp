package com.yunkang.saas.bootstrap.platform.business.account.service;


import com.yunkang.saas.bootstrap.platform.business.account.dao.AccountDao;
import com.yunkang.saas.bootstrap.platform.business.account.dao.AccountSpecification;
import com.yunkang.saas.bootstrap.platform.business.account.domain.Account;
import com.yunkang.saas.bootstrap.platform.business.account.dto.AccountCondition;
import com.yunkang.saas.common.jpa.GenericCrudService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


@Service("accountService")
public class AccountService  extends GenericCrudService<Account, Long, AccountCondition, AccountDao> {

	private static final Logger LOGGER = LoggerFactory.getLogger(Account.class);


	public Account findByAccountName(String accountName){
		return dao.findByAccountName(accountName);
	}

	@Override
	public Specification<Account> getSpecification(AccountCondition condition) {
		return new AccountSpecification(condition);
	}

	public Sort getDefaultSort(){

		Sort sort = new Sort(Sort.Direction.DESC , Account.PROPERTY_NICK_NAME);
		return sort;
	}
}