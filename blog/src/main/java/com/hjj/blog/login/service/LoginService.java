package com.hjj.blog.login.service;

import com.hjj.blog.projo.User;
import org.springframework.stereotype.Service;

/**
 * Created by haojunjie on 2019/2/23
 */
public interface LoginService {
    public Integer login(User user);
}
