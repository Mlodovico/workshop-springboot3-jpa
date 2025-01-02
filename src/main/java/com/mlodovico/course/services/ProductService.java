package com.mlodovico.course.services;

import com.mlodovico.course.entities.Product;
import com.mlodovico.course.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error fetching all products", e);
        }
    }

    public Product findById(Long id) {
        try {
            Optional<Product> userObj = repository.findById(id);

            return userObj.get();
        } catch (Exception e) {
            throw new RuntimeException("Error fetching product by ID", e);
        }
    }
}
