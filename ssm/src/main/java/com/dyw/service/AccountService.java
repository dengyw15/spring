package com.dyw.service;

import com.dyw.domain.Account;

import java.util.List;

public interface AccountService {

    public List<Account> findAll();

    public void saveAccount(Account account);
}
