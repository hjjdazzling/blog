package com.hjj.blog.projo;

import java.io.Serializable;

/**
 * @author haojunjie
 * @create 2019-03-08 19:02
 */
public class Collect  {
    private int id;
    private int userId;
    private String articleIdCollect;

    public Collect() {
    }

    @Override
    public String toString() {
        return "Collect{" +
                "id=" + id +
                ", userId=" + userId +
                ", articleIdCollect='" + articleIdCollect + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getArticleIdCollect() {
        return articleIdCollect;
    }

    public void setArticleIdCollect(String articleIdCollect) {
        this.articleIdCollect = articleIdCollect;
    }
}
