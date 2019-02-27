package com.hjj.blog.login.dao;

import com.hjj.blog.projo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by haojunjie on 2019/2/23
 */
@Mapper
@Repository("loginDao")
public interface LoginDao {
    public Integer login(User user);
}
