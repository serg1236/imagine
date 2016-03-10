package com.dakhniy.imagine.service.impl;

import com.dakhniy.imagine.model.User;
import com.dakhniy.imagine.repisitory.ImageRepository;
import com.dakhniy.imagine.repisitory.UserRepository;
import com.dakhniy.imagine.service.UserService;

import java.util.List;

/**
 * Created by Sergiy_Dakhniy
 */
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public boolean isUserExists(String login) {
        return userRepository.findByFbId(login) != null;
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public User getUser(String login) {
        return userRepository.findByFbId(login);
    }

    public boolean isUserExists(User user) {
        return isUserExists(user.getFbId());
    }

    public List<User> getUserList(String excludedUser) {
        return userRepository.getAllExceptOne(excludedUser);
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
