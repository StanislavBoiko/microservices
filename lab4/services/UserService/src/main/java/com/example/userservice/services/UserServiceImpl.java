package com.example.userservice.services;

import com.example.userservice.entities.User;
import com.example.userservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(User user) {
         userRepository.save(user);
    }

    @Override
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.getReferenceById(userId);
    }

    @Override
    public void deleteUser(Long userId) {
         userRepository.deleteById(userId);
    }

    @Override
    public List<Long> getAllIds() {
        List<User> products = userRepository.findAll();
        List<Long> ids = new ArrayList<Long>();
        products.forEach(user -> ids.add(user.getId()));
        return ids;
    }
}
