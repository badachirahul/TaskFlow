package com.taskflow.service;

import java.util.List;

import com.taskflow.entity.User;

public interface UserService {

    public User addUser(User user);

    public List<User> getAllUsers();

    public User getUserById(int userId);

    public List<User> deleteUserById(int userId);

}