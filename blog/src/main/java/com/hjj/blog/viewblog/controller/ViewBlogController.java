package com.hjj.blog.viewblog.controller;

import com.hjj.blog.edit.service.EditService;
import com.hjj.blog.projo.Article;
import com.hjj.blog.projo.ArticleType;
import com.hjj.blog.projo.User;
import com.hjj.blog.viewblog.service.ViewBlogService;
import org.hibernate.validator.constraints.Email;
import org.pegdown.PegDownProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author haojunjie
 * @create 2019-03-13 10:11
 */
@Controller
@RequestMapping("viewBlogController")
public class ViewBlogController {
    @Autowired
    private ViewBlogService viewBlogService;
    @Autowired
    private PegDownProcessor peg;
    @Autowired
    public EditService editService;

    @RequestMapping("getArticle")
    public String getArticle(@RequestParam("pageNum") int pageNum,
                             @RequestParam("pageSize") int pageSize,
                             HttpServletRequest request, HttpSession session) {
        User user= (User) session.getAttribute("user");
        List<Article> list = viewBlogService.getArticle(user.getId(), pageNum, pageSize);
        session.setAttribute("articles", list);
        return "displayMyBlog";
    }

    @RequestMapping("/getArticleContent")
    public String getArticleContent(@RequestParam("id") Integer id,
                                    HttpServletRequest request,HttpSession session) {
        String content = viewBlogService.getArticleContent(id);
        //获取当前用户的信息,如果当前用户就是文章的拥有者则浏览数不变,否则+1
        User user = (User)session.getAttribute("user");
        //查询文章的拥有者user_id
        int userId = viewBlogService.getArticleUserId(id);
        if (user.getId() != userId) {
            //浏览数+1
            viewBlogService.updateArticleViewCount(id);
        }

        //将markDown语法转变成html语法
        String html =peg.markdownToHtml(content);
        request.setAttribute("content", html);

        return "display";
    }

    @RequestMapping("getContentToEdit")
    public String getContentToEdit(@RequestParam("id") Integer id, @RequestParam("title") String title,
                                   HttpServletRequest request,
                                   HttpSession session) {
        if (session.getAttribute("articleTypes") == null) {
            User user = (User) session.getAttribute("user");
            List<ArticleType> articleTypes = editService.getAll(user.getId());
            session.setAttribute("articleTypes", articleTypes);
        }

        String content = viewBlogService.getArticleContent(id);
        request.setAttribute("content", content);
        request.setAttribute("title", title);

        return "write";
    }

}
