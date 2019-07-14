package xyz.vaith.springbootredis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/stringAndHash")
    @ResponseBody
    public Map<String, Object> testStringAndHash() {
        redisTemplate.opsForValue().set("key1", "value1");
        redisTemplate.opsForValue().set("int_key", "1");
        stringRedisTemplate.opsForValue().set("int", "1");
        //use calculate
        stringRedisTemplate.opsForValue().increment("int", 1);

        Jedis jedis = (Jedis) stringRedisTemplate.getConnectionFactory().getConnection().getNativeConnection();
        //reduce
        jedis.decr("int");
        Map<String, String> hash = new HashMap<>();
        hash.put("field1", "value1");
        hash.put("field2", "value2");
        stringRedisTemplate.opsForHash().putAll("hash", hash);
        stringRedisTemplate.opsForHash().put("hash", "field3", "value3");
        BoundHashOperations hashOperations = stringRedisTemplate.boundHashOps("hash");
        hashOperations.delete("field1", "filed2");
        hashOperations.put("field4", "value4");
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map;

    }

    @RequestMapping("/list")
    @ResponseBody
    public Map<String, Object> testList() {
        stringRedisTemplate.delete("list1");
        stringRedisTemplate.delete("list2");
        stringRedisTemplate.opsForList().leftPushAll("list1", "v2", "v4", "v6", "v8", "v10");
        stringRedisTemplate.opsForList().rightPushAll("list2", "v1", "v2", "v3", "v4", "v5", "v6");
        BoundListOperations list = stringRedisTemplate.boundListOps("list2");
        Object result1 = list.rightPop();
        Object reuslt2 = list.index(1);
        list.leftPush("v0");
        Long size = list.size();
        List elements = (List) list.range(0, size-2);
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
//        map.put("list", list);
        return map;

    }

    @RequestMapping("/set")
    @ResponseBody
    public Map<String, Object> testSet() {
        stringRedisTemplate.delete("set1");
        stringRedisTemplate.delete("set2");
        stringRedisTemplate.opsForSet().add("set1", "v1", "v1", "v2", "v3", "v4", "v5");
        stringRedisTemplate.opsForSet().add("set2", "v2", "v4", "v6", "v8");
        BoundSetOperations setOperations = stringRedisTemplate.boundSetOps("set1");

        setOperations.add("v6", "v7");
        setOperations.remove("v1", "v7");
        Set set = setOperations.members();
        Long size = setOperations.size();
        Set diff = setOperations.diff("set2");
        setOperations.diffAndStore("set2", "diff");
        Set union = setOperations.union("set2");
        setOperations.unionAndStore("set2", "union");
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map;
    }
}
