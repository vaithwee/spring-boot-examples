package xyz.vaith.springbooterror.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
public class UserController extends BaseController {
    @RequestMapping("/login")
    public String login(String username) throws Exception {
        log.info("login");
        if (username == null) {
            throw new NullPointerException("username is not exist");

        }
        return "success";
    }
}
