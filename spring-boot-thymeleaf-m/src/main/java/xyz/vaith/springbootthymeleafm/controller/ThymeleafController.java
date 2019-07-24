package xyz.vaith.springbootthymeleafm.controller;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import xyz.vaith.springbootthymeleafm.domain.Book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymeleafController {

    @RequestMapping("/regexptest")
    public String regexptest(HttpServletRequest request, HttpSession session) {
        request.setAttribute("book", "Moon");
        session.setAttribute("school", "Thu Uni");
        request.getServletContext().setAttribute("name", "thymeleaf");
        return "success1";
    }

    @RequestMapping("/iftest")
    public String iftest(WebRequest webRequest) {
        webRequest.setAttribute("username", "wee", webRequest.SCOPE_REQUEST);
        webRequest.setAttribute("age", 21, webRequest.SCOPE_REQUEST);
        webRequest.setAttribute("role", "admin", webRequest.SCOPE_REQUEST);
        return "success2";
    }

    @RequestMapping("/eachtest")
    public String eachtest(WebRequest webRequest) {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "title1","image1", "author1", 199.1));
        books.add(new Book(2, "title2","image1", "author1", 199.1));
        books.add(new Book(3, "title3","image1", "author1", 199.1));
        books.add(new Book(4, "title4","image1", "author1", 199.1));
        books.add(new Book(5, "title5","image1", "author1", 199.1));
        webRequest.setAttribute("books", books, webRequest.SCOPE_REQUEST);
        return "success3";

    }
}
