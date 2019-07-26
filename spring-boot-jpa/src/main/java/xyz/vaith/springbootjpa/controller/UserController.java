package xyz.vaith.springbootjpa.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.vaith.springbootjpa.bean.User;
import xyz.vaith.springbootjpa.service.UserService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/save")
    public String save() {
        User user = new User();
        user.setLoginName("wee");
        user.setUsername("wh");
        user.setSex('男');
        user.setAge(3);
        userService.save(user);
        return "save success";
    }

    @RequestMapping("/update")
    public String update() {
        User user = userService.getById(1);
        userService.update(user);
        return "update success";
    }

    @RequestMapping("/delete")
    public String delete() {
        userService.delete(1);;
        return "delete success";
    }

    @RequestMapping("/getAll")
    public Iterable<User> getAll() {
        return userService.getAll();
    }
}
