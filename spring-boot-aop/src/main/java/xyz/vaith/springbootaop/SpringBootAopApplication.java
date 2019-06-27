package xyz.vaith.springbootaop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import xyz.vaith.springbootaop.aspect.MyAop;

@SpringBootApplication
public class SpringBootAopApplication {

    @Bean(name = "myAspect")
    public MyAop initMyAspect() {
        return new MyAop();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAopApplication.class, args);
    }

}
