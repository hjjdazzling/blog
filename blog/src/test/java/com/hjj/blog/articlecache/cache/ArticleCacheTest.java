package com.hjj.blog.articlecache.cache;

import com.hjj.blog.projo.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author haojunjie
 * @create 2019-05-15 14:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleCacheTest {
    @Autowired
    private ArticleCache articleCache;

    @Test
    public void deleteArticlesTest() {
        articleCache.deleteArticles();
    }

    @Test
    public void getArticleByIdTest() {
        System.out.println(articleCache.getArticleById(8));
    }

    @Test
    public void updateArticleByIdTest() {
        Article article = articleCache.getArticleById(8);
        System.out.println(article);
        article.setPraiseNumber(2);
        articleCache.updateArticleById(article);
        System.out.println(articleCache.getArticleById(8));

    }

    @Test
    public void deleteArticleByIdTest() {
        System.out.println(articleCache.getArticleById(8));
        articleCache.deleteArticleById(8);
        System.out.println(articleCache.getArticleById(8));
    }
}
