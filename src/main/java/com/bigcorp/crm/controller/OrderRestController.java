package com.bigcorp.crm.controller;

import com.bigcorp.crm.controller.dto.OrderDto;
import com.bigcorp.crm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderRestController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrderWithPathVariable(@PathVariable("id") Long id) {

        OrderDto orderFound = orderService.findById(id);
        if(orderFound == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(orderFound);
    }

    @PostMapping
    public OrderDto save(@RequestBody OrderDto orderDto) {
        return orderService.save(orderDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDto> save(@PathVariable("id") Long id, @RequestBody OrderDto orderDto) {
        OrderDto savedOrder = orderService.update(id, orderDto);
        if(savedOrder == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(savedOrder);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        orderService.delete(id);
    }

}