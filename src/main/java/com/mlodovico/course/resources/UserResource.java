package com.mlodovico.course.resources;

import com.mlodovico.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping("/get-all-users")
    public ResponseEntity<User> getUsers() {
        User user = new User(1L, "Maria", "maria@gmail.com", "199231332", "123123");
        return ResponseEntity.ok().body(user);
    }
}
