package xyz.vaith.springbootwebmvc.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/interceptor")
@Log4j2
public class InterceptorController {
    @GetMapping("/start")
    public String start() {
       log.info("interceptor controller start method");
       return "/welcome";
    }
}
