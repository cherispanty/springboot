package com.atguigu.consumeruser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

/**
 * @author linchong
 * @create 2019-04-24 17:41
 */
@RestController
public class UserController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/buy")
    public String buy(String name) {
        String s = restTemplate.getForObject("http://PROVIDER-TICKET/buyTicket", String.class);
//        restTemplate.get
        return name + ":"+s;
    }
}
