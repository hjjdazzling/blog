package com.hjj.blog.filter;


import com.hjj.blog.projo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author haojunjie
 * @create 2019-05-13 10:04
 */
@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String url = request.getRequestURI();
        HttpSession session = request.getSession();
        //不拦截登录和注册操作,静态资源的访问
        if (url.equals("/") || url.contains("index.html") || url.contains("register.html")
                || url.contains("/LoginController/login") || url.contains("/bootstrap")
                || url.contains("/css") || url.contains("/editormd") || url.contains("/icons")
                || url.contains("/images") || url.contains("/jquery-3.2.1.min.js")
                || url.contains("/RegisterController/register")
                ||url.contains("/RegisterController/selectProfessionType1")
                || url.contains("/RegisterController/selectProfessionType2")
                || url.contains("/RegisterController/selectProfessionType3")
                || url.contains("/RegisterController/register.html")) {
            filterChain.doFilter(servletRequest, servletResponse);
        }

        User user = (User) session.getAttribute("user");

        if(user == null) {
            try {
                request.setAttribute("error", "请先登录");
                request.getRequestDispatcher("/index.html").forward(servletRequest, servletResponse);
                return ;
            } catch (Exception e)  {

            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
