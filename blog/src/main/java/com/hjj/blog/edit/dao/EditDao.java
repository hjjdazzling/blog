package com.hjj.blog.edit.dao;

import com.hjj.blog.projo.Article;
import com.hjj.blog.projo.ArticleType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author haojunjie
 * @create 2019-03-11 8:06
 */
@Mapper
@Repository
public interface EditDao {
    public List<ArticleType> getAll(Integer id);

    public Integer save(Article article);
}
