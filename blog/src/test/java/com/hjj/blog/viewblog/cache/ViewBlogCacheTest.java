package com.hjj.blog.viewblog.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author haojunjie
 * @create 2019-03-19 15:06
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ViewBlogCacheTest {
    @Autowired
    ViewBlogCache viewBlogCache;

    @Test
    public void getUserInformation2Test() {
        System.out.println(viewBlogCache.getUserInformation2(1));
    }

    @Test
    public void getByIdTest() {
        System.out.println(viewBlogCache.getById(8));
        System.out.println(viewBlogCache.getById(1));
    }

    @Test
    public void getByUserIdTest() {
        System.out.println(viewBlogCache.getByUserId(1).size());
    }
}
