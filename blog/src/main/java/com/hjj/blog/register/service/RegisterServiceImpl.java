package com.hjj.blog.register.service;

import com.hjj.blog.projo.User;
import com.hjj.blog.projo.UserInformation;
import com.hjj.blog.register.dao.RegisterDao;
import com.hjj.blog.register.exception.UserExistedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by haojunjie on 2019/2/25
 */
@Transactional
@Service("registerServiceImpl")
public class RegisterServiceImpl implements RegisterService  {
    @Autowired
    public RegisterDao registerDao;

    @Override
    public Integer registerUser(User user) throws UserExistedException {
        try {
            return registerDao.registerUser(user);
        } catch (Exception e) {
            throw new UserExistedException();
        }

    }

    @Override
    public Integer registerUserInformation(UserInformation  userInformation) {
        return registerDao.registerUserInformation(userInformation);
    }
}
