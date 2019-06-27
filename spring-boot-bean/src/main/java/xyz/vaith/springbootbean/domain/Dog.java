package xyz.vaith.springbootbean.domain;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import xyz.vaith.springbootbean.domain.definition.Animal;

@Log4j2
@Component
public class Dog implements Animal {
    @Override
    public void use() {
       log.info("dog[" +  Dog.class.getSimpleName() + "] is used to watch door");
    }
}
