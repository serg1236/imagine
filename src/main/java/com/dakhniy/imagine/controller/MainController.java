package com.dakhniy.imagine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Sergiy_Dakhniy
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public String hello(){
        return "index";
    }


}
