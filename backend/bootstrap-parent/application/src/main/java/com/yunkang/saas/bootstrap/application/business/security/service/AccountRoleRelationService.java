package com.yunkang.saas.bootstrap.application.business.security.service;



import com.yunkang.saas.bootstrap.application.business.security.dao.AccountRoleRelationDao;
import com.yunkang.saas.bootstrap.application.business.security.dao.AccountRoleRelationSpecification;
import com.yunkang.saas.bootstrap.application.business.security.domain.AccountRoleRelation;
import com.yunkang.saas.bootstrap.platform.business.account.dto.AccountRoleRelationCondition;
import com.yunkang.saas.common.jpa.GenericCrudService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


@Service("accountRoleRelationService")
public class AccountRoleRelationService  extends GenericCrudService<AccountRoleRelation, Long, AccountRoleRelationCondition, AccountRoleRelationDao> {

	private static final Logger LOGGER = LoggerFactory.getLogger(AccountRoleRelation.class);

	public AccountRoleRelation findByRoleIdAndAccountId(Long roleId, Long accountId){
		return dao.findByRoleIdAndAccountId(roleId, accountId);
	}

	@Override
	public Specification<AccountRoleRelation> getSpecification(AccountRoleRelationCondition condition) {
		return new AccountRoleRelationSpecification(condition);
	}

	public Sort getDefaultSort(){

		Sort sort = new Sort(Sort.Direction.DESC , AccountRoleRelation.PROPERTY_ACCOUNT_ID);
		return sort;
	}
}