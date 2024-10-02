package com.example.React_back.Controllers;

import com.example.React_back.Models.Roles;
import com.example.React_back.Models.User;
import com.example.React_back.Services.Impl.UserServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServicesImpl userServices;

    @GetMapping("/findUserById/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userServices.findUserByID(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/findUserByRole/{role}")
    public ResponseEntity<User> getUserByRole(@PathVariable String role) {
        try {
            Roles roleEnum = Roles.valueOf(role.toUpperCase());
            User user = userServices.findUserByRole(roleEnum);
            if (user != null) {
                return ResponseEntity.ok(user);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User createdUser = userServices.addUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        user.setId(id); // Ensure the ID is set for the update operation
        User updatedUser = userServices.updateUser(user);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userServices.deleteUser(id);
        return ResponseEntity.noContent().build(); // Return 204 status code (No Content)
    }
}
