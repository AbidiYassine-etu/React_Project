package com.example.React_back.Services;

import com.example.React_back.Models.Roles;
import com.example.React_back.Models.User;

public interface UserServices {
    User findUserByID(Long id);
    User addUser(User user);
    User updateUser(User user);
    User findUserByRole(Roles role);
    void deleteUser(Long id);
}
