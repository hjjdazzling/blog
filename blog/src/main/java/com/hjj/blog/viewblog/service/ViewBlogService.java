package com.hjj.blog.viewblog.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hjj.blog.projo.Article;
import com.hjj.blog.projo.Criteria;
import com.hjj.blog.projo.UserInformation2;
import com.hjj.blog.projo.ViewRecord;
import com.hjj.blog.viewblog.cache.ViewBlogCache;
import com.hjj.blog.viewblog.dao.ViewBlogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    @Autowired
    private ViewBlogCache viewBlogCache;

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

    public Integer updateArticlePraiseNumber(int id,int count) {
        return viewBlogDao.updateArticlePraiseNumber(id, count);
    }

    public UserInformation2 getUserInformation2ByIdFromCache(Integer userId) {
        return viewBlogCache.getUserInformation2(userId);
    }

    public void updateUserInformation2Cache(UserInformation2 userInformation2) {
        viewBlogCache.updateUserInformation2(userInformation2);
    }

    public Integer updateArticleNegaticePraiseNumber(int id,int count) {
        return viewBlogDao.updateArticleNegativeNumber(id, count);
    }

    public void updateUserInformation(int userId,int userHaveId, int count) {
        viewBlogDao.updateUserInformationAttentionNumber(userHaveId, count);
        viewBlogDao.updateUserInformationFansNumber(userId, count);
    }

    public List<Criteria> getArticleCriteriaById(int id) {
        return viewBlogDao.getArticleCriteriaById(id);
    }

}
