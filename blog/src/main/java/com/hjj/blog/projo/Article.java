package com.hjj.blog.projo;

import java.io.Serializable;

/**
 * @author haojunjie
 * @create 2019-03-08 19:02
 */
public class Article  {
    private int id;
    private int userId;
    private int articleTypeId;
    private int praiseNumber;
    private int negativeNumber;
    private int viewCount;
    private boolean priacy;
    private String content;

    public Article() {
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", userId=" + userId +
                ", articleTypeId=" + articleTypeId +
                ", praiseNumber=" + praiseNumber +
                ", negativeNumber=" + negativeNumber +
                ", viewCount=" + viewCount +
                ", priacy=" + priacy +
                ", content='" + content + '\'' +
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

    public int getArticleTypeId() {
        return articleTypeId;
    }

    public void setArticleTypeId(int articleTypeId) {
        this.articleTypeId = articleTypeId;
    }

    public int getPraiseNumber() {
        return praiseNumber;
    }

    public void setPraiseNumber(int praiseNumber) {
        this.praiseNumber = praiseNumber;
    }

    public int getNegativeNumber() {
        return negativeNumber;
    }

    public void setNegativeNumber(int negativeNumber) {
        this.negativeNumber = negativeNumber;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public boolean isPriacy() {
        return priacy;
    }

    public void setPriacy(boolean priacy) {
        this.priacy = priacy;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
