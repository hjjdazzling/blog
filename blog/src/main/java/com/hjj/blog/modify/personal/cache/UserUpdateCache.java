package com.hjj.blog.modify.personal.cache;

import com.hjj.blog.projo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author haojunjie
 * @create 2019-03-11 16:36
 */
@Repository
public class UserUpdateCache {
    @Autowired
    @Qualifier("userUpdateCacheRedisTemplate")
    public RedisTemplate<String, Map<String, User>> redisTemplate;

    public void updateCache(User user) {
        redisTemplate.opsForHash().put("user", user.getUsername(), user);
    }
}
