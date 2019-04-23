package com.atguigu.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot04TaskApplicationTests {
    @Autowired
    private JavaMailSenderImpl javaMailSender;

    @Test
    public void contextLoads() {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("714987173@qq.com");
        message.setSubject("通知-我爱你");
        message.setText("你知道？I Love You");
        message.setTo("714987173@qq.com");
        javaMailSender.send(message);
    }

    @Test
    public void test1() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        helper.setFrom("714987173@qq.com");
        helper.setText("<b style='color : red'>今晚开会！</b>",true);
        helper.setTo("13268676851@163.com");
        helper.setSubject("通知");

        helper.addAttachment("1.jpg",new File("C:\\Users\\Administrator\\Pictures\\11600299.jpg"));
//        helper.addAttachment("2.jpg",new File("C:\\Users\\Administrator\\Pictures\\timg.jpg"));

        javaMailSender.send(mimeMessage);
    }

}
