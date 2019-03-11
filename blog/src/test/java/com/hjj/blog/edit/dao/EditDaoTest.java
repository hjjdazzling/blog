package com.hjj.blog.edit.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author haojunjie
 * @create 2019-03-11 8:17
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EditDaoTest {
    @Autowired
    EditDao editDao;

    @Test
    public void getAllTest() {
        System.out.println(editDao.getAll(1));
    }
}
