package com.lcwd.user.service.UserService.services.impl;

import com.lcwd.user.service.UserService.entites.User;
import com.lcwd.user.service.UserService.exceptions.ResourceNotFoundExcetion;
import com.lcwd.user.service.UserService.repositories.UserRepository;
import com.lcwd.user.service.UserService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        return userRepository.findById(userId).orElseThrow(() ->new ResourceNotFoundExcetion("user not found "+userId));
    }

//    @Override
//    public User deleteUser(String userId) {
//
//        User user = getUser(userId);
//       userRepository.deleteById(userId);
//          return user;
//
//    }
}
