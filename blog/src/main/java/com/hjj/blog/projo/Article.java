package com.hjj.blog.projo;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;

/**
 * @author haojunjie
 * @create 2019-03-08 19:02
 */
public class Article  {
    private Integer id;
    private Integer userId;
    private Integer articleTypeId;
    @NotBlank(message = "标题不能为空")
    private String title;
    private Integer praiseNumber;
    private Integer negativeNumber;
    private Integer viewCount;
    private boolean priacy;
    private Date date;
    @NotBlank(message = "博客内容不能为空")
    private String content;

    public Article() {
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", userId=" + userId +
                ", articleTypeId=" + articleTypeId +
                ", title='" + title + '\'' +
                ", praiseNumber=" + praiseNumber +
                ", negativeNumber=" + negativeNumber +
                ", viewCount=" + viewCount +
                ", priacy=" + priacy +
                ", date=" + date +
                ", content='" + content + '\'' +
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

    public Integer getArticleTypeId() {
        return articleTypeId;
    }

    public void setArticleTypeId(Integer articleTypeId) {
        this.articleTypeId = articleTypeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPraiseNumber() {
        return praiseNumber;
    }

    public void setPraiseNumber(Integer praiseNumber) {
        this.praiseNumber = praiseNumber;
    }

    public Integer getNegativeNumber() {
        return negativeNumber;
    }

    public void setNegativeNumber(Integer negativeNumber) {
        this.negativeNumber = negativeNumber;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public boolean isPriacy() {
        return priacy;
    }

    public void setPriacy(boolean priacy) {
        this.priacy = priacy;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
