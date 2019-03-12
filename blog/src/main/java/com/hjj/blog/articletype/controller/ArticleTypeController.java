package com.hjj.blog.articletype.controller;

import com.hjj.blog.articletype.service.ArticleTypeService;
import com.hjj.blog.projo.ArticleType;
import com.hjj.blog.projo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * @author haojunjie
 * @create 2019-03-12 10:40
 */
@Controller
@RequestMapping("/ArticleTypeController")
public class ArticleTypeController {
    @Autowired
    ArticleTypeService articleTypeService;

    @RequestMapping("/articleType.html")
    public String articleType(HttpServletRequest request, HttpSession session) {
        User user = (User)session.getAttribute("user");
        List<ArticleType> list = articleTypeService.getArticleType(user.getId());
        session.setAttribute("articleTypes", list);
        return "articleType";
    }
    @RequestMapping("/updateArticleType")
    public String updateArticleType(@Valid ArticleType articleType,BindingResult bindingResult,
                                    HttpSession session,HttpServletRequest request) {
        if (bindingResult.getErrorCount() > 0) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();

            for (FieldError fieldError : fieldErrors) {
                //属性
                String field = fieldError.getField();
                //错误信息
                String message = fieldError.getDefaultMessage();

                request.setAttribute(field + "Error2", message);
            }

            return "articleType";
        }

        articleTypeService.updateArticleType(articleType);
        //更新session中的信息
        List<ArticleType> articleTypes = (List<ArticleType>)session.getAttribute("articleTypes");

        for (int i=0; i<articleTypes.size(); i++) {
            if(articleTypes.get(i).getId() == articleType.getId()) {
                articleTypes.get(i).setTypeName(articleType.getTypeName());
            }
        }
        session.setAttribute("articleTypes", articleTypes);
        return "articleType";
    }

    @RequestMapping("/deleteArticleType")
    public String deleteArticleType(@RequestParam("id") Integer id, HttpSession session) {
        articleTypeService.deleteArticleType(id);

        //更新session中的信息
        List<ArticleType> articleTypes = (List<ArticleType>)session.getAttribute("articleTypes");

        for (int i=0; i<articleTypes.size(); i++) {
            if(articleTypes.get(i).getId() == id) {
                articleTypes.remove(i);
            }
        }
        session.setAttribute("articleTypes", articleTypes);

        return "articleType";
    }

    @RequestMapping("/addArticleType")
    public String addArticleType(@Valid ArticleType articleType, BindingResult bindingResult,
                                 HttpServletRequest request,HttpSession session) {
        if (bindingResult.getErrorCount() > 0) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();

            for (FieldError fieldError : fieldErrors) {
                //属性
                String field = fieldError.getField();
                //错误信息
                String message = fieldError.getDefaultMessage();

                request.setAttribute(field + "Error1", message);
            }

            return "articleType";
        }

        //更新session中的信息
        List<ArticleType> articleTypes = (List<ArticleType>)session.getAttribute("articleTypes");

        articleTypeService.addArticleType(articleType);
        System.out.println(articleType);
        articleTypes.add(articleType);
        session.setAttribute("articleTypes", articleTypes);

        return "articleType";
    }
}
