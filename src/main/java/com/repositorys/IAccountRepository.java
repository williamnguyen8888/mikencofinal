package com.repositorys;

import com.models.AccountEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IAccountRepository extends PagingAndSortingRepository<AccountEntity, Integer> {
    
}
