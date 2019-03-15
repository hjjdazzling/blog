package com.hjj.blog.search.controller;

import com.hjj.blog.projo.Article;
import com.hjj.blog.projo.Search;
import com.hjj.blog.search.service.SearchService;
import org.pegdown.PegDownProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
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
    public String  search(@RequestParam("pageNum") int pageNum,
                          @RequestParam("pageSize") int pageSize,
                          Search search, HttpServletRequest request, HttpSession session) {
        System.out.println("0" + search);

        if (!(search.getTitle() == null || search.getTitle().trim().equals(""))
                || !(search.getArticleType() == null || search.getArticleType().trim().equals(""))
                || !(search.getUsername() == null || search.getUsername().trim().equals(""))) {
            System.out.println("1" + search);
            session.setAttribute("search", search);

        } else {
            Search search1 = (Search) session.getAttribute("search");
            System.out.println("2" + search1);

            if(search1 != null) {
                search = search1;

            } else {
                request.setAttribute("error", "搜索框的输入内容不能全部为空");
                return "select";
            }
        }


        List<Article> articles = searchService.selectArticle(search, pageNum, pageSize);
        session.setAttribute("searchArticles", articles);
        return "displaySearchBlog";

    }
}
