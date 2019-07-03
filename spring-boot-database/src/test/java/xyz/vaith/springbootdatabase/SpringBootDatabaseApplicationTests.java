package xyz.vaith.springbootdatabase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.vaith.springbootdatabase.enumeration.Sex;
import xyz.vaith.springbootdatabase.pojo.User;
import xyz.vaith.springbootdatabase.service.JdbpTmplUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDatabaseApplicationTests {

    @Autowired
    private JdbpTmplUserService jdbpTmplUserService;

    @Test
    public void contextLoads() {
        User user = new User();
        user.setUsername("wee");
        user.setNote("hello java");
        user.setSex(Sex.MALE);
        jdbpTmplUserService.insert(user);
    }

}
