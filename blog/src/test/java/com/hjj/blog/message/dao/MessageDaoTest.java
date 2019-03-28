package com.hjj.blog.message.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author haojunjie
 * @create 2019-03-28 20:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageDaoTest {
    @Autowired
    private MessageDao messageDao;

    @Test
    public void getCriteriaMessagesByUserIdTest() {
        System.out.println(messageDao.getCriteriaMessagesByUserId(1));
    }

    @Test
    public void updateCriteriaMessagesByIdTest() {
        System.out.println(messageDao.updateCriteriaMessagesById(1));
    }
}
