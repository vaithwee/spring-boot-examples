package xyz.vaith.springbootbean;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.vaith.springbootbean.config.AppConfig;
import xyz.vaith.springbootbean.domain.BusinessPerson;
import xyz.vaith.springbootbean.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log4j2
public class SpringBootBeanApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void test1() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        User user = ctx.getBean(User.class);
        log.info(user);

    }

    @Test
    public void test2() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        BusinessPerson businessPerson = ctx.getBean(BusinessPerson.class);
        businessPerson.service();
    }
}
