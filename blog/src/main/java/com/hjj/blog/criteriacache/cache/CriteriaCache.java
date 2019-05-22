package com.hjj.blog.criteriacache.cache;

import com.hjj.blog.projo.Article;
import com.hjj.blog.projo.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * @author haojunjie
 * @create 2019-05-15 9:25
 */
@Repository
public class CriteriaCache {
    /**
     * com.hjj.blog.criteriacache.cache.CriteriaCacheConfiguration
     */
    @Autowired
    private RedisTemplate<String, Map<Integer, Criteria>> criteriaRedisTemplate;

    /**
     * com.hjj.blog.articlecache.cache.ArticleCacheConfiguration
     */
    @Autowired
    private RedisTemplate<String, Map<Integer, Article>> articleRedisTemplate;

    /**
     * 获取缓存中的文章id
     * @return
     */
    public List<Integer> getArticlesCacheId() {
        Set<Object> set = articleRedisTemplate.opsForHash().keys("article");
        List<Integer> list2 = new ArrayList<>(set.size());

        for (Object temp : set) {
            list2.add((Integer)temp);
        }

        return list2;
    }

    /**
     * 缓存redis对应id的评论信息
     */
    public void cacheCriteria(List<Criteria> criteria) {
        Map<Integer, Criteria> map = new HashMap<>(criteria.size());

        for(int i=0; i<criteria.size(); i++) {
            map.put(criteria.get(i).getId(), criteria.get(i));
        }


        criteriaRedisTemplate.opsForHash().putAll("criteria", map);
    }

    /**
     *  由于需要更新缓存，所以需要先删除上一次的信息
     */
    public void deleteCacheCriteria() {
        System.out.println("deleteCacheCriteria");
        criteriaRedisTemplate.delete("criteria");
    }
}
