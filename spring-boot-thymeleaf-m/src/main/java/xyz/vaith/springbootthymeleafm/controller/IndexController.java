package xyz.vaith.springbootthymeleafm.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
public class IndexController {
    @RequestMapping("/")
    public String index() {
        log.info("index controller index method executed");
        return "index";
    }
}
