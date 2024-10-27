package com.mlodovico.course.resources;

import com.mlodovico.course.entities.User;
import com.mlodovico.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping("/get-all-users")
    public ResponseEntity<List<User>> getUsers() {
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/get-user-by-id/{id}:userId")
    public ResponseEntity<User> getUserById(@PathVariable final Long id) {
        User userObj = service.findById(id);

        if(userObj == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(userObj);
    }
}
