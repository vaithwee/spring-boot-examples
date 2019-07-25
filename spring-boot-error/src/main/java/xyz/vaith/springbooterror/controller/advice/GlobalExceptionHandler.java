package xyz.vaith.springbooterror.controller.advice;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Log4j2
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)

    @ResponseBody
    public Object globalErrorHandler(HttpServletRequest request, Exception e) throws Exception {
       log.info("global error handler");
        Map<String, Object> map = new HashMap<>();
        map.put("code", 100);
        map.put("message", e.getLocalizedMessage());
        map.put("url", request.getRequestURI());
        map.put("data", "request failure");
        return map;
    }
}
