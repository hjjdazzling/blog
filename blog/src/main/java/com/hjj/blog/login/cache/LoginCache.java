package com.hjj.blog.login.cache;

import com.hjj.blog.projo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by haojunjie on 2019/2/24
 */
@Repository("loginCache")
public class LoginCache {

    @Autowired
    @Qualifier("userRedisTemplate")
    public RedisTemplate<String, Map<String, User>> redisTemplate;

    /**
     * 返回  null 不存在  需要查找数据库
     * 返回  1     登陆成功
     * 返回  0     密码不成功
     * @param user
     * @return
     */
    public Integer login(User user) {

        if (redisTemplate.opsForHash().entries("user").size() == 0) {
            Map<String, User> map = new HashMap<>();
            User user1 = new User();
            user1.setId(1);
            map.put("1", user1);
            //设置过期时间
            redisTemplate.opsForHash().putAll("user", map);
            redisTemplate.expire("user", 24, TimeUnit.HOURS);
            return null;
        } else {
            Map<Object, Object> map = redisTemplate.opsForHash().entries("user");

            User userCache = (User)map.get(user.getUsername());

            if (userCache == null) {
               return null;
            }

            if (user.getPassword().equals(userCache.getPassword())) {
                return 1;
            } else {
                return 0;
            }
        }

    }

    public void loginCacheUser(User user) {
        //将结果缓存起来
        redisTemplate.opsForHash().put("user", user.getUsername(), user);
    }
}
