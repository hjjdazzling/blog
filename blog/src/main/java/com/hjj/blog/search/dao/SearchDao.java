package com.hjj.blog.search.dao;

import com.hjj.blog.projo.Article;
import com.hjj.blog.projo.ArticleType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author haojunjie
 * @create 2019-03-14 15:24
 */
@Mapper
@Repository
public interface SearchDao {
    public List<Article> selectArticle(@Param("title") String title,
                                       @Param("usernames") List<Integer> usernames,
                                       @Param("articleTypes") List<Integer> articleTypes);

    public List<Integer> selectUserName(@Param("username") String username);

    public List<Integer> selectArticleType(@Param("articleType") String articleType);
}
