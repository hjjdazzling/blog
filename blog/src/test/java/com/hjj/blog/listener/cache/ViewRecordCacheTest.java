package com.hjj.blog.listener.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author haojunjie
 * @create 2019-03-21 15:55
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ViewRecordCacheTest {
    @Autowired
    private  ViewRecordCache viewRecordCache;

    @Test
    public void deleteCacheTest() {
        viewRecordCache.deleteCache(1);
    }

    @Test
    public void getMaxCacheUserViewRecordIdTest() {
        System.out.println(viewRecordCache.getMaxCacheUserViewRecordId(1));
    }

    @Test
    public void getViewRecordByIdTest() {
        System.out.println(viewRecordCache.getViewRecordById(4));
    }
}
