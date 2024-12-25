package com.walerider.barstaskscompleting;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Long> {
    List<Account> findAllByClientId(Long clientId);
}
