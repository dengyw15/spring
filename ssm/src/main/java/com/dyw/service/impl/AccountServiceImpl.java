package com.dyw.service.impl;

import com.dyw.dao.AccountDao;
import com.dyw.domain.Account;
import com.dyw.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;

    @Override
    public List<Account> findAll() {
        System.out.println("AccountService 查询所有账户");
        List<Account> all = accountDao.findAll();
        return all;
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("AccountService 保存账户");
        accountDao.saveAccount(account);
    }
}
