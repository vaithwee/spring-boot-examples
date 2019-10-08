package xyz.vaith.springbootwithsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true) //use this @ProAuthorize work
public class SpringBootWithSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWithSecurityApplication.class, args);
    }

}
