package com.hjj.blog.listener;

import com.hjj.blog.listener.service.UserInformationService;
import com.hjj.blog.listener.service.ViewRecordService;
import com.hjj.blog.projo.Article;
import com.hjj.blog.projo.User;
import com.hjj.blog.recommend.service.RecommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author haojunjie
 * @create 2019-03-18 12:55
 */
@WebListener
public class LoginAndExitListener implements HttpSessionListener,
        HttpSessionAttributeListener{

    private UserInformationService userInformationService;
    private ViewRecordService viewRecordService;

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        //初始化userInformationService
        userInformationService = WebApplicationContextUtils.getWebApplicationContext(
                httpSessionEvent.getSession().getServletContext()).getBean(UserInformationService.class);
        viewRecordService = WebApplicationContextUtils.getWebApplicationContext(
                httpSessionEvent.getSession().getServletContext()).getBean(ViewRecordService.class);

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        User user = (User) session.getAttribute("user");
        userInformationService.deleteCache(user.getId());
        viewRecordService.flushCacheAndDeleteCache(user.getId());
        //删除ServletContext中的session信息
        ServletContext servletContext = session.getServletContext();
        ConcurrentHashMap<String, HttpSession> loginUsers =
                (ConcurrentHashMap<String, HttpSession>)servletContext.getAttribute("loginUsers");
        loginUsers.remove(user.getUsername());
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        if(httpSessionBindingEvent.getName() == "user") {

            HttpSession session = httpSessionBindingEvent.getSession();
            User user = (User) session.getAttribute("user");
            //查询user的个人信息放入redis，退出时从删除
            userInformationService.cache(user.getId());
            viewRecordService.cache(user.getId());
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {}

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {}
}
