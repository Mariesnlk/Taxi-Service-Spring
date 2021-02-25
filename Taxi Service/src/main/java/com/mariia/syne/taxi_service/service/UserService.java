package com.mariia.syne.taxi_service.service;

import com.mariia.syne.taxi_service.model.User;
import com.mariia.syne.taxi_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public List<User> getAllUsers() {

        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public User getUser(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public void addUser(User user) {

        userRepository.save(user);
    }

    public void updateUser(User user, Integer id) {

        userRepository.save(user);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}

