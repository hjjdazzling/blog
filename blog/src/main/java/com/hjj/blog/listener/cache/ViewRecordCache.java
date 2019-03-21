package com.hjj.blog.listener.cache;

import com.hjj.blog.projo.ViewRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author haojunjie
 * @create 2019-03-21 14:04
 */
@Repository
public class ViewRecordCache {
    @Autowired
    private RedisTemplate<String, Map<Integer, ViewRecord>> viewRecordredisTemplate;

    @Autowired
    private RedisTemplate<String, Integer> viewRecordUserIdredisTemplate;

    public void cacheViewRecord(List<ViewRecord> viewRecord) {
        for (int i=0; i<viewRecord.size(); i++) {
            viewRecordredisTemplate.opsForHash().put("view_record", viewRecord.get(i).getId(), viewRecord.get(i));
        }
    }


    public void cacheUserViewRecordId(int userId,List<Integer> list) {

        for (int i=0; i<list.size(); i++) {
            viewRecordUserIdredisTemplate.opsForList().rightPush("view_record" + userId, list.get(i));
        }
    }

    public int getMaxCacheUserViewRecordId(int userId) {
        List<Integer> list = viewRecordUserIdredisTemplate.opsForList().range("view_record" + userId, 0, -1);
        int max = 0;

        for (int i=0; i<list.size(); i++) {
            if(list.get(i) > list.get(max)) {
                max = i;
            }
        }

        return list.get(max);
    }

    public void deleteCache(int userId) {
        viewRecordredisTemplate.delete("view_record");
        viewRecordUserIdredisTemplate.delete("view_record" + userId);
    }

    public ViewRecord getViewRecordById(int id) {
        return (ViewRecord)viewRecordredisTemplate.opsForHash().get("view_record", id);
    }

    public void updateCache(int id, ViewRecord viewRecord) {
        viewRecordredisTemplate.opsForHash().put("view_record", id, viewRecord);
    }
}
