package com.liutao.redis;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @ClassName RedisHelper
 * @Descrption TODO
 * @Author lt
 * @Date 2019/2/24 15:49
 * @Version 1.0
 **/

@Component
public class RedisHelper {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public <T> void saveCache(String key, T t) {
//        String json = JSONObject.toJSONString(t);
        stringRedisTemplate.opsForValue().set(key, (String) t);
    }

}