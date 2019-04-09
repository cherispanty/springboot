package com.atguigu.starter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author linchong
 * @create 2019-04-09 15:35
 */
@Configuration
@ConditionalOnWebApplication    //web应用才有效
public class HelloServiceAutoConfiguration {
    @Bean
    public HelloService helloService() {
        return new HelloService();
    }
}
