package xyz.vaith.springbootproperties;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.vaith.springbootproperties.config.AppConfig;
import xyz.vaith.springbootproperties.domain.DataBaseProperties;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log4j2
public class SpringBootPropertiesApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void loadProperties() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        DataBaseProperties properties = ctx.getBean(DataBaseProperties.class);
        log.info(properties.toString());
    }

}
