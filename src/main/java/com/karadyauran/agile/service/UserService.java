package com.karadyauran.agile.service;

import com.karadyauran.agile.entity.User;
import com.karadyauran.agile.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService
{
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers()
    {
        return userRepository.findAllUsers();
    }

    public User getUserByName(String username)
    {
        return userRepository.findByName(username).orElse(null);
    }

    public User getUserById(String userId)
    {
        return userRepository.findById(UUID.fromString(userId)).orElse(null);
    }
}
