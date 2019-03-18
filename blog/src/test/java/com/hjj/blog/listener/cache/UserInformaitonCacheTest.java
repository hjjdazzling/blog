package com.hjj.blog.listener.cache;

import com.hjj.blog.listener.dao.UserInformationDao;
import com.hjj.blog.projo.UserInformation;
import com.hjj.blog.projo.UserInformation2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author haojunjie
 * @create 2019-03-18 14:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInformaitonCacheTest {
    @Autowired
    UserInformationCache userInformationCache;

    @Autowired
    UserInformationDao userInformationDao;

    @Test
    public void cacheUserInformation2() {
        UserInformation2 userInformation2 = userInformationDao.getUserInformation2ById(1);

        userInformationCache.cacheUserInformation2(userInformation2);

    }

    @Test
    public void getUserInformation2Test() {
        UserInformation2 userInformation2 = userInformationCache.getUserInformation2(1);

        System.out.println(userInformation2);
    }
}
