package com.example.userservice.services;

import com.example.userservice.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public void addUser(User user);

    public Iterable<User> getAllUsers();

    public User getUserById(Long userId);

    public void deleteUser(Long userId);

    public List<Long> getAllIds();
}
