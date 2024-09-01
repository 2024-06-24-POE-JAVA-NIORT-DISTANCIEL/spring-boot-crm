package com.bigcorp.crm.service;

import com.bigcorp.crm.controller.dto.OrderDto;
import com.bigcorp.crm.dao.ClientDao;
import com.bigcorp.crm.dao.OrderDao;
import com.bigcorp.crm.model.Client;
import com.bigcorp.crm.model.Order;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Contient l'intelligence fonctionnelle des Orders
 */
@Service
public class OrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ClientDao clientDao;

    @Transactional
    public OrderDto save(OrderDto orderDto) {
        LOGGER.info("Saving : {}", orderDto);
        Order order = toEntity(orderDto);
        Order savedOrder = this.orderDao.save(order);
        return toDto(savedOrder);
    }

    public OrderDto findById(Long id) {
        LOGGER.info("Finding order with id : {}", id);
        Optional<Order> optionalOrder = this.orderDao.findById(id);
        if (optionalOrder.isEmpty()) {
            LOGGER.info("Found nothing");
            return null;
        }
        //else...
        Order orderFound = optionalOrder.get();
        LOGGER.info("Found : {}", orderFound);
        return toDto(orderFound);
    }

    @Transactional
    public void delete(Long id) {
        LOGGER.info("Deleting order with id : {}", id);
        orderDao.deleteById(id);
    }


    @Transactional
    public OrderDto update(Long id, OrderDto orderDto) {
        LOGGER.info("Updating order : {} , with id : {}", orderDto, id);
        Optional<Order> optionalOrder = this.orderDao.findById(id);
        if (optionalOrder.isEmpty()) {
            return null;
        }
        //else...
        Order order = toEntity(orderDto);
        order.setId(id);
        order = this.orderDao.save(order);
        return toDto(order);
    }


    private OrderDto toDto(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setServiceType(order.getServiceType());
        orderDto.setTva(order.getTva());
        if (order.getClient() != null) {
            orderDto.setClientId(order.getClient().getId());
            orderDto.setCompanyName(order.getClient().getCompanyName());
        }
        orderDto.setNbDays(order.getNbDays());
        orderDto.setTotalExcludeTax(order.getTotalExcludeTax());
        orderDto.setState(order.getState());
        orderDto.setComment(order.getComment());
        return orderDto;
    }

    private Order toEntity(OrderDto orderDto) {
        Order order = new Order();
        order.setId(orderDto.getId());
        order.setServiceType(orderDto.getServiceType());
        order.setTva(orderDto.getTva());
        if (orderDto.getClientId() != null) {
            Optional<Client> client = this.clientDao.findById(orderDto.getClientId());
            if (client.isPresent()) {
                order.setClient(client.get());
            }
        }
        order.setNbDays(orderDto.getNbDays());
        order.setTotalExcludeTax(orderDto.getTotalExcludeTax());
        order.setState(orderDto.getState());
        order.setComment(orderDto.getComment());
        return order;
    }
}
