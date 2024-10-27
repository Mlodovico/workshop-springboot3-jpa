package com.mlodovico.course.repositories;

import com.mlodovico.course.entities.Order;
import com.mlodovico.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
