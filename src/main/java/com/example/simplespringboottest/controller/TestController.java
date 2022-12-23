package com.example.simplespringboottest.controller;

import com.example.simplespringboottest.entity.User;
import com.example.simplespringboottest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @Autowired
    private UserService userService;

    @PostMapping("/test")
    @ResponseBody
    public Boolean test(@RequestBody User user) {
        User user1 = new User();
        user1.setId(2L);
        user1.setName("Tom");
        user1.setPassword("123456");
        Boolean flag = userService.save(user1);
        return flag;
    }
}
