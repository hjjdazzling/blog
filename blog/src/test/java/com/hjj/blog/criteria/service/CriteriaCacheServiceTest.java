package com.hjj.blog.criteria.service;

import com.hjj.blog.projo.Criteria;
import com.hjj.blog.projo.CriteriaMessage;
import com.hjj.blog.projo.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author haojunjie
 * @create 2019-03-27 13:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CriteriaCacheServiceTest {
    @Autowired
    private CriteriaService criteriaService;

    @Test
    public void criteriaTest() {
        Criteria criteria = new Criteria();
        criteria.setArticleId(8);
        criteria.setUserId(2);
        criteria.setCriteriaTime(new Date());
        List<Message> list = new ArrayList<>();
        Message message = new Message();
        message.setTime(new Date());
        message.setContent("你的文章写得真是太好了");
        list.add(message);

        criteria.setCriteriaArticle(list);

        CriteriaMessage criteriaMessage = new CriteriaMessage();
        criteriaMessage.setUserId(1);
        criteriaMessage.setFromUserId(2);
        criteriaMessage.setTime(new Date());
        criteriaMessage.setRead(false);
        criteriaMessage.setContent("dazzling回复了你,<a href = '/查看文章的ip'>点击</a>");

//        criteriaService.criteria(criteria, criteriaMessage,);
    }
}
