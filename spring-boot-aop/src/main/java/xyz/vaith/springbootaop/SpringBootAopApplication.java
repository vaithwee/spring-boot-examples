package xyz.vaith.springbootaop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import xyz.vaith.springbootaop.aspect.MyAop;
import xyz.vaith.springbootaop.aspect.MyMultipleAspect1;
import xyz.vaith.springbootaop.aspect.MyMultipleAspect2;
import xyz.vaith.springbootaop.aspect.MyMultipleAspect3;

@SpringBootApplication
public class SpringBootAopApplication {

    @Bean(name = "myAspect")
    public MyAop initMyAspect() {
        return new MyAop();
    }

    @Bean(name = "multipleAspect1")
    public MyMultipleAspect1 init1(){
        return new MyMultipleAspect1();
    }

    @Bean(name = "multipleAspect2")
    public MyMultipleAspect2 init2(){
        return new MyMultipleAspect2();
    }

    @Bean(name = "multipleAspect3")
    public MyMultipleAspect3 init3(){
        return new MyMultipleAspect3();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAopApplication.class, args);
    }

}
