package xyz.vaith.springbootdatabase.db;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
@Log4j2
public class DataSourceShow implements ApplicationContextAware {
    ApplicationContext applicationContext = null;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        log.info("-------------------------------------");
        log.info(dataSource.getClass().getName());
        log.info("-------------------------------------");
    }
}
