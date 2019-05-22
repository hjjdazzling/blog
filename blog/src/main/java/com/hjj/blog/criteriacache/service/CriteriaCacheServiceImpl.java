package com.hjj.blog.criteriacache.service;

import com.hjj.blog.criteriacache.cache.CriteriaCache;
import com.hjj.blog.criteriacache.dao.CriteriaCacheDao;
import com.hjj.blog.projo.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author haojunjie
 * @create 2019-05-15 9:29
 */
@Service
public class CriteriaCacheServiceImpl implements CriteriaCacheService {
    @Autowired
    private CriteriaCacheDao criteriaCacheDao;

    @Autowired
    private CriteriaCache criteriaCache;


    @Override
    public void cacheCriteria() {
        criteriaCache.deleteCacheCriteria();
        List<Integer> articlesId = criteriaCache.getArticlesCacheId();
        List<Criteria> criterias = criteriaCacheDao.getCriterias(articlesId);
        criteriaCache.cacheCriteria(criterias);
    }
}
