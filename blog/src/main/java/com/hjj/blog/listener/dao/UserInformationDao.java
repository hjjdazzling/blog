package com.hjj.blog.listener.dao;

import com.hjj.blog.projo.UserInformation2;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author haojunjie
 * @create 2019-03-18 13:48
 */
@Mapper
@Repository
public interface UserInformationDao {
    public UserInformation2 getUserInformation2ById(Integer id);

    public void updateUserInformation2(UserInformation2 userInformation2);

    public void addUserInformation2(UserInformation2 userInformation2);

}
