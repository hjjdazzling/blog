package com.hjj.blog.articlecache.cache;

import com.hjj.blog.projo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author haojunjie
 * @create 2019-05-14 15:21
 */
@Repository
public class ArticleCache {
    @Autowired
    private RedisTemplate<String, Map<Integer, Article>> redisTemplate;


    public void cacheArticles(List<Article> articles) {
        Map<Integer, Article> map = new HashMap<>();

        for (int i=0; i<articles.size(); i++) {
            map.put(articles.get(i).getId(), articles.get(i));
        }

        redisTemplate.opsForHash().putAll("article", map);
    }

    public void deleteArticles() {
        redisTemplate.delete("article");
    }

    /**
     * 使用文章的id获取对应的文章信息
     * @param id
     * @return
     */
    public Article getArticleById(int id) {
        Article article = (Article) redisTemplate.opsForHash().get("article", id);
        return article;
    }

    public void updateArticleById(Article article) {
        redisTemplate.opsForHash().put("article", article.getId(), article);
    }

    public void deleteArticleById(int id) {
        redisTemplate.opsForHash().delete("article", id);
    }
}
