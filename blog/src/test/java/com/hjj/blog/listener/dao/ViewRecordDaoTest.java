package com.hjj.blog.listener.dao;

import com.hjj.blog.projo.ViewRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.text.View;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author haojunjie
 * @create 2019-03-21 14:43
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ViewRecordDaoTest {
    @Autowired
    ViewRecordDao viewRecordDao;

    @Test
    public void addViewRecordTest() {
        ViewRecord viewRecord = new ViewRecord();
        viewRecord.setUserId(1);
        viewRecord.setViewTime(new Date());
        Set<Integer> set = new HashSet<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        viewRecord.setViewRecord(set);

        viewRecordDao.addViewRecord(viewRecord);
    }

    @Test
    public void updateViewRecordTest() {
        ViewRecord viewRecord = new ViewRecord();
        viewRecord.setId(2);
        Set<Integer> set = new HashSet<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(5);
        viewRecord.setViewRecord(set);

        viewRecordDao.updateViewRecord(viewRecord);
    }

    @Test
    public void selectViewRecordTest() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String str = dateTimeFormatter.format(LocalDate.now());
        System.out.println(viewRecordDao.selectViewRecord(1, str));
    }

    @Test
    public void selectViewRecordByUserId() {
        System.out.println(viewRecordDao.selectViewRecordByUserId(1));
    }

    @Test
    public void selectViewRecordsByUserIdTest() {
        System.out.println(viewRecordDao.selectViewRecordsByUserId(1));
    }

}
