package com.hjj.blog.recommend.service;

import com.github.pagehelper.PageHelper;
import com.hjj.blog.projo.Article;
import com.hjj.blog.projo.UserInformation2;
import com.hjj.blog.projo.ViewRecord;
import com.hjj.blog.recommend.dao.RecommandDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * @author haojunjie
 * @create 2019-03-25 11:18
 */
@Service
@Transactional
public class RecommandService {
    @Autowired
    @Qualifier("viewRecords")
    private Set<Integer> viewRecords;

    @Autowired
    private RecommandDao recommandDao;


    public List<Article> getRecommandArticleByProfessionalType(int userId,int pageNum,int pageSize) {
        //清除上一个用户的数据
        viewRecords.clear();
        //获取用户浏览过的文章记录放入set
        List<ViewRecord> list = recommandDao.getViewRecordByUserId(userId);

        for (int i=0; i<list.size(); i++) {
            int size = list.get(i).getViewRecord().size();
            Set<Integer> viewRecord = list.get(i).getViewRecord();

            for (int  temp : viewRecord) {
                viewRecords.add(temp);
            }

        }
        //使用分页插件
        PageHelper.startPage(pageNum, pageSize);
        return recommandDao.getArticleByProfessionalType(viewRecords);
    }

    public List<Article> getRecommandArticleByAttentionAllId(int userId,int pageNum,int pageSize) {
        List<ViewRecord> list =  recommandDao.getViewRecordByUserId(userId);

        for (int i=0; i<list.size(); i++) {
            int size = list.get(i).getViewRecord().size();
            Set<Integer> viewRecord = list.get(i).getViewRecord();

            for (int  temp : viewRecord) {
                viewRecords.add(temp);
            }

        }
        UserInformation2 userInformation2 = recommandDao.getUserInformation2ByUserId(userId);
        //使用分页插件
        PageHelper.startPage(pageNum, pageSize);
        List<Article> articles =
                recommandDao.getArticleByAttentionIds(userInformation2.getAttentionAllId(),viewRecords);

        return articles;
    }
}