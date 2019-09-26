package xyz.vaith.springbootviewengine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import xyz.vaith.springbootviewengine.model.Book;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    @GetMapping("/books")
    public ModelAndView books() {
        List<Book> books = new ArrayList<>();
        books.add(Book.builder().name("三国演义").author("罗贯中").id(1).build());
        books.add(Book.builder().name("红楼梦").author("曹雪芹").id(2).build());

        ModelAndView mv = new ModelAndView();
        mv.addObject("books", books);
        mv.setViewName("books");
        return mv;
    }
}
