package com.karadyauran.agile.controller;

import com.karadyauran.agile.entity.User;
import com.karadyauran.agile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users/")
public class UserController
{
    @Autowired
    UserService userService;

    @GetMapping("/get-all-users")
    public List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }

    @GetMapping("/get-user-by-name")
    public User getUserByName(@RequestParam String username)
    {
        return userService.getUserByName(username);
    }

    @GetMapping("/get-user-by-id")
    public User getUserById(@RequestParam String userId)
    {
        return userService.getUserById(userId);
    }
}
