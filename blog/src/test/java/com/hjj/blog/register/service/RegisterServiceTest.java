package com.hjj.blog.register.service;

import com.hjj.blog.projo.User;
import com.hjj.blog.projo.UserInformation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by haojunjie on 2019/2/25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RegisterServiceTest {
    @Autowired
    RegisterService registerService;

    @Test
    public void registerTest() {
        User user = new User();

        UserInformation userInformation = new UserInformation();

        registerService.register(user, userInformation);
    }
}
