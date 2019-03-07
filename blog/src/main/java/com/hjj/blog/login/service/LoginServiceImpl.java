package com.hjj.blog.login.service;

import com.hjj.blog.login.cache.LoginCache;
import com.hjj.blog.login.dao.LoginDao;
import com.hjj.blog.projo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        result = loginCache.login(user);

        //先查缓存 null
        if (result == null) {
            result = loginDao.login(user);

            if (result != null && result > 0) {
                loginCache.loginCacheUser(user);
            }

        } else if (result == 0) {
            result = null;
        } else if(result == 1) {
            result = 1;
        }


        return result;
    }
}
