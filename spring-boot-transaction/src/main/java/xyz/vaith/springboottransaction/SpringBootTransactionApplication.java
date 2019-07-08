package xyz.vaith.springboottransaction;

import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.PostConstruct;

@MapperScan(basePackages = "xyz.vaith.springboottransaction", annotationClass = Repository.class)
@SpringBootApplication(scanBasePackages = "xyz.vaith.springboottransaction")
@Log4j2
public class SpringBootTransactionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTransactionApplication.class, args);
    }

    @Autowired
    PlatformTransactionManager transactionManager = null;

     @PostConstruct
    public void viewTransactionManager() {
       log.info(transactionManager.getClass().getName());
     }
}
