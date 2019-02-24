package com.liutao.controller;

import com.liutao.common.CacheValue;
import com.liutao.entity.User;
import com.liutao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName UserController
 * @Descrption TODO
 * @Author lt
 * @Date 2019/2/23 21:50
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "/user", method = { RequestMethod.GET, RequestMethod.POST })
public class UserController {

    @Autowired
    private UserService userservice;

    @RequestMapping("/list")
    @ResponseBody
    public List<User> listUser(){
        return userservice.listUser();
    }

    @RequestMapping("/listByname")
    @ResponseBody
    public List<User> listUserByname(String name){
        return userservice.findByName(name);
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(int id) {
        int result = userservice.delete(id);
        if (result >= 1) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update() {
        CacheValue.VALUE.setValue("20");
        User user = new User();
        int result = userservice.update(user);
        if (result >= 1) {
            return "修改成功";
        } else {
            return "修改失败";
        }

    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public User insert(User user) {
        return userservice.insertUser(user);
    }


}