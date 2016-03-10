package com.dakhniy.imagine.controller;

import com.dakhniy.imagine.model.User;
import com.dakhniy.imagine.service.UserService;
import com.dakhniy.imagine.util.JsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * Created by Sergiy_Dakhniy
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public @ResponseBody String auth(@RequestBody String json) {
        User user = null;
        try {
            user = JsonUtils.jsonToObject(json, User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(!userService.isUserExists(user)){
            userService.save(user);
        }else{
            user = userService.getUser(user.getFbId());
        }
        String userString = JsonUtils.objectToJson(user).toString();
        return userString;
    }
}
