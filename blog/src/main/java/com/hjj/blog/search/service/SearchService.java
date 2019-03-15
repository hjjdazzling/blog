package com.hjj.blog.search.service;

import com.github.pagehelper.PageHelper;
import com.hjj.blog.projo.Article;
import com.hjj.blog.projo.Search;
import com.hjj.blog.search.dao.SearchDao;
import org.pegdown.PegDownProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author haojunjie
 * @create 2019-03-14 15:56
 */
@Transactional
@Service
public class SearchService {
    @Autowired
    public SearchDao searchDao;

    @Autowired
    private PegDownProcessor peg;

    public List<Article> selectArticle(Search search, int pageNum, int pageSize) {
        List<Integer> usernames = searchDao.selectUserName(search.getUsername());
        List<Integer> articles = searchDao.selectArticleType(search.getArticleType());
        //使用分页插件
        PageHelper.startPage(pageNum, pageSize);
        return searchDao.selectArticle(search.getTitle(), usernames, articles);
    }
}
