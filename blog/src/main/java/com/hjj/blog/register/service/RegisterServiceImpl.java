package com.hjj.blog.register.service;

import com.hjj.blog.projo.*;
import com.hjj.blog.register.cache.RegisterCache;
import com.hjj.blog.register.dao.RegisterDao;
import com.hjj.blog.register.exception.UserExistedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by haojunjie on 2019/2/25
 */
@Transactional
@Service("registerServiceImpl")
public class RegisterServiceImpl implements RegisterService  {
    @Autowired
    private  RegisterDao registerDao;
    @Autowired
    private RegisterCache registerCache;

    public List<ProfessionalType1> selectProfessionType1() {
        return registerDao.selectProfessionType1();
    }

    public List<ProfessionalType2> selectProfessionType2(Integer id) {
        return registerDao.selectProfessionType2(id);
    }


    public List<ProfessionalType3> selectProfessionType3(Integer id) {
        return registerDao.selectProfessionType3(id);
    }

    @Override
    public Integer registerUser(User user) throws UserExistedException {
        try {
            Integer result = registerDao.registerUser(user);

            //注册成功返回1,他会自动将注册成功的id放入user中
            if (result > 0) {
                //将注册成功的用户信息放入redis中
                registerCache.registerCacheUser(user);
            }

            return result;
        } catch (Exception e) {
            throw new UserExistedException();
        }

    }

    @Override
    public Integer registerUserInformation(UserInformation  userInformation) {
        return registerDao.registerUserInformation(userInformation);
    }
}
