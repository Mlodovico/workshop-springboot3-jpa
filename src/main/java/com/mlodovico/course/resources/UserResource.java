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
        List<User> listUser = service.findAll();

        if(userObj == null) {
            return ResponseEntity.notFound().build();
        }

        for (User user: listUser) {
            if(user.getId().equals(id)) {
                return ResponseEntity.ok().body(userObj);
            }
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/insert-new-user")
    public ResponseEntity<User> insert(@RequestBody User newUser) {
        List<User> listAll = service.findAll();

        for (User user: listAll) {
            if(user.getEmail().equals(newUser.getEmail())) {
                return ResponseEntity.status(409).build();
            }
        }

        newUser = service.insert(newUser);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();

        return ResponseEntity.created(uri).body(newUser);
    }

    @DeleteMapping("/delete-user-by-id/{id}:userId")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        List<User> listAll = service.findAll();

        for (User userObj: listAll) {
            if(userObj.getId().equals(id)) {
                service.delete(id);

                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/update-user-by-id/{id}:userId")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
        List<User> listAll = service.findAll();

        for (User userObj: listAll) {
            if(user.getId().equals(userObj.getId())) {
                user = service.update(id, user);

                return ResponseEntity.ok().body(user);
            }
        }

        return ResponseEntity.notFound().build();
    }
}
