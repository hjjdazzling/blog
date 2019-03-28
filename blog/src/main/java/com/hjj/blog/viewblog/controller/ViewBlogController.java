package com.hjj.blog.viewblog.controller;

import com.hjj.blog.edit.service.EditService;
import com.hjj.blog.listener.service.ViewRecordService;
import com.hjj.blog.projo.*;
import com.hjj.blog.viewblog.service.ViewBlogService;
import org.hibernate.validator.constraints.Email;
import org.pegdown.PegDownProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

/**
 * @author haojunjie
 * @create 2019-03-13 10:11
 */
@Controller
@RequestMapping("viewBlogController")
public class ViewBlogController {
    @Autowired
    private ViewBlogService viewBlogService;
    @Autowired
    private PegDownProcessor peg;
    @Autowired
    private EditService editService;
    @Autowired
    private ViewRecordService viewRecordService;

    @RequestMapping("getArticle")
    public String getArticle(@RequestParam("pageNum") int pageNum,
                             @RequestParam("pageSize") int pageSize,
                             HttpServletRequest request, HttpSession session) {
        User user= (User) session.getAttribute("user");
        List<Article> list = viewBlogService.getArticle(user.getId(), pageNum, pageSize);
        session.setAttribute("articles", list);
        return "displayMyBlog";
    }

    @RequestMapping("/getArticleContent")
    public String getArticleContent(@RequestParam("id") Integer id,
                                    HttpServletRequest request,HttpSession session) {
        String content = viewBlogService.getArticleContent(id);
        //获取当前用户的信息,如果当前用户就是文章的拥有者则浏览数不变,否则+1
        User user = (User)session.getAttribute("user");
        //查询文章的拥有者user_id
        int userId = viewBlogService.getArticleUserId(id);
        session.setAttribute("articleAuthorId", userId);

        if (user.getId() != userId) {
            //浏览数+1
            viewBlogService.updateArticleViewCount(id);
        }

        //将markDown语法转变成html语法
        String html =peg.markdownToHtml(content);
        session.setAttribute("content", html);
        UserInformation2 userInformation2 = viewBlogService.getUserInformation2ByIdFromCache(user.getId());

        if (userInformation2.getPraiseAllId() != null && userInformation2.getPraiseAllId().contains(id)) {
            session.setAttribute("isPraise", "true");
        } else {
            session.setAttribute("isPraise", "false");
        }

        if (userInformation2.getNegativeAllId() != null && userInformation2.getNegativeAllId().contains(id)) {
            session.setAttribute("isNegativePraise", "true");
        } else {
            session.setAttribute("isNegativePraise", "false");
        }

        if (userInformation2.getCollectAllId() != null && userInformation2.getCollectAllId().contains(id)) {
            session.setAttribute("isCollect", "true");
        } else {
            session.setAttribute("isCollect", "false");
        }

        if (userInformation2.getAttentionAllId() != null && userInformation2.getAttentionAllId().contains(userId)) {
            session.setAttribute("isAttention", "true");
        } else {
            session.setAttribute("isAttention", "false");
        }

        //是不是本人
        boolean isSelf = false;

        if (user.getId() == userId) {
            isSelf = true;
        }

        if (isSelf) {
            session.setAttribute("isSelf", "true");
        } else {
            session.setAttribute("isSelf", "false");
        }
        session.setAttribute("articleId", id);

        viewRecordService.addViewRedord(user.getId(), id);

        //添加评论信息
        List<Criteria> list = viewBlogService.getArticleCriteriaById(id);
        session.setAttribute("criterias", list);
        return "display";
    }

    @RequestMapping("getContentToEdit")
    public String getContentToEdit(@RequestParam("id") Integer id, @RequestParam("title") String title,
                                   HttpServletRequest request,
                                   HttpSession session) {
        if (session.getAttribute("articleTypes") == null) {
            User user = (User) session.getAttribute("user");
            List<ArticleType> articleTypes = editService.getAll(user.getId());
            session.setAttribute("articleTypes", articleTypes);
        }

        String content = viewBlogService.getArticleContent(id);
        request.setAttribute("content", content);
        request.setAttribute("title", title);
        return "write";
    }

    /**
     * 点赞
     * @param articleId
     * @param session
     * @return
     */

    @RequestMapping("/praise")
    public String praise(@RequestParam("articleId") Integer articleId,HttpSession session) {
        session.setAttribute("isPraise", "true");
        User user = (User)session.getAttribute("user");
        UserInformation2 userInformation2 = viewBlogService.getUserInformation2ByIdFromCache(user.getId());
        Set<Integer> praiseAllId = userInformation2.getPraiseAllId();
        praiseAllId.add(articleId);
        viewBlogService.updateUserInformation2Cache(userInformation2);
        //让文章点赞数+1
        viewBlogService.updateArticlePraiseNumber(articleId, 1);

        return "display";
    }

    /**
     * 取消点赞
     * @param articleId
     * @param session
     * @return
     */
    @RequestMapping("/noPraise")
    public String noPraise(@RequestParam("articleId") Integer articleId,HttpSession session) {
        session.setAttribute("isPraise", "false");
        User user = (User)session.getAttribute("user");
        UserInformation2 userInformation2 = viewBlogService.getUserInformation2ByIdFromCache(user.getId());
        Set<Integer> praiseAllId = userInformation2.getPraiseAllId();
        praiseAllId.remove(articleId);
        viewBlogService.updateUserInformation2Cache(userInformation2);
        //让文章点赞数+1
        viewBlogService.updateArticlePraiseNumber(articleId, -1);

        return "display";
    }

    /**
     * 差赞
     * @param articleId
     * @param session
     * @return
     */
    @RequestMapping("/negativePraise")
    public String negativePraise(@RequestParam("articleId") Integer articleId,HttpSession session) {
        session.setAttribute("isNegativePraise", "true");
        User user = (User)session.getAttribute("user");
        UserInformation2 userInformation2 = viewBlogService.getUserInformation2ByIdFromCache(user.getId());
        Set<Integer> negativeAllId = userInformation2.getNegativeAllId();
        negativeAllId.add(articleId);
        viewBlogService.updateUserInformation2Cache(userInformation2);
        //让文章点赞数+1
        viewBlogService.updateArticleNegaticePraiseNumber(articleId, 1);

        return "display";
    }

    /**
     * 取消差赞
     * @param articleId
     * @param session
     * @return
     */
    @RequestMapping("/noNegativePraise")
    public String noNegativePraise(@RequestParam("articleId") Integer articleId,HttpSession session) {
        session.setAttribute("isNegativePraise", "false");
        User user = (User)session.getAttribute("user");
        UserInformation2 userInformation2 = viewBlogService.getUserInformation2ByIdFromCache(user.getId());
        Set<Integer> negativeAllId = userInformation2.getNegativeAllId();
        negativeAllId.remove(articleId);
        viewBlogService.updateUserInformation2Cache(userInformation2);
        //让文章点赞数+1
        viewBlogService.updateArticleNegaticePraiseNumber(articleId, -1);

        return "display";
    }

    /**
     * 收藏
     * @param articleId
     * @param session
     * @return
     */
    @RequestMapping("/collect")
    public String collect(@RequestParam("articleId") Integer articleId,HttpSession session) {
        session.setAttribute("isCollect", "true");
        User user = (User)session.getAttribute("user");
        UserInformation2 userInformation2 = viewBlogService.getUserInformation2ByIdFromCache(user.getId());
        Set<Integer> collectAllId = userInformation2.getCollectAllId();
        collectAllId.add(articleId);
        viewBlogService.updateUserInformation2Cache(userInformation2);

        return "display";
    }

    /**
     * 取消收藏
     * @param articleId
     * @param session
     * @return
     */
    @RequestMapping("/noCollect")
    public String noCollect(@RequestParam("articleId") Integer articleId,HttpSession session) {
        session.setAttribute("isCollect", "false");
        User user = (User)session.getAttribute("user");
        UserInformation2 userInformation2 = viewBlogService.getUserInformation2ByIdFromCache(user.getId());
        Set<Integer> collectAllId = userInformation2.getCollectAllId();
        collectAllId.remove(articleId);
        viewBlogService.updateUserInformation2Cache(userInformation2);

        return "display";
    }

    @RequestMapping("/attention")
    public String attention(@RequestParam("articleId") Integer articleId,HttpSession session) {
        session.setAttribute("isAttention", "true");
        User user = (User)session.getAttribute("user");
        UserInformation2 userInformation2 = viewBlogService.getUserInformation2ByIdFromCache(user.getId());
        Set<Integer> attentionAllId = userInformation2.getAttentionAllId();

        //更新用户的关注人数
        //查询文章的拥有者user_id
        int userId = viewBlogService.getArticleUserId(articleId);
        attentionAllId.add(userId);
        viewBlogService.updateUserInformation2Cache(userInformation2);
        viewBlogService.updateUserInformation(user.getId(), userId, 1);

        return "display";
    }

    @RequestMapping("/noAttention")
    public String noAttention(@RequestParam("articleId") Integer articleId,HttpSession session) {
        session.setAttribute("isAttention", "false");
        User user = (User)session.getAttribute("user");
        UserInformation2 userInformation2 = viewBlogService.getUserInformation2ByIdFromCache(user.getId());
        Set<Integer> attentionAllId = userInformation2.getAttentionAllId();
        //更新用户的关注人数
        //查询文章的拥有者user_id
        int userId = viewBlogService.getArticleUserId(articleId);
        attentionAllId.remove(userId);
        viewBlogService.updateUserInformation2Cache(userInformation2);
        viewBlogService.updateUserInformation(user.getId(), userId, -1);

        return "display";
    }

}
