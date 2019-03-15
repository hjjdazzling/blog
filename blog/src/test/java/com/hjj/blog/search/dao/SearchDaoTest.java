package com.hjj.blog.search.dao;

import com.hjj.blog.projo.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haojunjie
 * @create 2019-03-14 15:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchDaoTest {
    @Autowired
    SearchDao searchDao;

    @Test
    public void selectArticleTest() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        List<Integer> list2 = new ArrayList<>();
        list2.add(10);
        list2.add(12);

        List<Article> articles = searchDao.selectArticle("测试", list, list2);

        for(Article article : articles) {
            System.out.println(article);
        }

        articles = searchDao.selectArticle("测试", null, list2);

        for(Article article : articles) {
            System.out.println(article);
        }

        articles = searchDao.selectArticle("测试", list, null);

        for(Article article : articles) {
            System.out.println(article);
        }

        articles = searchDao.selectArticle(null, list, list2);

        for(Article article : articles) {
            System.out.println(article);
        }

        articles = searchDao.selectArticle(null, null, list2);

        for(Article article : articles) {
            System.out.println(article);
        }

        articles = searchDao.selectArticle(null, list, null);

        for(Article article : articles) {
            System.out.println(article);
        }


        articles = searchDao.selectArticle("测试", null, null);

        for(Article article : articles) {
            System.out.println(article);
        }
    }

    @Test
    public void selectUserNameTest() {
        System.out.println(searchDao.selectUserName("12"));
    }

    @Test
    public void selectArticleTypeTest() {
        System.out.println(searchDao.selectArticleType("e"));
    }
}
