package com.hjj.blog.recommend.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author haojunjie
 * @create 2019-03-25 13:16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RecommandSerivceTest {
    @Autowired
    RecommandService recommandService;

    @Test
    public void getRecommandArticleTest() {
        System.out.println(recommandService.getRecommandArticleByProfessionalType(1, 1 ,5));
    }
    @Test
    public void getRecommandArticleByAttentionAllIdTest() {
        System.out.println(recommandService.getRecommandArticleByAttentionAllId(1, 1, 2));
    }
}
