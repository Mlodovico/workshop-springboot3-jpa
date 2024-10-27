package com.mlodovico.course.resources;

import com.mlodovico.course.entities.Order;
import com.mlodovico.course.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    private OrderService service;

    @GetMapping("/get-all-orders")
    public ResponseEntity<List<Order>> getOrders() {
        List<Order> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/get-order-by-id/{id}:orderId")
    public ResponseEntity<Order> getOrderById(@PathVariable final Long id) {
        Order orderObj = service.findById(id);

        if(orderObj == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(orderObj);
    }
}
