package com.hjj.blog.articlecache.service;

import com.hjj.blog.articlecache.cache.ArticleCache;
import com.hjj.blog.articlecache.dao.ArticleCacheDao;
import com.hjj.blog.projo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author haojunjie
 * @create 2019-05-14 15:29
 */

public interface ArticleCacheService {
    public void cacheArticles();
}
