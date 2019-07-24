package xyz.vaith.springbootthymeleafm.controller;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
}
