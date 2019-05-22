package com.hjj.blog.criteriacache.cache;

import com.hjj.blog.projo.Article;
import com.hjj.blog.projo.Criteria;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

import java.util.Map;

/**
 * @author haojunjie
 * @create 2019-05-15 9:30
 */
@Configuration
public class CriteriaCacheConfiguration {
    @Bean(name="criteriaRedisTemplate")
    public RedisTemplate<String, Map<Integer, Criteria>> criteriaRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Map<Integer, Criteria>> criteriaRedisTemplate = new RedisTemplate<>();
        criteriaRedisTemplate.setConnectionFactory(redisConnectionFactory);

        GenericJackson2JsonRedisSerializer serializer = new
                GenericJackson2JsonRedisSerializer();
        //注意必须是setDefaultSerializer 的方法才能改变默认的
        criteriaRedisTemplate.setDefaultSerializer(serializer);
        return criteriaRedisTemplate;
    }
}
