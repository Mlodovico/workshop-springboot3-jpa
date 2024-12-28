package com.mlodovico.course.services;

import com.mlodovico.course.entities.User;
import com.mlodovico.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> userObj = repository.findById(id);

        return userObj.get();
    }

    public User insert(User newUser) {
        return repository.save(newUser);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
