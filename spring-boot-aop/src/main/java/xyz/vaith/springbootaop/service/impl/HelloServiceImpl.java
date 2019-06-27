package xyz.vaith.springbootaop.service.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import xyz.vaith.springbootaop.service.HelloService;

@Log4j2
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
       if (name == null || name.trim() == "") {
           throw new RuntimeException("parameter is null!");
       }
       log.info("hello " + name);
    }
}
