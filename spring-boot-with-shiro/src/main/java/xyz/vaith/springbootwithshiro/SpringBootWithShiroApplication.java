package xyz.vaith.springbootwithshiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
@MapperScan(basePackages =  {"xyz.vaith.springbootwithshiro.mapper"})
public class SpringBootWithShiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWithShiroApplication.class, args);
    }

}
