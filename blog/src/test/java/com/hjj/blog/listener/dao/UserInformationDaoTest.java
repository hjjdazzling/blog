package com.hjj.blog.listener.dao;

import com.hjj.blog.projo.UserInformation;
import com.hjj.blog.projo.UserInformation2;
import com.hjj.blog.userinformation2.UserInformation2Dao;
import org.apache.ibatis.annotations.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author haojunjie
 * @create 2019-03-18 13:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInformationDaoTest {
    @Autowired
    UserInformationDao userInformationDao;

    @Test
    public void getUserInformation2ByIdTest(){
        System.out.println(userInformationDao.getUserInformation2ById(1));
    }
}
