package xyz.vaith.springbootredis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.vaith.springbootredis.config.RedisConfig;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRedisApplicationTests {

    @Test
    public void contextLoads() {
        ApplicationContext context = new AnnotationConfigApplicationContext(RedisConfig.class);
        RedisTemplate redisTemplate = context.getBean(RedisTemplate.class);
        redisTemplate.opsForValue().set("key1", "hello world");
        redisTemplate.opsForHash().put("hash", "field", "hvalue");
    }

}
