package xyz.vaith.springbootthymeleaftemplate.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import xyz.vaith.springbootthymeleaftemplate.WebContentHandler;

import java.util.List;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
        WebContentHandler webContentHandler = new WebContentHandler();
        returnValueHandlers.add(webContentHandler);
        super.addReturnValueHandlers(returnValueHandlers);
    }
}
