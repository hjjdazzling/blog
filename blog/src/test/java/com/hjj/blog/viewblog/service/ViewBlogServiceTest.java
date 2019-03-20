package com.hjj.blog.viewblog.service;

import com.github.pagehelper.PageInfo;
import com.hjj.blog.projo.Article;
import com.hjj.blog.projo.ArticleType;
import com.hjj.blog.projo.UserInformation2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;

/**
 * @author haojunjie
 * @create 2019-03-13 10:21
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ViewBlogServiceTest {
    @Autowired
    ViewBlogService viewBlogService;

    @Test
    public void getArticleTest() {
        List<Article> list =  viewBlogService.getArticle(1, 1 , 2);
        System.out.println(list);
        System.out.println("----------------------");
        for (int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    @Test
    public void updateUserInformation2Cache() {
        UserInformation2 userInformation2 = new UserInformation2();
        userInformation2.setId(2);
        userInformation2.setUserId(4);
        userInformation2.setPraiseAllId(new HashSet<>(8));
        userInformation2.setNegativeAllId(new HashSet<>(8));
        userInformation2.setAttentionAllId(new HashSet<>(8));
        userInformation2.setCollectAllId(new HashSet<>(8));

        viewBlogService.updateUserInformation2Cache(userInformation2);
    }
}
