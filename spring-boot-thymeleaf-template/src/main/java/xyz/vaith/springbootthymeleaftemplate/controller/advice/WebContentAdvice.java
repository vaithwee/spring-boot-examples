package xyz.vaith.springbootthymeleaftemplate.controller.advice;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractMappingJacksonResponseBodyAdvice;
import xyz.vaith.springbootthymeleaftemplate.annonation.WebContent;

@ControllerAdvice
public class WebContentAdvice extends AbstractMappingJacksonResponseBodyAdvice {
    @Override
    protected void beforeBodyWriteInternal(MappingJacksonValue mappingJacksonValue, MediaType mediaType, MethodParameter methodParameter, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (methodParameter.getMethod().getClass().isAnnotationPresent(WebContent.class)) {
            WebContent content = methodParameter.getMethod().getClass().getAnnotation(WebContent.class);
            mappingJacksonValue.setValue(content.title());
        }
    }
}
