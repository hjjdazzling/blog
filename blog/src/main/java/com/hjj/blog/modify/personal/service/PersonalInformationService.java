package com.hjj.blog.modify.personal.service;

import com.hjj.blog.modify.personal.cache.UserUpdateCache;
import com.hjj.blog.modify.personal.dao.PersonalInformationDao;
import com.hjj.blog.projo.*;
import com.hjj.blog.register.dao.RegisterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author haojunjie
 * @create 2019-03-11 13:24
 */
@Transactional
@Service
public  class PersonalInformationService {
    @Autowired
    PersonalInformationDao personalInformationDao;

    @Autowired
    RegisterDao registerDao;

    @Autowired
    UserUpdateCache userUpdateCache;

    public List<ProfessionalType1> selectProfessionType1() {
        return registerDao.selectProfessionType1();
    }

    public List<ProfessionalType2> selectProfessionType2(Integer id) {
        return registerDao.selectProfessionType2(id);
    }


    public List<ProfessionalType3> selectProfessionType3(Integer id) {
        return registerDao.selectProfessionType3(id);
    }


    public UserInformation selectUserInformation(Integer userId) {
        return personalInformationDao.selectUserInformation(userId);
    }

    public boolean update(User user, UserInformation userInformation) {
        personalInformationDao.updateUser(user);
        personalInformationDao.updateUserInformation(userInformation);
        userUpdateCache.updateCache(user);
        return true;
    }
}
