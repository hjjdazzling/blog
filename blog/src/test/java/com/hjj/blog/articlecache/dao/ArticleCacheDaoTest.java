package com.hjj.blog.articlecache.dao;

import com.hjj.blog.projo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author haojunjie
 * @create 2019-05-14 15:08
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleCacheDaoTest {
    @Autowired
    private ArticleCacheDao articleCacheDao;

    @Test
    public void articlesTest() {
        System.out.println(articleCacheDao.articles().size());
    }
}
