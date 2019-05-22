package com.hjj.blog.criteriacache.service;

import org.springframework.stereotype.Service;

/**
 * @author haojunjie
 * @create 2019-05-15 9:26
 */

public interface CriteriaCacheService {

    /**
     * 缓存redis中对应文章的评论信息
     */
    public void cacheCriteria();
}
