package xyz.vaith.springbootaop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.vaith.springbootaop.intercept.MyInterceptor;
import xyz.vaith.springbootaop.proxy.ProxyBean;
import xyz.vaith.springbootaop.service.HelloService;
import xyz.vaith.springbootaop.service.UserService;
import xyz.vaith.springbootaop.service.impl.HelloServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootAopApplicationTests {

    @Test
    public void contextLoads() {
    }


    @Test
    public void test1() {
        HelloService helloService = new HelloServiceImpl();
        HelloService proxy = (HelloService) ProxyBean.getProxyBean(helloService, new MyInterceptor());
        proxy.sayHello("wee");
        proxy.sayHello(null);

    }

    @Test
    public void testUserService() {
        UserService userService = new UserService();
        userService.insertUser();
    }
}
