package com.mlodovico.course.resources;

import com.mlodovico.course.entities.User;
import com.mlodovico.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.ServiceConfigurationError;

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

    @PostMapping("/insert-new-user")
    public ResponseEntity<User> insert(@RequestBody User newUser) {
        newUser = service.insert(newUser);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();

        return ResponseEntity.created(uri).body(newUser);
    }

    @DeleteMapping("/delete-user-by-id/{id}:userId")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
