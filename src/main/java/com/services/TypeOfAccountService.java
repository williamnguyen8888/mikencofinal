package com.services;

import com.models.TypeofaccountEntity;
import com.repositorys.ITypeOfAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TypeOfAccountService implements ITypeOfAccountService {
    @Autowired
    private ITypeOfAccountRepository iTypeOfAccountRepository;

    @Override
    public Iterable<TypeofaccountEntity> findAll() {
        return iTypeOfAccountRepository.findAll();
    }

    @Override
    public TypeofaccountEntity findById(int id) {
        return iTypeOfAccountRepository.findOne(id);
    }

    @Override
    public void save(TypeofaccountEntity typeofaccountEntity) {
        iTypeOfAccountRepository.save(typeofaccountEntity);
    }

    @Override
    public void delete(int id) {
        iTypeOfAccountRepository.delete(id);
    }
}
