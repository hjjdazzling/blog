package com.hjj.blog.login.service;

import com.hjj.blog.login.cache.LoginCache;
import com.hjj.blog.login.dao.LoginDao;
import com.hjj.blog.projo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

/**
 * Created by haojunjie on 2019/2/23
 */
@Transactional
@Service("loginService")
public class LoginServiceImpl implements LoginService {
    @Autowired
    public LoginDao loginDao;

    @Autowired
    public LoginCache loginCache;

    /**
     * 登陆不成功返回null  成功返回id
     */
    @Override
    public Integer login(User user) {
        Integer result = null;
        //先查缓存
        result = loginCache.login(user);

        //先查缓存 null
        if (result == null) {

            result = loginDao.login(user);

            if (result != null && result > 0) {

                user.setId(result);
                loginCache.loginCacheUser(user);
            } //没有这个用户放入此用户名和时间戳
            else {
                Instant instant = Instant.now().plusMillis(TimeUnit.HOURS.toMillis(8));
                long timeStamp = instant.getEpochSecond();
                user.setId(-1);
                user.setPassword(String.valueOf(timeStamp));
                loginCache.loginCacheUser(user);
                result = null;
            }

        } else if (result == 0) {
            result = null;
        }

        return result;
    }
}
