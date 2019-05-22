package com.hjj.blog.criteriacache.dao;

import com.hjj.blog.criteriacache.cache.CriteriaCache;
import com.hjj.blog.projo.Criteria;
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
 * @create 2019-05-15 9:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CriteriaCacheDaoTest {
    @Autowired
    private CriteriaCacheDao criteriaCacheDao;
    @Autowired
    private CriteriaCache criteriaCache;

    @Test
    public void getCriteriasTest() {
        List<Criteria> list = criteriaCacheDao.getCriterias(criteriaCache.getArticlesCacheId());
        System.out.println(list);
    }
}
