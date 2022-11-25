package com.example.comicweb.service;

import com.example.comicweb.dto.ComicRankingDTO;
import com.example.comicweb.dto.UserDTO;
import com.example.comicweb.model.Role;
import com.example.comicweb.model.User;
import com.example.comicweb.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user)
    {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setCreateTime(LocalDateTime.now());

        return userRepository.save(user);
    }



    @Override
    public Optional<User> findByUsername(String username)
    {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional //Transactional is required when executing an update/delete query.
    public void changeRole(Role newRole, String username)
    {
        userRepository.updateUserRole(username, newRole);
    }

    @Override
    public User findById(long userId) {
        Optional<User> user = userRepository.findById(userId);
        User userList = user.get();
        return userList;
    }

    @Override
    public void updateUser( User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUSer(Long id) {
        userRepository.deleteUser(id);
    }


}
