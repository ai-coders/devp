package com.yunkang.saas.bootstrap.application.business.tenant.service;

import com.yunkang.saas.bootstrap.application.business.security.domain.AccountRoleRelation;
import com.yunkang.saas.bootstrap.application.business.security.domain.Role;
import com.yunkang.saas.bootstrap.application.business.security.service.AccountRoleRelationService;
import com.yunkang.saas.bootstrap.application.business.security.service.ApplicationRoleService;
import com.yunkang.saas.bootstrap.application.business.security.service.RoleService;
import com.yunkang.saas.bootstrap.platform.business.account.domain.Account;
import com.yunkang.saas.bootstrap.platform.business.account.domain.AccountPassword;
import com.yunkang.saas.bootstrap.platform.business.account.service.AccountManageService;

import com.yunkang.saas.bootstrap.platform.business.account.service.AccountService;

import com.yunkang.saas.bootstrap.platform.business.tenant.domain.Tenant;
import com.yunkang.saas.bootstrap.platform.business.tenant.domain.TenantAddEvent;
import com.yunkang.saas.bootstrap.platform.business.tenant.domain.TenantAdminAccount;
import com.yunkang.saas.bootstrap.platform.business.tenant.service.TenantAdminAccountService;
import com.yunkang.saas.bootstrap.platform.business.tenant.service.TenantService;
import com.yunkang.saas.common.framework.app.ApplicationProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TenantManageService implements ApplicationListener<TenantAddEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TenantManageService.class);
    @Autowired
    private ApplicationProperties applicationProperties;

    @Autowired
    private TenantService tenantService;

    @Autowired
    private ApplicationRoleService applicationRoleService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountManageService accountManageService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private TenantAdminAccountService tenantAdminAccountService;

    @Autowired
    private AccountRoleRelationService accountRoleRelationService;

    /**
     * 应用新增租户
     */
    @Transactional
    public void createTenant(Tenant tenant, Integer appCode){

        /*
         * 1.新增租户
         * 2.给租户开通权限
         */
        tenantService.add(tenant);
        openApplicationForTenant(tenant.getTid(), appCode);

    }



    /**
     * 租户开通应用
     */
    public void openApplicationForTenant(Long tenantId, Integer appCode){

        /*
         * 1.给租户创建应用管理员角色
         * 2.给租户管理员设置应用管理员角色
         */

        Tenant tenant = tenantService.find(tenantId);
        if(tenant == null){
            return;
        }

        Role role = roleService.findApplicationManagerForTenant(appCode+"", tenantId);

        if(role == null){
            role = new Role();
            role.setAppCode(appCode+"");
            role.setName("应用管理员");
            role.setCode(RoleService.CODE_APPLICATION_MANAGER);
            role.setTid(tenantId);
            roleService.add(role);
        }

        applicationRoleService.checkApplicationManagerResource(role.getId());

        TenantAdminAccount tenantAdminAccount = tenantAdminAccountService.findByTid(tenantId);

        if(tenantAdminAccount == null){
            tenantAdminAccount = new TenantAdminAccount();
            tenantAdminAccount.setTid(tenantId);
            tenantAdminAccount.setAccountName(tenant.getTenantCode()+"_");
            tenantAdminAccountService.add(tenantAdminAccount);
        }

        Account account = accountService.findByAccountName(tenantAdminAccount.getAccountName());
        if(account == null ){

            account = new Account();
            account.setTid(tenantId);
            account.setAccountName(tenantAdminAccount.getAccountName());
            account.setName(tenant.getName());
            account.setEnable(true);

            AccountPassword accountPassword = new AccountPassword();
            accountPassword.setAccountName(tenantAdminAccount.getAccountName());
            accountPassword.setPassword(tenant.getTenantCode());
            accountPassword.setTid(tenantId);

            accountManageService.add(account, accountPassword);
        }

        AccountRoleRelation accountRoleRelation = accountRoleRelationService.findByRoleIdAndAccountId(role.getId(), account.getId());

        if(accountRoleRelation == null){
            accountRoleRelation = new AccountRoleRelation();
            accountRoleRelation.setAccountId(account.getId());
            accountRoleRelation.setRoleId(role.getId());
            accountRoleRelationService.add(accountRoleRelation);
        }


    }

    @Override
    public void onApplicationEvent(TenantAddEvent event) {
        Tenant tenant = event.getTenant();
        if(tenant.getId() == null){
            LOGGER.error("Tenant has no id:", tenant.toString());
            return;
        }
        this.openApplicationForTenant(tenant.getId(), applicationProperties.getCode());
    }
}
