package com.example.React_back.Services.Impl;

import com.example.React_back.Models.Roles;
import com.example.React_back.Models.User;
import com.example.React_back.Repository.UserRepository;
import com.example.React_back.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServicesImpl implements UserServices {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User findUserByID(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null); // Returns the user if present, else returns null
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user); // Saves and returns the newly created user
    }

    @Override
    public User updateUser(User user) {
        // Checks if the user exists before updating
        if (userRepository.existsById(user.getId())) {
            return userRepository.save(user); // Updates and returns the user
        } else {
            return null; // Returns null if the user doesn't exist
        }
    }


    @Override
    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id); // Deletes the user by ID if present
        }
    }

    @Override
    public User findUserByRole(Roles role) {
        Optional<User> user = userRepository.findByRole(role);
        return user.orElse(null); // Returns the user if found, else returns null
    }
}
