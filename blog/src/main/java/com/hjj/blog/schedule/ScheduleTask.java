package com.hjj.blog.schedule;

import com.hjj.blog.articlecache.service.ArticleCacheService;
import com.hjj.blog.criteria.service.CriteriaService;
import com.hjj.blog.criteriacache.cache.CriteriaCache;
import com.hjj.blog.criteriacache.service.CriteriaCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author haojunjie
 * @create 2019-05-15 10:20
 */
@Component
public class ScheduleTask {
    private final static long ONE_DAY = 60 * 1000 * 60 * 24;
    @Autowired
    private CriteriaCacheService criteriaCacheService;

    @Autowired
    private ArticleCacheService articleCacheService;

    @Scheduled(fixedRate = ONE_DAY)
    public void test() {
//        articleCacheService.cacheArticles();
//        criteriaCacheService.cacheCriteria();
    }
}
