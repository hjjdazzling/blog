package com.hjj.blog.viewblog.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hjj.blog.projo.Article;
import com.hjj.blog.viewblog.dao.ViewBlogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author haojunjie
 * @create 2019-03-13 10:10
 */
@Transactional
@Service
public class ViewBlogService {
    @Autowired
    private  ViewBlogDao viewBlogDao;

    public List<Article> getArticle(Integer userId,int pageNum, int pageSize) {
        //使用分页插件
        PageHelper.startPage(pageNum, pageSize);
        List<Article> list = viewBlogDao.getArticle(userId);
        return list;
    }

    public String getArticleContent(int id) {
        return viewBlogDao.getArticleContent(id);
    }

    public Integer getArticleUserId(int id) {
        return viewBlogDao.getArticleUserId(id);
    }

    public Integer updateArticleViewCount(int id) {
        return viewBlogDao.updateArticleViewCount(id);
    }


}
