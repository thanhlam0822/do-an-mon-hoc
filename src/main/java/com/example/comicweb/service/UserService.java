package com.example.comicweb.service;

import com.example.comicweb.model.Role;
import com.example.comicweb.model.User;

import java.util.Optional;

public interface UserService {
    User saveUser(User user);

    Optional<User> findByUsername(String username);

    void changeRole(Role newRole, String username);
    User findById(long userId);
}
