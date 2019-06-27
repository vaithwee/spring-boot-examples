package xyz.vaith.springbootbean.domain;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import xyz.vaith.springbootbean.domain.definition.Animal;

@Component
@Log4j2
@Primary
public class Cat implements Animal {
    @Override
    public void use() {
       log.info("Cat["+Cat.class.getSimpleName()+"]is used to catch the mouse");
    }
}
