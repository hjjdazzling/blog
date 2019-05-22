package com.hjj.blog.articlecache.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author haojunjie
 * @create 2019-05-14 15:36
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleCacheServiceTest {
    @Autowired
    ArticleCacheService articleCacheService;


    @Test
    public void cacheArticlesTest() {
        articleCacheService.cacheArticles();
    }
}
