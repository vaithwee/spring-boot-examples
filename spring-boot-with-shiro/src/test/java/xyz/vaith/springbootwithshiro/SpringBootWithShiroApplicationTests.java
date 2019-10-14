package xyz.vaith.springbootwithshiro;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.vaith.springbootwithshiro.mapper.UserMapper;
import xyz.vaith.springbootwithshiro.model.User;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log4j2
public class SpringBootWithShiroApplicationTests {

    @Resource
    UserMapper userMapper;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testFindUser() {
        User user= userMapper.findUserByUsername("admin");
        log.info(user.toString());

    }

}
