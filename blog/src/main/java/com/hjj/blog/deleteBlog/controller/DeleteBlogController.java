package com.hjj.blog.deleteBlog.controller;

import com.hjj.blog.deleteBlog.service.DeleteBlogService;
import com.hjj.blog.projo.Article;
import com.hjj.blog.projo.ArticleType;
import com.hjj.blog.projo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author haojunjie
 * @create 2019-03-13 15:52
 */
@Controller
@RequestMapping("/DeleteBlogController")
public class DeleteBlogController {
    @Autowired
    DeleteBlogService deleteBlogService;

    @RequestMapping("/deleteBlogById")
    public String deleteBlogById(@RequestParam("id") int id, HttpSession session) {
        deleteBlogService.deleteBlogById(id);

        List<Article> articles = (List<Article>)session.getAttribute("articles");

        for(int i=0; i<articles.size(); i++) {
            if(articles.get(i).getId() == id) {
                articles.remove(i);
                break;
            }
        }

        session.setAttribute("articles", articles);
        return "displayMyBlog";
    }
}
