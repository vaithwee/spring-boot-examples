package xyz.vaith.springbootbaseconfiguration;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringBootBaseConfigurationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBaseConfigurationApplication.class, args);

        //start application without banner
        /*
        SpringApplicationBuilder builder = new SpringApplicationBuilder(SpringBootBaseConfigurationApplication.class);
        builder.bannerMode(Banner.Mode.OFF).run(args);

         */
    }

}
