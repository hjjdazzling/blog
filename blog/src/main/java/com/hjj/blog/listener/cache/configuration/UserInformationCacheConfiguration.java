package com.hjj.blog.listener.cache.configuration;

import com.hjj.blog.projo.User;
import com.hjj.blog.projo.UserInformation2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

import java.util.Map;

/**
 * Created by haojunjie on 2019/3/10
 */
@Configuration
public class UserInformationCacheConfiguration {

    @Bean(name="userInformationRedisTemplate")
    public RedisTemplate<String, Map<Integer, UserInformation2>> userInformationRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Map<Integer, UserInformation2>> userInformationRedisTemplate = new RedisTemplate<>();
        userInformationRedisTemplate.setConnectionFactory(redisConnectionFactory);

        GenericJackson2JsonRedisSerializer serializer = new
                GenericJackson2JsonRedisSerializer();
        //注意必须是setDefaultSerializer 的方法才能改变默认的
        userInformationRedisTemplate.setDefaultSerializer(serializer);
        return userInformationRedisTemplate;
    }
}
