package com.hjj.blog.listener.service;

import com.hjj.blog.listener.cache.ViewRecordCache;
import com.hjj.blog.listener.dao.ViewRecordDao;
import com.hjj.blog.projo.ViewRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author haojunjie
 * @create 2019-03-21 14:27
 */
@Service
public class ViewRecordService {
    @Autowired
    private ViewRecordDao viewRecordDao;

    @Autowired
    private ViewRecordCache viewRecordCache;

    @Autowired
    private ViewRecord viewRecord;

    @Autowired
    private Set<Integer> set;

    //把mysql用户的访问记录放入redis
    public void  cache(int userId) {


        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = dateTimeFormatter.format(LocalDate.now());
        Integer result =  viewRecordDao.selectViewRecord(userId, date);

        if (result == null) {
            viewRecord.setUserId(userId);
            viewRecordDao.addViewRecord(viewRecord);
        }
        List<ViewRecord> viewRecords = viewRecordDao.selectViewRecordsByUserId(userId);
        viewRecordCache.cacheViewRecord(viewRecords);
        //缓存用户的浏览记录id
        viewRecordCache.cacheUserViewRecordId(userId, viewRecordDao.selectViewRecordByUserId(userId));
    }

    //把redis的浏览记录刷新到mysql中,只需要刷新最新的就行
    public void flushCacheAndDeleteCache(int userId) {
        //只更新最新的那次的信息
        int maxId = viewRecordCache.getMaxCacheUserViewRecordId(userId);
        viewRecordDao.updateViewRecord(viewRecordCache.getViewRecordById(maxId));
        viewRecordCache.deleteCache(userId);
    }

    public void addViewRedord(int userId,int articleId) {
        //只更新最新的那次的信息
        int maxId = viewRecordCache.getMaxCacheUserViewRecordId(userId);
        System.out.println(maxId);

        ViewRecord viewRecord = viewRecordCache.getViewRecordById(maxId);
        System.out.println(viewRecord);
        if (viewRecord == null) {
            set.add(articleId);
            viewRecord.setViewRecord(set);
        } else {
            viewRecord.getViewRecord().add(articleId);
        }
        viewRecordCache.updateCache(maxId, viewRecord);
    }

}
