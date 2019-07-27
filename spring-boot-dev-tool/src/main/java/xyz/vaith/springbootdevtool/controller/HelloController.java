package xyz.vaith.springbootdevtool.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
       log.info("test spring-boot-devtools");
       return "hello, dev tools fix refresh delay 1 s";
    }
}
