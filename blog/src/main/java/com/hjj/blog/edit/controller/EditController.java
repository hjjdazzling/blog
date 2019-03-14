package com.hjj.blog.edit.controller;

import com.hjj.blog.edit.service.EditService;
import com.hjj.blog.projo.Article;
import com.hjj.blog.projo.ArticleType;
import com.hjj.blog.projo.User;
import org.pegdown.PegDownProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;


/**
 * @author haojunjie
 * @create 2019-03-07 19:27
 */
@Controller
@RequestMapping("/editController")
public class EditController {
    @Autowired
    public EditService editService;
    @Autowired
    private PegDownProcessor  peg;

    @RequestMapping("/write")
    public String write(HttpServletRequest request, HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<ArticleType> articleTypes = editService.getAll(user.getId());
        session.setAttribute("articleTypes", articleTypes);
        return "write";
    }

    @RequestMapping("/save")
    public String save(@Valid Article article, BindingResult bindingResult,
                       HttpServletRequest request,HttpSession session) {
        if (bindingResult.getErrorCount() > 0) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();


            for (FieldError fieldError : fieldErrors) {
                //属性
                String field = fieldError.getField();
                //错误信息
                String message = fieldError.getDefaultMessage();

                request.setAttribute(field + "Error", message);
                return "write";
            }
        }

        User user = (User)session.getAttribute("user");
        article.setUserId(user.getId());
        article.setUpdateTime(new Date());
        editService.save(article);
        //将markDown语法转变成html语法
        String html =peg.markdownToHtml(article.getContent());
        request.setAttribute("content", html);

        return "display";
    }

}
