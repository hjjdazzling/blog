package com.hjj.blog.criteria.dao;

import com.hjj.blog.projo.Criteria;
import com.hjj.blog.projo.CriteriaMessage;
import com.hjj.blog.projo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author haojunjie
 * @create 2019-03-27 10:05
 */
@Mapper
@Repository
public interface CriteriaDao {
    public Integer insertCriteria(Criteria criteria);

    public Integer updateCriteria(Criteria criteria);

    public Integer selectCriteriaIsExisted(Criteria criteria);

    public List<Criteria> selectCriteriaByArticleId(int id);

    public Criteria selectById(int id);

    public Integer insertCriteriaMessage(CriteriaMessage criteriaMessage);

    public Integer updateCriteriaMessage(int id);

    public List<CriteriaMessage> getByUserId(int userId);

    public String getUserNameById(int id);

    public Integer isAuthor(@Param("userId") int userId, @Param("articleId") int articleId);

    public Integer getIdByUserName(String username);

    //根据文章的id值查作者的信息
    public User selectAuthorByArticleId(int id);
}
