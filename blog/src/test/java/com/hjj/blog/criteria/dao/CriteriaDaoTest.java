package com.hjj.blog.criteria.dao;

import com.hjj.blog.projo.Criteria;
import com.hjj.blog.projo.CriteriaMessage;
import com.hjj.blog.projo.Message;
import org.apache.ibatis.annotations.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author haojunjie
 * @create 2019-03-27 10:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CriteriaDaoTest {
    @Autowired
    private CriteriaDao criteriaDao;


    @Test
    public void insertCriteriaTest() {
        Criteria criteria = new Criteria();
        criteria.setUserId(4);
        criteria.setArticleId(8);
        criteria.setCriteriaTime(new Date());
        Message message = new Message();
        message.setTime(new Date());
        message.setContent("4评论:hello world");

        Message message2 = new Message();
        message2.setTime(new Date());
        message2.setContent("作者回复:hello world2");
        List<Message> list = new ArrayList<>();

        list.add(message);
        list.add(message2);
        criteria.setCriteriaArticle(list);


        criteriaDao.insertCriteria(criteria);
    }

    @Test
    public void selectCriteriaByArticleIdTest() {
        System.out.println(criteriaDao.selectCriteriaByArticleId(8));
    }

    @Test
    public void selectCriteriaIsExistedTest() {
        Criteria criteria = new Criteria();
        criteria.setUserId(1);
        criteria.setArticleId(8);
        System.out.println(criteriaDao.selectCriteriaIsExisted(criteria));
        criteria.setUserId(4);
        criteria.setArticleId(8);
        System.out.println(criteriaDao.selectCriteriaIsExisted(criteria));
    }

    @Test
    public void updateCriteriaTest() {
        Criteria criteria = new Criteria();
        criteria.setId(1);

        Message message = new Message();
        message.setTime(new Date());
        message.setContent("4评论:hello world");

        Message message2 = new Message();
        message2.setTime(new Date());
        message2.setContent("作者回复:hello world2");

        Message message3 = new Message();
        message3.setTime(new Date());
        message3.setContent("4回复作者:hello world3");
        List<Message> list = new ArrayList<>();

        list.add(message);
        list.add(message2);
        list.add(message3);
        criteria.setCriteriaArticle(list);

        criteriaDao.updateCriteria(criteria);
    }

    @Test
    public void insertCriteriaMessageTest() {
        CriteriaMessage criteriaMessage = new CriteriaMessage();
        criteriaMessage.setUserId(4);
        criteriaMessage.setFromUserId(1);
        criteriaMessage.setRead(false);
        criteriaMessage.setTime(new Date());
        criteriaMessage.setContent("有人回复了你");

        criteriaDao.insertCriteriaMessage(criteriaMessage);
    }

    @Test
    public void updateCriteriaMessageTest() {
        criteriaDao.updateCriteriaMessage(1);
    }

    @Test
    public void getByUserIdTest() {
        System.out.println(criteriaDao.getByUserId(4));
    }

    @Test
    public void selectByIdTest() {
        System.out.println(criteriaDao.selectById(1));
    }

    @Test
    public void getUserNameByIdTest() {
        System.out.println(criteriaDao.getUserNameById(1));
    }

    @Test
    public void isAuthorTest() {
        System.out.println(criteriaDao.isAuthor(2, 8));
        System.out.println(criteriaDao.isAuthor(1, 8));
    }

    @Test
    public void getIdByUserNameTest() {
        System.out.println(criteriaDao.getIdByUserName("haojunjie"));
        System.out.println(criteriaDao.getIdByUserName("1234"));
        System.out.println(criteriaDao.getIdByUserName("hellow olrd"));
    }

    @Test
    public void selectAuthorByArticleIdTest() {
        System.out.println(criteriaDao.selectAuthorByArticleId(9));
    }
}
