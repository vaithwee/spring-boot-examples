package xyz.vaith.springbootmybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("xyz.vaith.springbootmybatis.repository")
public class SpringBootMyBatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMyBatisApplication.class, args);
    }

}
