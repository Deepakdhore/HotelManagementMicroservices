package com.lcwd.user.service.UserService.services.impl;

import com.lcwd.user.service.UserService.entites.User;
import com.lcwd.user.service.UserService.exceptions.ResourceNotFoundExcetion;
import com.lcwd.user.service.UserService.repositories.UserRepository;
import com.lcwd.user.service.UserService.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private RestTemplate restTemplate;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

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
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundExcetion("user not found " + userId));
        

        //url
        //http://localhost:8083/ratings/users/b932f584-100d-48d4-9568-55a66455de00

        ArrayList ratingObject = restTemplate.getForObject("http://localhost:8083/ratings/users/b932f584-100d-48d4-9568-55a66455de00", ArrayList.class);

        user.setRatings(ratingObject);

        logger.info("{} ",ratingObject);
        return user;
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
