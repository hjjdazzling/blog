package com.hjj.blog.viewblog.dao;

import com.hjj.blog.projo.ViewRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author haojunjie
 * @create 2019-03-12 17:08
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ViewBlogDaoTest {
    @Autowired
    ViewBlogDao viewBlogDao;

    @Test
    public void getTitleTest() {
        System.out.println(viewBlogDao.getArticle(1));
    }

    @Test
    public void getArticleContentTest() {
        System.out.println(viewBlogDao.getArticleContent(1));
    }

    @Test
    public void getArticleUserId() {
        System.out.println(viewBlogDao.getArticleUserId(8));
    }

    @Test
    public void updateArticleViewCountTest() {
        System.out.println(viewBlogDao.updateArticleViewCount(8));
    }

    @Test
    public void updateArticlePraiseNumber() {
//        int id = 8;
//        int count = -1;
//
//        viewBlogDao.updateArticlePraiseNumber(id, count);

        int id = 8;
        int count = -1;

        viewBlogDao.updateArticlePraiseNumber(id, count);
    }
}
