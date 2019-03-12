package com.hjj.blog.modifypersonal.dao;

import com.hjj.blog.projo.User;
import com.hjj.blog.projo.UserInformation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author haojunjie
 * @create 2019-03-11 13:24
 */
@Mapper
@Repository
public interface PersonalInformationDao {
    public UserInformation selectUserInformation(Integer userId);
    public boolean updateUser(User user);
    public boolean updateUserInformation(UserInformation userInformation);
}
