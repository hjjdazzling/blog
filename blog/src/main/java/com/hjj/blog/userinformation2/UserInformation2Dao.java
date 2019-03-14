package com.hjj.blog.userinformation2;

import com.hjj.blog.projo.UserInformation2;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author haojunjie
 * @create 2019-03-14 10:47
 */
@Mapper
@Repository
public interface UserInformation2Dao {
    public UserInformation2 getById(Integer id);

    public boolean add(UserInformation2 userInformation2);
}
