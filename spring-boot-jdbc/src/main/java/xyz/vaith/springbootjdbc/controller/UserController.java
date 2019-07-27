package xyz.vaith.springbootjdbc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.vaith.springbootjdbc.bean.User;
import xyz.vaith.springbootjdbc.service.UserService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/insertUser")
    public String insertUser() {
        userService.insertUser();
        return "insert success";
    }

    @RequestMapping("/insertGenKey")
    public User insertGenKey(User user) {
        return userService.insertGenKey(user);
    }

    @RequestMapping("/selectByUserName")
    public User selectUserByUserName(@RequestParam("username") String username) {
        return userService.selectByUsername(username);
    }

    @RequestMapping("/findAll")
    public List<User>findAll() {
        return userService.findAll();
    }

    @RequestMapping("/update")
    public void update(User user) {
        userService.updateUser(user);
    }

    @RequestMapping("/delete")
    public void delete(Integer id) {
        userService.deleteUser(id);
    }
}
