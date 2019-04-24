package com.atguigu.security.config;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author linchong
 * @create 2019-04-24 9:58
 */
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
