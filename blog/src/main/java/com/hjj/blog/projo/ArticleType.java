package com.hjj.blog.projo;

import java.io.Serializable;

/**
 * @author haojunjie
 * @create 2019-03-08 19:02
 */
public class ArticleType  {
    private int id;
    private int userId;
    private String type;

    public ArticleType() {
    }

    @Override
    public String toString() {
        return "ArticleType{" +
                "id=" + id +
                ", user_id=" + userId +
                ", type='" + type + '\'' +
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
