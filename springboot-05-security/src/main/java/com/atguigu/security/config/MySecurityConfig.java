package com.atguigu.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author linchong
 * @create 2019-04-24 9:42
 */
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //控制请求的授权规则
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");

        //开启自动配置的登录功能
        http.formLogin();

        //注销
        http.logout().logoutSuccessUrl("/");    //注销成功后跳转到首页

        //记住密码
//        http.rememberMe();  //加上这个之后不能登录了，什么问题？


    }


    //定义认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
        //这个是不成功的！
        auth.inMemoryAuthentication().withUser("test").password("test").roles("VIP1","VIP2");
//                .and()
//                .withUser("lisi").password("123456").roles("VIP2","VIP3")
//                .and()
//                .withUser("wangwu").password("123456").roles("VIP3","VIP1");
        /**
         * 注意：Springboot2.0之后，需要手动设置密码的编解码，否则登录会出错
         */
        auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder()).withUser("zhangsan").password("123456").roles("VIP1","VIP2");
        auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder()).withUser("lisi").password("123456").roles("VIP2","VIP3");
        auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder()).withUser("wangwu").password("123456").roles("VIP3","VIP1");
    }
}
