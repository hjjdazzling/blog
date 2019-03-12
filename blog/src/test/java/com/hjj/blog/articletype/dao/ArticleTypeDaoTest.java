package com.hjj.blog.articletype.dao;

import com.hjj.blog.projo.ArticleType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author haojunjie
 * @create 2019-03-12 10:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleTypeDaoTest {
    @Autowired
    ArticleTypeDao articleTypeDao;

    @Test
    public void addArticleTypeTest() {
        ArticleType articleType = new ArticleType();
        articleType.setUserId(1);
        articleType.setTypeName("python");
        articleTypeDao.addArticleType(articleType);
    }

    @Test
    public void deleteArticleTypeTest() {
        ArticleType articleType = new ArticleType();
        articleType.setUserId(1);
        articleType.setTypeName("python");
        articleTypeDao.deleteArticleType(1);
    }


    @Test
    public void updateArticleType() {
        ArticleType articleType = new ArticleType();
        articleType.setId(2);
        articleType.setTypeName("python");
        articleTypeDao.updateArticleType(articleType);
    }

    @Test
    public void getArticleTypeAllTest() {
        System.out.println(articleTypeDao.getArticleType(1));
    }
}
