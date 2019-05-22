package com.hjj.blog.criteriacache.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author haojunjie
 * @create 2019-05-15 9:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CriteriaCacheServiceImplTest {
    @Autowired
    private CriteriaCacheService criteriaCacheService;

    @Test
    public void cacheCriteriaTest() {
        criteriaCacheService.cacheCriteria();
    }
}
