package com.hjj.blog.criteria.service;

import com.hjj.blog.criteria.dao.CriteriaDao;
import com.hjj.blog.projo.Criteria;
import com.hjj.blog.projo.CriteriaMessage;
import com.hjj.blog.projo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author haojunjie
 * @create 2019-03-27 13:45
 */
@Service
@Transactional
public class CriteriaService {
    @Autowired
    private CriteriaDao criteriaDao;

    public void criteria(Criteria criteria, CriteriaMessage criteriaMessage, User user,
                         int toUserId, boolean refly, int criteriaId) {
        //判断是不是对文章的第一次评论
        Integer id = criteriaDao.selectCriteriaIsExisted(criteria);

        if (!refly) {
            String content = user.getUsername() + "评论:" +criteria.getCriteriaArticle().get(0).getContent();
            criteria.getCriteriaArticle().get(0).setContent(content);
            criteriaDao.insertCriteria(criteria);
            criteriaMessage.setContent(user.getUsername() + "对你的文章做出了评价 " +
                    "<a href = '/viewBlogController/getArticleContent/?id="
                    + criteria.getArticleId() + "'>点击查看</a>");
            criteriaDao.insertCriteriaMessage(criteriaMessage);
        } else {
            //根据toUserId 查出 username
            String userName = criteriaDao.getUserNameById(toUserId);
            //是不是本人
            String msg = user.getUsername() + "回复了" + userName + ":";
            String content = msg + criteria.getCriteriaArticle().get(0).getContent();
            criteria.getCriteriaArticle().get(0).setContent(content);
            Criteria criteria1 = criteriaDao.selectById(criteriaId);

            criteria1.getCriteriaArticle().add(criteria.getCriteriaArticle().get(0));

            criteriaDao.updateCriteria(criteria1);
            criteriaMessage.setContent(user.getUsername() + "对你的评价做出了回复 " +
                    "<a href = '/viewBlogController/getArticleContent/?id="
                    + criteria.getArticleId() + "'>点击查看</a>");
            criteriaDao.insertCriteriaMessage(criteriaMessage);

            //查找文章的作者
            User author  = criteriaDao.selectAuthorByArticleId(criteria.getArticleId());
            criteriaMessage.setUserId(author.getId());
            criteriaMessage.setFromUserId(user.getId());
            criteriaMessage.setContent(user.getUsername() + "对你的文章做出了评价 " +
                    "<a href = '/viewBlogController/getArticleContent/?id="
                    + criteria.getArticleId() + "'>点击查看</a>");
            criteriaDao.insertCriteriaMessage(criteriaMessage);
        }

    }

    public Integer getIdByUserName(String username) {
        return criteriaDao.getIdByUserName(username);
    }
}
