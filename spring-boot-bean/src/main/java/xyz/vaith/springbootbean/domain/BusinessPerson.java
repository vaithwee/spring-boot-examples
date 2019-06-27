package xyz.vaith.springbootbean.domain;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import xyz.vaith.springbootbean.domain.definition.Animal;
import xyz.vaith.springbootbean.domain.definition.Person;

@Component
@Log4j2
public class BusinessPerson implements Person, BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

    /*
    @Autowired
    @Qualifier("dog")
     */

   /* public BusinessPerson(@Autowired @Qualifier("dog") Animal animal) {
        this.animal = animal;
    }
    private Animal animal = null;

    */
   private Animal animal = null;

    @Override
    public void service() {
        this.animal.use();
    }

    @Override
    @Autowired @Qualifier("dog")
    public void setAnimal(Animal animal) {
        log.info("lazy injected");
        this.animal = animal;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    }

    @Override
    public void setBeanName(String s) {
        log.info("[" + this.getClass().getSimpleName() + "] execute BeanNameAware Interface setBeanName method");
    }

    @Override
    public void destroy() throws Exception {

    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}
