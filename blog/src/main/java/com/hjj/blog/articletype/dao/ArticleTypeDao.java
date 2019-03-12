package com.hjj.blog.articletype.dao;

import com.hjj.blog.projo.ArticleType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author haojunjie
 * @create 2019-03-12 9:48
 */
@Mapper
@Repository
public interface ArticleTypeDao {
    public List<ArticleType> getArticleType(Integer userId);

    public Integer addArticleType(ArticleType articleType);

    public Integer deleteArticleType(Integer id);

    public Integer updateArticleType(ArticleType articleType);
}
