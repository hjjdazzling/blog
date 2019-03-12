package com.hjj.blog.modifypersonal.Cache;

import com.hjj.blog.modifypersonal.cache.UserUpdateCache;
import com.hjj.blog.projo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author haojunjie
 * @create 2019-03-11 19:14
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserUpdateCacheTest {
    @Autowired
    public UserUpdateCache userUpdateCache;
    @Test
    public void updateCacheTest() {
        User user = new User();
        user.setId(1);
        user.setUsername("haojunjie");
        user.setPassword("haojunjie");
        userUpdateCache.updateCache(user);
    }
}
