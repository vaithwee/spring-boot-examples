package xyz.vaith.springbootjson.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.vaith.springbootjson.domain.Book;

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
}
