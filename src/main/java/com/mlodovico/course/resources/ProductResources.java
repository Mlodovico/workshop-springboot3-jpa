package com.mlodovico.course.resources;

import com.mlodovico.course.entities.Product;
import com.mlodovico.course.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductResources {

    @Autowired
    private ProductService service;

    @GetMapping("/get-all-products")
    public ResponseEntity<List<Product>> getUsers() {
        List<Product> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/get-product-by-id/{id}:productId")
    public ResponseEntity<Product> getUserById(@PathVariable final Long id) {
        Product ProductObj = service.findById(id);

        if(ProductObj == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(ProductObj);
    }
}
