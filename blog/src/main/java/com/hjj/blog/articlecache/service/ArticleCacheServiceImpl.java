package com.hjj.blog.articlecache.service;

import com.hjj.blog.articlecache.cache.ArticleCache;
import com.hjj.blog.articlecache.dao.ArticleCacheDao;
import com.hjj.blog.projo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author haojunjie
 * @create 2019-05-15 14:40
 */
@Service
public class ArticleCacheServiceImpl implements  ArticleCacheService {
    @Autowired
    private ArticleCacheDao articleCacheDao;
    @Autowired
    private ArticleCache articleCache;

    public void cacheArticles() {
        articleCache.deleteArticles();
        List<Article> articles = articleCacheDao.articles();
        articleCache.cacheArticles(articles);
    }
}
