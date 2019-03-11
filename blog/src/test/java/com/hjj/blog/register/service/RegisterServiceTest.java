package com.hjj.blog.register.service;

import com.hjj.blog.login.service.LoginService;
import com.hjj.blog.projo.User;
import com.hjj.blog.projo.UserInformation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Created by haojunjie on 2019/2/25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RegisterServiceTest {
    @Autowired
    LoginService loginService;
    @Autowired
    RegisterService registerService;

    @Test
    public void registerTest() {
        User user = new User();
        user.setUsername("hjjdazzing");
        user.setPassword("123");

        registerService.registerUser(user);


        UserInformation userInformation = new UserInformation();
        userInformation.setUserId(user.getId());
        userInformation.setProfessionalType3Id(1);
        userInformation.setRealName("郝俊杰");
        userInformation.setBirth(new Date());
        userInformation.setPhone("18700860366");
        userInformation.setEmail("1275119618@qq.com");
        userInformation.setAttentionNumber(0);
        userInformation.setFansNumber(0);
        userInformation.setDescription("无");


        registerService.registerUserInformation(userInformation);
    }
}
