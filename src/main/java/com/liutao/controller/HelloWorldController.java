package com.liutao.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloWorldController
 * @Descrption TODO
 * @Author lt
 * @Date 2019/2/23 20:51
 * @Version 1.0
 **/

@RestController
@EnableAutoConfiguration
public class HelloWorldController {

    @GetMapping("/helloWorld")
    private String index() {
        return "Hello World";
    }
}
