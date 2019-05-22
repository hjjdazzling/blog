package com.hjj.blog.register.cache;

import com.hjj.blog.projo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by haojunjie on 2019/2/24
 */
@Repository("registerCache")
public class RegisterCache {

    /**
     * userRedisTemplate 是login里面的com.hjj.blog.login.cache.configuration.LoginCacheConfiguration
     */
    @Autowired
    @Qualifier("userRedisTemplate")
    private RedisTemplate<String, Map<String, User>> redisTemplate;

    /**
     * 返回  null 不存在  需要查找数据库
     * 返回  用户id     登陆成功
     * 返回  0     密码不成功
     * 返回 -1     表示这是防止缓存穿透插入的数据
     * @param user
     * @return
     */



    public void registerCacheUser(User user) {
        if (redisTemplate.opsForHash().entries("user").size() == 0) {
            Map<String, User> map = new HashMap<>();
            User user1 = new User();
            user1.setId(1);
            map.put("1", user1);
            //设置过期时间
            redisTemplate.opsForHash().putAll("user", map);
            redisTemplate.expire("user", 24, TimeUnit.HOURS);
        }

        //将结果缓存起来
        redisTemplate.opsForHash().put("user", user.getUsername(), user);

    }
}
