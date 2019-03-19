package com.hjj.blog.listener.service;

import com.hjj.blog.listener.cache.UserInformationCache;
import com.hjj.blog.listener.dao.UserInformationDao;
import com.hjj.blog.projo.UserInformation2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * @author haojunjie
 * @create 2019-03-18 14:15
 */
@Transactional
@Service
public class UserInformationService {
    @Autowired
    private UserInformationDao userInformationDao;
    @Autowired
    private UserInformationCache userInformationCache;


    public void cache(Integer userId) {
        UserInformation2 userInformation2 = userInformationDao.getUserInformation2ById(userId);

        if (userInformation2 == null) {
            userInformation2 = new UserInformation2();
            userInformation2.setUserId(userId);
            userInformation2.setPraiseAllId(new HashSet<Integer>());
            userInformation2.setCollectAllId(new HashSet<Integer>());
            userInformation2.setAttentionAllId(new HashSet<Integer>());
            userInformation2.setNegativeAllId(new HashSet<Integer>());
            userInformationDao.addUserInformation2(userInformation2);
        }


        System.out.println("cache" + userInformation2);

        if (userInformation2 != null) {
            System.out.println("进入cache");
            userInformationCache.cacheUserInformation2(userInformation2);
        }
    }

    public void deleteCache(Integer userId) {
        UserInformation2 userInformation2 = userInformationCache.getUserInformation2(userId);

        userInformationDao.updateUserInformation2(userInformation2);

        userInformationCache.deleteUserInformationCacheById(userId);

    }
}
