package com.hjj.blog.search.dao;

import com.hjj.blog.projo.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
        Article article = new Article();
        article.setTitle("测试");
        System.out.println(searchDao.selectArticle(article));
    }
}
