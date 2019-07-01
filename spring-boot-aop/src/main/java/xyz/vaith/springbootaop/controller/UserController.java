package xyz.vaith.springbootaop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.vaith.springbootaop.domain.User;
import xyz.vaith.springbootaop.service.IUserService;
import xyz.vaith.springbootaop.validator.UserValidator;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;
    @RequestMapping("/print")
    @ResponseBody
    public User printUser(Long id, String username, String note) {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setNote(note);
        userService.printUser(user);
        return user;
    }

    @RequestMapping("/vp")
    @ResponseBody
    public User validateAndPrint(Long id, String username, String note) {
        User user = new User();
        user.setId(id);
        user.setNote(note);
        user.setUsername(username);

        UserValidator userValidator = (UserValidator)userService;

        if (userValidator.validate(user)) {
            userService.printUser(user);
        }
        return user;
    }

    @RequestMapping("/multipleAspects")
    @ResponseBody
    public String multipleAspects() {
        userService.multipleAspects();
        return "multipleAspects";
    }
}
