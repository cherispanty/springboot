package com.atguigu.task.controller;

import com.atguigu.task.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author linchong
 * @create 2019-04-23 11:47
 */
@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        helloService.hello();
        return "success";
    }
}
