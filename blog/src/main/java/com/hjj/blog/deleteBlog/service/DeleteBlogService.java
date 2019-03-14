package com.hjj.blog.deleteBlog.service;

import com.hjj.blog.deleteBlog.dao.DeleteBlogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author haojunjie
 * @create 2019-03-13 15:48
 */
@Transactional
@Service
public class DeleteBlogService {
    @Autowired
    DeleteBlogDao deleteBlogDao;

    public boolean deleteBlogById(int id) {
        return deleteBlogDao.deleteBlogById(id);
    }
}
