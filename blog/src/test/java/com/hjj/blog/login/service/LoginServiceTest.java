package com.hjj.blog.login.service;

import com.hjj.blog.login.dao.LoginDao;
import com.hjj.blog.projo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by haojunjie on 2019/2/23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginServiceTest {
    @Autowired
    LoginService loginService;

    @Test
    public void testLogin() throws InterruptedException {
        Integer id = loginService.login(new User("haojunjie", "haojunjie"));

        System.out.println(id);

        id = loginService.login(new User("haojunjie", "123"));

        System.out.println(id);

        id = loginService.login(new User("haojunjie", "haojunjie"));

        System.out.println(id);
    }
}
