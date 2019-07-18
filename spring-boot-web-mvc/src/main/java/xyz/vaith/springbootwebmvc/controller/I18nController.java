package xyz.vaith.springbootwebmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@RequestMapping("/i18n")
@Controller
public class I18nController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/page")
    public String page(HttpServletRequest request) {
        Locale locale = LocaleContextHolder.getLocale();
        String msg = messageSource.getMessage("msg", null, locale);
        return "i18n/internationalization";
    }
}
