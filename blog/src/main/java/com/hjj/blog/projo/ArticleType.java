package com.hjj.blog.projo;

import java.io.Serializable;

/**
 * @author haojunjie
 * @create 2019-03-08 19:02
 */
public class ArticleType  {
    private Integer id;
    private Integer userId;
    private String typeName;

    public ArticleType() {
    }

    @Override
    public String toString() {
        return "ArticleType{" +
                "id=" + id +
                ", user_id=" + userId +
                ", typeName='" + typeName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
