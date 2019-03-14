package com.hjj.blog.deleteBlog.dao;

import org.apache.ibatis.annotations.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author haojunjie
 * @create 2019-03-13 15:08
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DeleteBlogDaoTest {
    @Autowired
    DeleteBlogDao deleteBlogDao;

    @Test
    public void deleteBlogById() {
        System.out.println(deleteBlogDao.deleteBlogById(3));
    }
}
