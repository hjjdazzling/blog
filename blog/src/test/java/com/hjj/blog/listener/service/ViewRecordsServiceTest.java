package com.hjj.blog.listener.service;

import com.hjj.blog.projo.ViewRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author haojunjie
 * @create 2019-03-21 15:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ViewRecordsServiceTest {
    @Autowired
    ViewRecordService viewRecordService;
    @Test
    public void cacheTest() {
        viewRecordService.cache(1);
    }

}
