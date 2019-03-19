package com.hjj.blog.viewblog.cache;

import com.hjj.blog.projo.UserInformation2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

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
    RedisTemplate<String, Map<Integer, UserInformation2>> redisTemplate;

    public void updateUserInformation2(UserInformation2 userInformation2) {
        redisTemplate.opsForHash().put("user_information2", userInformation2.getUserId(), userInformation2);
    }

    public UserInformation2 getUserInformation2(Integer id) {
        return (UserInformation2)redisTemplate.opsForHash().entries("user_information2").get(id);
    }
}
