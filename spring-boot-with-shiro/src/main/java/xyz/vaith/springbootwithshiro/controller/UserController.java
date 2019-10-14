package xyz.vaith.springbootwithshiro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.vaith.springbootwithshiro.model.User;
import xyz.vaith.springbootwithshiro.service.UserService;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/test")
    public User findUser() {
        return  userService.findUserByUsername("admin");
    }
}
