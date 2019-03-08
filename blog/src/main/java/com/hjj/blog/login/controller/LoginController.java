package com.hjj.blog.login.controller;

import com.hjj.blog.login.service.LoginService;
import com.hjj.blog.projo.User;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by haojunjie on 2019/2/23
 */
@Controller("loginController")
@RequestMapping("/LoginController")
public class LoginController {
    @Autowired
    public LoginService loginService;

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
                sessionOld.invalidate();

                loginUsers.put(user.getUsername(), session);
            }



            return "write";
        }
    }
}
