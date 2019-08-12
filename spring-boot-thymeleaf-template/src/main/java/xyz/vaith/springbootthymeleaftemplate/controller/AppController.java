package xyz.vaith.springbootthymeleaftemplate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import xyz.vaith.springbootthymeleaftemplate.annonation.WebContent;

@Controller
@WebContent(title = "Hello world")
public class AppController {
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "title 1");
        return "index";
    }
}
