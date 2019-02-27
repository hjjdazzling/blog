package com.hjj.blog.login.dao;

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
public class LoginDaoTest {
    @Autowired
    LoginDao loginDao;

    @Test
    public void testLogin() {
        Integer id = loginDao.login(new User("haojunjie", "haojun"));

        System.out.println(id);
    }
}
