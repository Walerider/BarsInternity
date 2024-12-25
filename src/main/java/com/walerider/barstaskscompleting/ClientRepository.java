package com.walerider.barstaskscompleting;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    public List<Client> findByName(String name);
    @Override
    public Client save(Client client);

}
