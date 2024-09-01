package com.bigcorp.crm.dao;

import com.bigcorp.crm.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao extends CrudRepository<Order, Long> {

}