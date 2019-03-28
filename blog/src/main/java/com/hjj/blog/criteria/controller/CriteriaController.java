package com.hjj.blog.criteria.controller;

import com.hjj.blog.criteria.service.CriteriaService;
import com.hjj.blog.projo.Criteria;
import com.hjj.blog.projo.CriteriaMessage;
import com.hjj.blog.projo.Message;
import com.hjj.blog.projo.User;
import com.hjj.blog.viewblog.service.ViewBlogService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author haojunjie
 * @create 2019-03-27 14:22
 */
@Controller
@RequestMapping("/CriteriaController")
public class CriteriaController {
    @Autowired
    private CriteriaService criteriaService;

    @Autowired
    private CriteriaMessage criteriaMessage;

    @Autowired
    private ViewBlogService viewBlogService;

    @RequestMapping("/criteria")
    public String criteria(Message message, Criteria criteria, HttpSession session,
                           @RequestParam(value = "content2", required = false) String content2,
                           @RequestParam(value = "toUserId", required = false) Integer toUserId,
                           @RequestParam("isReply") boolean isReply,
                           @RequestParam(value = "criteriaId",required = false) Integer criteriaId) {
        message.setTime(new Date());
        criteria.getCriteriaArticle().add(message);
        criteria.setCriteriaTime(new Date());

        criteriaMessage.setTime(new Date());
        criteriaMessage.setRead(false);
        User user = (User)session.getAttribute("user");

        String[] strs = null;
        if (content2 != null) {
            //查出要恢复的ID 根据用户名
            if (content2.contains("评论")) {
                strs = content2.split("评论");
            } else {
                strs = content2.split("回复");
            }

            toUserId = criteriaService.getIdByUserName(strs[0]);
        }


        //文章的作者
        criteriaMessage.setUserId(toUserId);
        criteriaMessage.setFromUserId(user.getId());


        if (criteriaId == null) {
            criteriaId = -1;
        }
        criteriaService.criteria(criteria, criteriaMessage, user, toUserId, isReply, criteriaId);

        //添加评论信息
        List<Criteria> list = viewBlogService.getArticleCriteriaById(criteria.getArticleId());
        session.setAttribute("criterias", list);
        return "display";
    }
}
