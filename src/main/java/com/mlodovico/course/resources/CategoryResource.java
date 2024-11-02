package com.mlodovico.course.resources;

import com.mlodovico.course.entities.Category;
import com.mlodovico.course.entities.User;
import com.mlodovico.course.services.CategoryService;
import com.mlodovico.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    @Autowired
    private CategoryService service;

    @GetMapping("/get-all-categories")
    public ResponseEntity<List<Category>> getUsers() {
        List<Category> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/get-category-by-id/{id}:categoryId")
    public ResponseEntity<Category> getUserById(@PathVariable final Long id) {
        Category categoryObj = service.findById(id);

        if(categoryObj == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(categoryObj);
    }
}
