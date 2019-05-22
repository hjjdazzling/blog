package com.hjj.blog.articlecache.cache;

import com.hjj.blog.projo.Article;
import com.hjj.blog.projo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

import java.util.Map;

/**
 * @author haojunjie
 * @create 2019-05-14 15:21
 */
@Configuration
public class ArticleCacheConfiguration {
    @Bean(name="articleRedisTemplate")
    public RedisTemplate<String, Map<Integer, Article>> articleRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Map<Integer, Article>> userRedisTemplate = new RedisTemplate<>();
        userRedisTemplate.setConnectionFactory(redisConnectionFactory);

        GenericJackson2JsonRedisSerializer serializer = new
                GenericJackson2JsonRedisSerializer();
        //注意必须是setDefaultSerializer 的方法才能改变默认的
        userRedisTemplate.setDefaultSerializer(serializer);

        return userRedisTemplate;
    }

}
