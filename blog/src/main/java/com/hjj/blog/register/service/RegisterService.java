package com.hjj.blog.register.service;

import com.hjj.blog.projo.*;
import com.hjj.blog.register.exception.UserExistedException;

import java.util.List;

/**
 * Created by haojunjie on 2019/2/25
 */
public interface RegisterService {
    public Integer registerUser(User user) throws UserExistedException;
    public Integer registerUserInformation(UserInformation  userInformation);
    public List<ProfessionalType1> selectProfessionType1();

    public List<ProfessionalType2> selectProfessionType2(Integer id);

    public List<ProfessionalType3> selectProfessionType3(Integer id);
}
