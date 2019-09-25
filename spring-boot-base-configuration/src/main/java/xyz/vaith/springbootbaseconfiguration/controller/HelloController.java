package xyz.vaith.springbootbaseconfiguration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.vaith.springbootbaseconfiguration.model.Book;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        return "hello, spring boot.";
    }

    @Autowired
    Book book;
    @RequestMapping("/book")
    public String book() {
        return book.toString();
    }
}
