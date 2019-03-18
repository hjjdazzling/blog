package com.hjj.blog.listener.service;

import com.hjj.blog.listener.dao.UserInformationDao;
import com.hjj.blog.projo.UserInformation;
import com.hjj.blog.projo.UserInformation2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author haojunjie
 * @create 2019-03-18 14:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInformationServiceTest {
    @Autowired
    private UserInformationService userInformationService;

    @Test
    public void cacheUserInformation2Test() {
        userInformationService.cache(1);
    }

}
