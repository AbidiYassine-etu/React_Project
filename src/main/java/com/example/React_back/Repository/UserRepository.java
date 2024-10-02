package com.example.React_back.Repository;

import com.example.React_back.Models.Roles;
import com.example.React_back.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByRole(Roles role);
}
