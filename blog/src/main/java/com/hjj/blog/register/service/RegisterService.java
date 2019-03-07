package com.hjj.blog.register.service;

import com.hjj.blog.projo.User;
import com.hjj.blog.projo.UserInformation;
import com.hjj.blog.register.exception.UserExistedException;

/**
 * Created by haojunjie on 2019/2/25
 */
public interface RegisterService {
    public Integer registerUser(User user) throws UserExistedException;
    public Integer registerUserInformation(UserInformation  userInformation);
}
