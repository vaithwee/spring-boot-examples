package xyz.vaith.springbootdatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"xyz.vaith.springbootdatabase.dao"})
@EntityScan(basePackages = {"xyz.vaith.springbootdatabase.pojo"})
public class SpringBootDatabaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDatabaseApplication.class, args);
    }

}
