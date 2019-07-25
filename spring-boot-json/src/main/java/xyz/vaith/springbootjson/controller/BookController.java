package xyz.vaith.springbootjson.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.vaith.springbootjson.domain.Book;

import java.util.ArrayList;
import java.util.List;

@RestController
@Log4j2
public class BookController {
    @RequestMapping("/findBook")
    public Book findBook(@RequestBody Book book) {
        book.setAuthor("wee");
        book.setImage("image");
        book.setPrice(19.9);
        book.setRemark("this is remark");
        book.setName("spring boot");
        book.setId(199);
        log.info(book.toString());
        return book;
    }

    @RequestMapping("/findBooks")
    public List<Book> findBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "name1", "author1", "image1", 19.9, "remark1"));
        books.add(new Book(2, "name2", "author2", "image2", 29.9, "remark2"));
        books.add(new Book(3, "name3", "author3", "image3", 39.9, "remark3"));
        return books;
    }
}
