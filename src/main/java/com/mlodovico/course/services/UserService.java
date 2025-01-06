package com.mlodovico.course.services;

import com.mlodovico.course.entities.User;
import com.mlodovico.course.repositories.UserRepository;
import com.mlodovico.course.services.exceptions.DatabaseException;
import com.mlodovico.course.services.exceptions.ResourcesNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error fetching all users", e);
        }
    }

    public User findById(Long id) {
        try {
            Optional<User> userObj = repository.findById(id);

            return userObj.orElseThrow(() -> new ResourcesNotFoundException(id));
        } catch (Exception e) {
            throw new RuntimeException("Error fetching user by ID", e);
        }
    }

    public User insert(User newUser) {
        try {
            return repository.save(newUser);
        } catch (Exception e) {
            throw new RuntimeException("Error inserting new user", e);
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourcesNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User user) {
        try {
            User entity = repository.getReferenceById(id);
            updateData(entity, user);

            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourcesNotFoundException(id);
        }
    }

    public void updateData(User entity, User user) {
        try {
            entity.setName(user.getName());
            entity.setEmail(user.getEmail());
            entity.setPhone(user.getPhone());
        } catch (Exception e) {
            throw new RuntimeException("Error updating user data", e);
        }
    }
}
