package com.yunkang.saas.security.service.business.platform.service;


import com.yunkang.saas.security.service.business.platform.domain.Account;
import com.yunkang.saas.security.service.business.platform.domain.SecurityUser;
import com.yunkang.saas.security.model.dto.AccountCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by gonghongrui on 2017/1/10.
 */
@Service
public class SecurityUserService implements UserDetailsService {

	@Autowired
	private AccountService accountService;

	@Override
	public SecurityUser loadUserByUsername(String username) throws UsernameNotFoundException {

		AccountCondition accountCondition = new AccountCondition();
		accountCondition.setAccountName(username);
		Account account = accountService.findOne(accountCondition);
		if(account == null){
			throw new UsernameNotFoundException("用户名不存在");

		}

		return new SecurityUser(account, null);
	}

}