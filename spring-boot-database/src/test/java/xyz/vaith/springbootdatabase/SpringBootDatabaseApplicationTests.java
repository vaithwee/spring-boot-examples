package xyz.vaith.springbootdatabase;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.vaith.springbootdatabase.enumeration.Sex;
import xyz.vaith.springbootdatabase.pojo.User;
import xyz.vaith.springbootdatabase.service.JdbpTmplUserService;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log4j2
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

    @Test
    public void testQuery() {
        List<User> users = jdbpTmplUserService.findUsers("wee", "h");
        for (User user : users) {
            log.info(user.toString());
        }
    }

}
