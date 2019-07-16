package xyz.vaith.springbootwebmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.vaith.springbootwebmvc.pojo.User;

@RequestMapping("/user")
@Controller
public class UserController {

    @GetMapping("/add")
    public String add() {
        return "user/add";
    }

    @PostMapping("/insert")
    @ResponseBody
    public User insert(@RequestBody User user) {
        return user;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public User get(@PathVariable("id") Long id) {
        User user = new User();
        user.setId(id);
        return user;
    }
}
