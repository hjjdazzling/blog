package com.hjj.blog.viewblog.dao;

import com.hjj.blog.projo.Article;
import com.hjj.blog.projo.ViewRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author haojunjie
 * @create 2019-03-12 16:59
 */
@Mapper
@Repository
public interface ViewBlogDao {
    public List<Article> getArticle(int userId);

    public String getArticleContent(int id);

    public Integer getArticleUserId(int id);

    public Integer updateArticleViewCount(int id);

    public Integer updateArticlePraiseNumber(@Param("id") int id, @Param("count")int count);

    public Integer updateArticleNegativeNumber(@Param("id") int id, @Param("count")int count);

    public Integer updateUserInformationAttentionNumber(@Param("userId")int userId, @Param("count")int count);

    public Integer updateUserInformationFansNumber(@Param("userId")int userId, @Param("count")int count);


}
