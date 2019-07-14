package xyz.vaith.springbootredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringBootRedisApplication {

    @Autowired
    private RedisTemplate redisTemplate;

    @PostConstruct
    public void init() {
        initRedisTemplate();
    }

    private void initRedisTemplate() {
        RedisSerializer serializer = redisTemplate.getStringSerializer();
        redisTemplate.setKeySerializer(serializer);
        redisTemplate.setHashKeySerializer(serializer);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRedisApplication.class, args);
    }



}
