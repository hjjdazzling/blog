package com.hjj.blog.login.cache;

import com.hjj.blog.projo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by haojunjie on 2019/2/24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginCacheTest {
    @Autowired
    LoginCache loginCache;

    @Test
    public void loginTest() {
        User user = new User();
        user.setUsername("haojunjie");
        user.setPassword("haojunjie");

        System.out.println(loginCache.login(user));
    }

    @Test
    public void loginCacheUserTest() {
        User user = new User();
        user.setUsername("haojunjie");
        user.setPassword("haojunjie");

        loginCache.loginCacheUser(user);
    }
}
