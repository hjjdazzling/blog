package com.hjj.blog.message.dao;


import com.hjj.blog.projo.CriteriaMessage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author haojunjie
 * @create 2019-03-28 20:05
 */
@Mapper
@Repository
public interface MessageDao {
    public List<CriteriaMessage>  getCriteriaMessagesByUserId(int userId);

    //点击过的信息更新下is_read为true
    public boolean updateCriteriaMessagesById(int id);

}
