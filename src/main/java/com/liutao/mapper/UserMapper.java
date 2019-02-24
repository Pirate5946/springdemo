package com.liutao.mapper;

import com.liutao.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName UserMapper
 * @Descrption TODO
 * @Author lt
 * @Date 2019/2/23 21:45
 * @Version 1.0
 **/


@Mapper
public interface UserMapper {

    List<User> findUserByName(String name);

    public List<User> listUser();

    public int insertUser(User user);

    public int delete(int id);

    public int update(User user);

}