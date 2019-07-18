package xyz.vaith.springbootwebmvc.controller.advice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice(basePackages = {"xyz.vaith.springbootwebmvc.controller.*"}, annotations = Controller.class)
public class MyControllerAdvice {
    @InitBinder
    public void initDataBinder(WebDataBinder binder) {

    }

    @ModelAttribute
    public void projectModel(Model model) {
        model.addAttribute("project_name", "spring boot");
    }

    @ExceptionHandler(value = Exception.class)
    public String exception(Model model, Exception e) {
        model.addAttribute("message", e.getLocalizedMessage());
        return "exception";
    }
}
