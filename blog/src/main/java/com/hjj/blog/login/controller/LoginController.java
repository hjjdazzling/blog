package com.hjj.blog.login.controller;

import com.hjj.blog.login.service.LoginService;
import com.hjj.blog.projo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
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
    public String login(User user, HttpSession session, HttpServletRequest request) {

        if (loginService.login(user) == null || loginService.login(user) < 0) {

            request.setAttribute("error", "用户名或者密码不正确");
            return "index";
        } else {
            ServletContext servletContext = session.getServletContext();

            if (servletContext.getAttribute("loginUsers" ) == null) {
                ConcurrentHashMap<String, HttpSession> loginUsers = new ConcurrentHashMap<>();
                servletContext.setAttribute("loginUsers", loginUsers);
            }

            ConcurrentHashMap<String, HttpSession> loginUsers =
                    (ConcurrentHashMap<String, HttpSession>)servletContext.getAttribute("loginUsers");

            if (loginUsers.get(user.getUsername()) == null) {
                loginUsers.put(user.getUsername(), session);
            } else {
                HttpSession sessionOld = loginUsers.get(user.getUsername());
                sessionOld.invalidate();

                loginUsers.put(user.getUsername(), session);
            }



            return "main";
        }
    }
}
