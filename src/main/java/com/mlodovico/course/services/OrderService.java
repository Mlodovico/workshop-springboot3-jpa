package com.mlodovico.course.services;

import com.mlodovico.course.entities.Order;
import com.mlodovico.course.entities.User;
import com.mlodovico.course.repositories.OrderRepository;
import com.mlodovico.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> orderObj = repository.findById(id);

        return orderObj.get();
    }
}
