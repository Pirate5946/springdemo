package com.liutao.service;

import com.liutao.common.CacheValue;
import com.liutao.entity.User;
import com.liutao.mapper.UserMapper;
import com.liutao.redis.CanUpdate;
import com.liutao.redis.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Descrption TODO
 * @Author lt
 * @Date 2019/2/23 21:47
 * @Version 1.0
 **/
@Service
public class UserService {
    @Autowired
    public UserMapper userMapper;

    public List<User> findByName(String name) {
        return userMapper.findUserByName(name);
    }

    public User insertUser(User user) {
        userMapper.insertUser(user);
        return user;
    }

    @RedisCache
    public List<User> listUser() {
        return userMapper.listUser();
    }

    @CanUpdate(value = CacheValue.VALUE)
    public int update(User user) {
        return userMapper.update(user);
    }

    public int delete(int id) {
        return userMapper.delete(id);
    }
}