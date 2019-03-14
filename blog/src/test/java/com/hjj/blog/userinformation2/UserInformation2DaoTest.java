package com.hjj.blog.userinformation2;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hjj.blog.projo.UserInformation2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

/**
 * @author haojunjie
 * @create 2019-03-14 10:53
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInformation2DaoTest {
    @Autowired
    private UserInformation2Dao userInformation2Dao;

    @Test
    public void addTest() {
        UserInformation2 userInformation2 = new UserInformation2();
        userInformation2.setUserId(1);
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        userInformation2.setPraiseAllId(set);
        userInformation2.setNegativeAllId(set);
        userInformation2.setCollectAllId(set);
        userInformation2.setAttentionAllId(set);
        userInformation2Dao.add(userInformation2);
    }

    @Test
    public void getByIdTest() {
        System.out.println(userInformation2Dao.getById(1));
    }
}
