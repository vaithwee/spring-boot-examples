package xyz.vaith.springbootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @PostMapping("/login")
    public ModelAndView login(@RequestParam("loginName") String loginName, @RequestParam("password") String password, ModelAndView mv) {
        System.out.println("LoginController login 方法被调用了......");
        System.out.println("LoginController 登录名: " + loginName + " 密码: " + password);
        mv.setViewName("redirect:/main");
        return mv;
    }
}
