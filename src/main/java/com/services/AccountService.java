package com.services;

import com.models.AccountEntity;
import com.models.LoginEntity;
import com.repositorys.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository iAccountRepositorys;
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public AccountEntity checkLogin(LoginEntity loginEntity) {
        Query query = entityManager.createQuery(
                "SELECT a FROM AccountEntity a WHERE a.username= ?1 AND a.password= ?2");
        query.setParameter(1, loginEntity.getUser());
        query.setParameter(2, loginEntity.getPassword());
        List<AccountEntity> accountEntity = query.getResultList();
        if (accountEntity.isEmpty()){
            return null;
        }
        return accountEntity.get(0);
    }

    @Override
    public Iterable<AccountEntity> findAll() {
        return iAccountRepositorys.findAll();
    }

    @Override
    public AccountEntity findById(int id) {
        return iAccountRepositorys.findOne(id);
    }

    @Override
    public void save(AccountEntity accountEntity) {
        iAccountRepositorys.save(accountEntity);
    }

    @Override
    public void delete(AccountEntity accountEntity) {
        iAccountRepositorys.delete(accountEntity);
    }
}
