package xyz.vaith.springbootmybatis.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.vaith.springbootmybatis.bean.User;
import xyz.vaith.springbootmybatis.service.UserService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/insertUser")
    public String insertUser(User user) {
        return "insert data [" + userService.insertUser(user) + "] number";
    }

    @RequestMapping("/insertGenKey")
    public User insertGenKey(User user) {
         userService.insertGenKey(user);
         return user;
    }

    @RequestMapping("/selectByUsername")
    public User selectByUsername(String username) {
        return userService.selectByUsername(username);
    }

    @RequestMapping("/findAll")
    public List<User> findAll() {
        return userService.findAll();
    }

    @RequestMapping("/update")
    public void update(User user) {
        userService.update(user);
    }

    @RequestMapping("/delete")
    public void delete(Integer id) {
        userService.delete(id);
    }
}
