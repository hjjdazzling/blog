package com.hjj.blog.deleteBlog.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author haojunjie
 * @create 2019-03-13 15:08
 */
@Mapper
@Repository
public interface DeleteBlogDao {
    public boolean deleteBlogById(int id);
}
