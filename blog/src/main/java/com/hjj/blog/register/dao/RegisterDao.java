package com.hjj.blog.register.dao;

import com.hjj.blog.projo.User;
import com.hjj.blog.projo.UserInformation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by haojunjie on 2019/2/25
 */
@Mapper
@Repository("registerDao")
public interface RegisterDao {
    public int registerUser(User user);

    public int registerUserInformation(UserInformation userInformation);
}
