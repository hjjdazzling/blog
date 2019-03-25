package com.hjj.blog.recommend.dao;

import com.hjj.blog.projo.ViewRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author haojunjie
 * @create 2019-03-25 11:07
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RecommandDaoTest {
    @Autowired
    private RecommandDao recommandDao;

    @Test
    public void getViewRecordByUserIdTest() {
        List<ViewRecord> list =  recommandDao.getViewRecordByUserId(1);
        Set<Integer> set = new HashSet<>();

        for (int i=0; i<list.size(); i++) {
            int size = list.get(i).getViewRecord().size();
            Set<Integer> viewRecord = list.get(i).getViewRecord();

            for (int  temp : viewRecord) {
                set.add(temp);
            }

        }
        System.out.println(set);
    }

    @Test
    public void getUserInformation2ByUserIdTest() {
        System.out.println(recommandDao.getUserInformation2ByUserId(1));
    }

    @Test
    public void getArticleByAttentionIdsTest() {
        List<ViewRecord> list =  recommandDao.getViewRecordByUserId(1);
        Set<Integer> set = new HashSet<>();

        for (int i=0; i<list.size(); i++) {
            int size = list.get(i).getViewRecord().size();
            Set<Integer> viewRecord = list.get(i).getViewRecord();

            for (int  temp : viewRecord) {
                set.add(temp);
            }

        }
        System.out.println(recommandDao.getArticleByAttentionIds(recommandDao.getUserInformation2ByUserId(1).getAttentionAllId(),
                set));
    }
}
