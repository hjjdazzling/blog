package com.hjj.blog.articletype.service;

import com.hjj.blog.articletype.dao.ArticleTypeDao;
import com.hjj.blog.projo.ArticleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author haojunjie
 * @create 2019-03-12 10:37
 */
@Transactional
@Service
public class ArticleTypeService {
    @Autowired
    public ArticleTypeDao articleTypeDao;

    public List<ArticleType> getArticleType(Integer userId) {
        return articleTypeDao.getArticleType(userId);
    }

    public Integer addArticleType(ArticleType articleType) {
        return articleTypeDao.addArticleType(articleType);
    }

    public Integer deleteArticleType(Integer id) {
        return articleTypeDao.deleteArticleType(id);
    }

    public Integer updateArticleType(ArticleType articleType) {
        return articleTypeDao.updateArticleType(articleType);
    }
}
