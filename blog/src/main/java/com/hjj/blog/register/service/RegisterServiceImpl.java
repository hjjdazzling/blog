package com.hjj.blog.register.service;

import com.hjj.blog.projo.User;
import com.hjj.blog.projo.UserInformation;
import com.hjj.blog.register.dao.RegisterDao;
import com.hjj.blog.register.exception.UserExistedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * Created by haojunjie on 2019/2/25
 */
@Service("registerServiceImpl")
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    public RegisterDao registerDao;

    public Integer register(User user, UserInformation userInformation) throws UserExistedException {
        try {
            registerDao.registerUser(user);
        } catch (Exception e) {
            throw new UserExistedException();
        }
        registerDao.registerUserInformation(userInformation);
        return 0;
    }
}
