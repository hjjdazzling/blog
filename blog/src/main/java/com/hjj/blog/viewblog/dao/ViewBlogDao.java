package com.hjj.blog.viewblog.dao;

import com.hjj.blog.projo.Article;
import org.apache.ibatis.annotations.Mapper;
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

    public Integer updateArticlePraiseNumber(int id);

    public Integer updateArticleNegativeNumber(int id);

    public Integer articleAttention(int id);

    public Integer articleCollect(int id);
}
