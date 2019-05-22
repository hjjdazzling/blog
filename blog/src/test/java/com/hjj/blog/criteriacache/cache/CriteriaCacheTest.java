package com.hjj.blog.criteriacache.cache;

import com.hjj.blog.criteriacache.dao.CriteriaCacheDao;
import com.hjj.blog.projo.Article;
import com.hjj.blog.projo.Criteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author haojunjie
 * @create 2019-05-15 9:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CriteriaCacheTest {
    @Autowired
    private CriteriaCacheDao criteriaCacheDao;
    @Autowired
    private CriteriaCache criteriaCache;

    @Test
    public void getArticlesCacheIdTest() {
        System.out.println(criteriaCache.getArticlesCacheId());
    }

    @Test
    public void cacheCriteriaTest() {
        List<Criteria> list = criteriaCacheDao.getCriterias(criteriaCache.getArticlesCacheId());
        criteriaCache.cacheCriteria(list);
    }

    @Test
    public void deleteCacheCriteria(){
        criteriaCache.deleteCacheCriteria();
    }
}
