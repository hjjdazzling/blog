package com.hjj.blog.viewblog.cache;

import com.hjj.blog.projo.Article;
import com.hjj.blog.projo.UserInformation2;
import com.hjj.blog.projo.ViewRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author haojunjie
 * @create 2019-03-19 15:00
 */
@Repository
public class ViewBlogCache {
    /**
     * com.hjj.blog.listener.cache.configuration.UserInformationCacheConfiguration
     */
    @Autowired
    private RedisTemplate<String, Map<Integer, UserInformation2>> redisTemplate;
    /**
     * com.hjj.blog.articlecache.cache.ArticleCacheConfiguration
     *
     */
    @Autowired
    private RedisTemplate<String, Map<Integer, Article>> articleRedisTemplate;

    public void updateUserInformation2(UserInformation2 userInformation2) {
        redisTemplate.opsForHash().put("user_information2", userInformation2.getUserId(), userInformation2);
    }

    public UserInformation2 getUserInformation2(Integer id) {
        return (UserInformation2)redisTemplate.opsForHash().entries("user_information2").get(id);
    }

    public Article getById(int articleId) {

        return (Article)articleRedisTemplate.opsForHash().get("article", articleId);
    }

    public List<Article> getByUserId(int userId) {
        Map<Object, Object> map = articleRedisTemplate.opsForHash().entries("article");


        List<Article> list = new ArrayList<>();
        Set<Object> set =  map.keySet();
        Article article = null;

        for(Object id : set) {
            article = (Article) map.get(id);

            if(article.getUserId() == userId) {
                list.add(article);
            }
        }
        return list;
    }
}
