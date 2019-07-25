package xyz.vaith.springbooterror.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Log4j2
public class BaseController {

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e) {
       log.info("base controller default error handler");
       ModelAndView mv = new ModelAndView();
       mv.addObject("message", e);
       mv.addObject("url", request.getRequestURI());
       mv.setViewName("error");
       return mv;
    }
}
