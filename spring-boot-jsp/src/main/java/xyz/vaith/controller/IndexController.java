package xyz.vaith.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.vaith.domain.Book;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("username", "spring boot");
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "title1", "author1", "image1", 19.9));
        books.add(new Book(2, "title2", "author2", "image2", 29.9));
        books.add(new Book(3, "title3", "author3", "image3", 39.9));
        model.addAttribute("books", books);
        return "index";
    }
}
