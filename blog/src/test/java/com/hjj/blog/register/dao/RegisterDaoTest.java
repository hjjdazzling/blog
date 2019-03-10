package com.hjj.blog.register.dao;

import com.hjj.blog.projo.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by haojunjie on 2019/2/25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RegisterDaoTest {
    @Autowired
    RegisterDao registerDao;

    @Test
    public void selectProfessionType1Test() {
        List<ProfessionalType1> list = registerDao.selectProfessionType1();

        System.out.println(list);
    }
    @Test
    public void selectProfessionType2Test() {
        List<ProfessionalType2> list = registerDao.selectProfessionType2(2);

        System.out.println(list);
    }
    @Test
    public void selectProfessionType3Test() {
        List<ProfessionalType3> list = registerDao.selectProfessionType3(1);

        System.out.println(list);
    }
    @Test
    public void registerUserTest() {
        User user = new User("12345", "1234");
        registerDao.registerUser(user);
        System.out.println(user.getId());
    }

    @Test
    public void registerUserInformationTest() {
        UserInformation userInformation = new UserInformation();
        userInformation.setUser_id(3);
        userInformation.setProfessionalType3Id(2);
        userInformation.setRealName("dazzling");
        userInformation.setBirth(new Date());
        userInformation.setPhone("18700860366");
        userInformation.setEmail("2250170537@qq.com");
        userInformation.setDescription("666");

        registerDao.registerUserInformation(userInformation);
    }
}
