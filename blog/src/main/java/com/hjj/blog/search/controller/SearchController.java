package com.hjj.blog.search.controller;

import com.hjj.blog.projo.Article;
import com.hjj.blog.search.service.SearchService;
import org.pegdown.PegDownProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author haojunjie
 * @create 2019-03-14 15:57
 */
@Controller
@RequestMapping("/SearchController")
public class SearchController {
    @Autowired
    private SearchService searchService;
    @Autowired
    private PegDownProcessor peg;


    @RequestMapping("/search")
    public String search(Article article, HttpSession session) {
        if(select.trim().equals("title")) {
            article.setTitle(search);
        }

        List<Article> list = searchService.selectArticle(article, pageNum, pageSize);
        session.setAttribute("articles", list);
        return "displayMyBlog";
    }
}
