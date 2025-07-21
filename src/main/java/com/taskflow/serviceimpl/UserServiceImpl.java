package com.taskflow.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskflow.entity.User;
import com.taskflow.repository.UserRepository;
import com.taskflow.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    @Override
    public User getUserById(int userId) {
        User user = null;

        try {
            user = userRepository.findById(userId).get();
        }
        catch (Exception e) {
            System.out.println("Exception");
        }
        return user;
    }


    @Override
    public List<User> deleteUserById(int userId) {
        User user = getUserById(userId);
        userRepository.deleteById(user.getUserId());
        return userRepository.findAll();
    }
}