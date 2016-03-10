package com.dakhniy.imagine.service;

import com.dakhniy.imagine.model.Image;
import com.dakhniy.imagine.model.User;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Sergiy_Dakhniy
 */
public interface UserService {

    boolean isUserExists(String login);

    void save(User user);

    User getUser(String login);

    boolean isUserExists(User user);

    List<User> getUserList(String excludedUser);
}
