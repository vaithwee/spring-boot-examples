package xyz.vaith.springbooterror.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.rmi.runtime.Log;

@Log4j2
@Controller
public class TestController extends BaseController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/hello")
    public String hello() throws Exception {
        throw new Exception();
    }

    @RequestMapping("/test")
    public String test() throws Exception {
        int i = 5 / 0;
        return "success";
    }

    /*
    @ExceptionHandler(value = Exception.class)
    public String testErrorHandler(Exception e, Model model) {
        log.info("catch exception :" + e.getLocalizedMessage());
       model.addAttribute("message", e.getLocalizedMessage());
        return "error";
    }

     */
}
