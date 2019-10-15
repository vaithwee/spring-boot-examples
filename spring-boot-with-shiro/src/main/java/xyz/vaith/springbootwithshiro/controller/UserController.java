package xyz.vaith.springbootwithshiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.vaith.springbootwithshiro.model.User;
import xyz.vaith.springbootwithshiro.service.UserService;

import javax.servlet.http.HttpSession;


@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String loginPage() {
        return "login";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }

    @RequestMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            subject.logout();
        }
        return "login";
    }

    @RequestMapping("/unauthorized")
    public String unauthorized() {
        return "unauthorized";
    }

    @RequestMapping("/edit")
    public String edit() {
        return "edit";
    }

    @RequestMapping("/delete")
    @RequiresPermissions("delete")
    public String delete() {
        return "delete";
    }

    @RequestMapping("/loginUser")
    public String loginUser(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            User user = (User)subject.getPrincipal();
            session.setAttribute("user", user);
            return "index";
        } catch (Exception e) {
            return "login";
        }
    }
}
