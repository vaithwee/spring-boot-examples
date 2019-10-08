package xyz.vaith.springbootwithsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/")
    public String index() {
        return "spring boot";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello spring boot";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping("/roleAuth")
    public String roleAuth() {
        return "admin auth";
    }
}
