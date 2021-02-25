package com.mariia.syne.taxi_service.controller.rest;

import com.mariia.syne.taxi_service.model.User;
import com.mariia.syne.taxi_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserRestController {

    /*
    GET     /users
    GET     /users/1
    POST    /users
    PUT     /users/1
    DELETE  /users/1
    */

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {

        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id) {

        return userService.getUser(id);
    }

    @PostMapping
    public void addUser(@RequestBody User user) {

        userService.addUser(user);
    }

    @PutMapping("/{id}")
    public void updateUser(@RequestBody User user, @PathVariable Integer id) {

        userService.updateUser(user, id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {

        userService.deleteUser(id);
    }

//    @GetMapping("/init")
//    public void generateOrders() {
//
//        orderService.initTable();
//    }
}

