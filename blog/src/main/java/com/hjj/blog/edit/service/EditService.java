package com.hjj.blog.edit.service;

import com.hjj.blog.edit.dao.EditDao;
import com.hjj.blog.projo.Article;
import com.hjj.blog.projo.ArticleType;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author haojunjie
 * @create 2019-03-11 8:40
 */
@Service
@Transactional
public class EditService {
    @Autowired
    EditDao editDao;

    public List<ArticleType> getAll(Integer id) {
        return editDao.getAll(id);
    }


    public Integer save(Article article) {
        return editDao.save(article);
    }

}
