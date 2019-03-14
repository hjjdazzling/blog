package com.hjj.blog.search.dao;

import com.hjj.blog.projo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author haojunjie
 * @create 2019-03-14 15:24
 */
@Mapper
@Repository
public interface SearchDao {
    public List<Article> selectArticle(Article article);
}
