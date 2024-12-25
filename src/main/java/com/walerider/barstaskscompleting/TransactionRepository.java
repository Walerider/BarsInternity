package com.walerider.barstaskscompleting;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, Long>  {
    List<Transaction> findAllByAccountId(Long accountId);
}
