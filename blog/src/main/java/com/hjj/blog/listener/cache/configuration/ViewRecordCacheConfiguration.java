package com.hjj.blog.listener.cache.configuration;

import com.hjj.blog.projo.ViewRecord;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @author haojunjie
 * @create 2019-03-21 14:04
 */
@Configuration
public class ViewRecordCacheConfiguration {
    @Bean(name="viewRecordRedisTemplate")
    public RedisTemplate<String, Map<Integer, ViewRecord>> viewRecordRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Map<Integer, ViewRecord>> viewRecordRedisTemplate = new RedisTemplate<>();
        viewRecordRedisTemplate.setConnectionFactory(redisConnectionFactory);

        GenericJackson2JsonRedisSerializer serializer = new
                GenericJackson2JsonRedisSerializer();
        //注意必须是setDefaultSerializer 的方法才能改变默认的
        viewRecordRedisTemplate.setDefaultSerializer(serializer);
        return viewRecordRedisTemplate;
    }

    @Bean(name="viewRecordUserIdredisTemplate")
    public RedisTemplate<String, Integer> viewRecordUserIdredisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Integer> viewRecordRedisTemplate = new RedisTemplate<>();
        viewRecordRedisTemplate.setConnectionFactory(redisConnectionFactory);

        GenericJackson2JsonRedisSerializer serializer = new
                GenericJackson2JsonRedisSerializer();
        //注意必须是setDefaultSerializer 的方法才能改变默认的
        viewRecordRedisTemplate.setDefaultSerializer(serializer);
        return viewRecordRedisTemplate;
    }

    @Bean
    public ViewRecord viewRecord() {
        ViewRecord viewRecord = new ViewRecord();
        viewRecord.setViewTime(new Date());
        viewRecord.setViewRecord(new HashSet<Integer>());
        return viewRecord;
    }
}
