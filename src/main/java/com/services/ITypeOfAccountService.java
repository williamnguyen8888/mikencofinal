package com.services;

import com.models.TypeofaccountEntity;

public interface ITypeOfAccountService {
    Iterable<TypeofaccountEntity> findAll();
    TypeofaccountEntity findById(int id);
    void save(TypeofaccountEntity typeofaccountEntity);
    void delete(int id);
}
