package xyz.vaith.springboottest;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.match.ContentRequestMatchers;
import xyz.vaith.springboottest.bean.Student;
import xyz.vaith.springboottest.service.SchoolService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SchoolServiceTest {
    @Autowired
    private SchoolService schoolService;

    @Test
    public void findOne() throws Exception {
        Student student = schoolService.selectByKey(1);
        Assert.assertThat(student.getName(), CoreMatchers.is("swk"));
    }
}
