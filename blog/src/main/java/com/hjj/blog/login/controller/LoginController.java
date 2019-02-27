package com.hjj.blog.login.controller;

import com.hjj.blog.login.service.LoginService;
import com.hjj.blog.projo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by haojunjie on 2019/2/23
 */
@Controller("loginController")
@RequestMapping("LoginController")
public class LoginController {
    @Autowired
    public LoginService loginService;


    /**
     * 单点登陆
     * @param user
     * @param session
     * @return
     */
    @ResponseBody
    @GetMapping("/login")
    public Integer login(User user, HttpSession session) {
        System.out.println(user);
        Map<String,String> map = new HashMap<>();

        if (loginService.login(user) == null || loginService.login(user) < 0) {
            return 0;
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
            map.put("result", "success");

            return map;
        }
    }
}
