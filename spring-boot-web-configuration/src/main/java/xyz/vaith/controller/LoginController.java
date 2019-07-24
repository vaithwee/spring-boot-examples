package xyz.vaith.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @PostMapping("/login")
    public ModelAndView login(@RequestParam("loginName") String username, @RequestParam("password") String password, ModelAndView modelAndView) {
        System.out.println("login controller login method executed");
        System.out.println("username: " + username + ", password: " + password);
        modelAndView.setViewName("redirect:/main");
        return modelAndView;
    }
}
