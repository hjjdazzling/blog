package com.hjj.blog.modify.personal.dao;

import com.hjj.blog.projo.User;
import com.hjj.blog.projo.UserInformation;
import org.apache.ibatis.annotations.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author haojunjie
 * @create 2019-03-11 13:24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonalInformationDaoTest {
    @Autowired
    PersonalInformationDao personalInformationDao;

    @Test
    public void selectUserInformationTest() {
        UserInformation userInformation = personalInformationDao.selectUserInformation(1);
        System.out.println(userInformation);
    }
    @Test
    public void updateUser() {
        User user = new User();
        user.setId(1);
        user.setUsername("haojunjie");
        user.setPassword("123");
        System.out.println(personalInformationDao.updateUser(user));
    }

    @Test
    public void updateUserInformationTest() {
        UserInformation userInformation = new UserInformation();
        userInformation.setUserId(1);
        userInformation.setProfessionalType3Id(4);
        userInformation.setRealName("dazzling");
        userInformation.setBirth(new Date());
        userInformation.setPhone("1275119618");
        userInformation.setEmail("2250170537@qq.com");
        userInformation.setDescription("未来的最强王者");

        System.out.println(personalInformationDao.updateUserInformation(userInformation));
    }
}
