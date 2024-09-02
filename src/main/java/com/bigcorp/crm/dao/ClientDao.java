package com.bigcorp.crm.dao;

import com.bigcorp.crm.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientDao extends CrudRepository<Client, Long> {
    Client findWithOrderById(Long id);
}
