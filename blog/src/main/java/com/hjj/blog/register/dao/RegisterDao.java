package com.hjj.blog.register.dao;

import com.hjj.blog.projo.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by haojunjie on 2019/2/25
 */
@Mapper
@Repository("registerDao")
public interface RegisterDao {
    public List<ProfessionalType1> selectProfessionType1();

    public List<ProfessionalType2> selectProfessionType2(Integer id);

    public List<ProfessionalType3> selectProfessionType3(Integer id);


    public int registerUser(User user);

    public int registerUserInformation(UserInformation userInformation);
}
