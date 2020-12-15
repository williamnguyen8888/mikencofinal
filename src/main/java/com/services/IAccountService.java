package com.services;

import com.models.AccountEntity;
import com.models.LoginEntity;


public interface IAccountService {
    Iterable<AccountEntity> findAll();
    AccountEntity findById(int id);
    AccountEntity checkLogin(LoginEntity loginEntity);
    void edit(AccountEntity accountEntity);
    void save(AccountEntity accountEntity);
    void delete(int id);
}
