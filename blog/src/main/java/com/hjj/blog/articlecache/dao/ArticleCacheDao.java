package com.hjj.blog.articlecache.dao;

import com.hjj.blog.projo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author haojunjie
 * @create 2019-05-14 15:08
 */
@Mapper
@Repository
public interface ArticleCacheDao {
    //查找一部分文章进行缓存
    public List<Article> articles();
}
