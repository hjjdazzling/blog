package com.hjj.blog.login.controller;

import com.hjj.blog.login.service.LoginService;
import com.hjj.blog.projo.Article;
import com.hjj.blog.projo.User;
import com.hjj.blog.recommend.service.RecommandService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by haojunjie on 2019/2/23
 */
@Controller("loginController")
@RequestMapping("/LoginController")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private RecommandService recommandService;
    @Autowired
    private Set<Article> articleSet;


    /**
     * 单点登陆
     * @param user
     * @param session
     * @return
     */
    @PostMapping("/login")
    public String login(@Valid User user, BindingResult bindingResult, HttpSession session, HttpServletRequest request) {

        if (bindingResult.getErrorCount() > 0) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();


            for (FieldError fieldError : fieldErrors) {
                //属性
                String field = fieldError.getField();
                //错误信息
                String message = fieldError.getDefaultMessage();

                request.setAttribute(field, message);
                return "/index";
            }
        }

        Integer id = loginService.login(user);
        user.setId(id);

        if (id == null || id < 0) {

            request.setAttribute("error", "用户名或者密码不正确");

            return "/index";
        } else {
            ServletContext servletContext = session.getServletContext();

            if (servletContext.getAttribute("loginUsers" ) == null) {
                ConcurrentHashMap<String, HttpSession> loginUsers = new ConcurrentHashMap<>();
                servletContext.setAttribute("loginUsers", loginUsers);
            }

            ConcurrentHashMap<String, HttpSession> loginUsers =
                    (ConcurrentHashMap<String, HttpSession>)servletContext.getAttribute("loginUsers");

            if (loginUsers.get(user.getUsername()) == null) {

                session.setAttribute("user", user);
                loginUsers.put(user.getUsername(), session);
            } else {
                HttpSession sessionOld = loginUsers.get(user.getUsername());
                if (sessionOld != session) {
                    sessionOld.invalidate();
                    session.setAttribute("user", user);
                    loginUsers.put(user.getUsername(), session);
                }
            }


            //session
            session.setMaxInactiveInterval(60*10);

            List<Article> recommandArticlesByProfessionalType =
                    recommandService.getRecommandArticleByProfessionalType(user.getId(), 1,5);

            List<Article> recommandArticlesByAttentionAllId =
                    recommandService.getRecommandArticleByAttentionAllId(user.getId(), 1, 5);


            if (recommandArticlesByProfessionalType != null) {
                articleSet.addAll(recommandArticlesByProfessionalType);
            }
            if(recommandArticlesByAttentionAllId != null) {
                articleSet.addAll(recommandArticlesByAttentionAllId);
            }

            session.setAttribute("recommandArticles", articleSet);

            return "select";
        }
    }
    
}
