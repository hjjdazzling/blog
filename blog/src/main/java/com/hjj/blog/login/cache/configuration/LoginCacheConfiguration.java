package com.hjj.blog.login.cache.configuration;

import com.hjj.blog.projo.User;
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
public class LoginCacheConfiguration {

    @Bean(name="userRedisTemplate")
    public RedisTemplate<String, Map<String, User>> userRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Map<String, User>> userRedisTemplate = new RedisTemplate<>();
        userRedisTemplate.setConnectionFactory(redisConnectionFactory);

        GenericJackson2JsonRedisSerializer serializer = new
                GenericJackson2JsonRedisSerializer();
        //注意必须是setDefaultSerializer 的方法才能改变默认的
        userRedisTemplate.setDefaultSerializer(serializer);
        return userRedisTemplate;
    }
}
