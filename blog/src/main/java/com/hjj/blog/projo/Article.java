package com.hjj.blog.projo;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

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
    private Date updateTime;
    @NotBlank(message = "博客内容不能为空")
    private String content;

    public Article() {
    }

    public String formTime() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(updateTime);
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
                ", date=" + updateTime +
                ", content='" + content + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return priacy == article.priacy &&
                Objects.equals(id, article.id) &&
                Objects.equals(userId, article.userId) &&
                Objects.equals(articleTypeId, article.articleTypeId) &&
                Objects.equals(title, article.title) &&
                Objects.equals(praiseNumber, article.praiseNumber) &&
                Objects.equals(negativeNumber, article.negativeNumber) &&
                Objects.equals(viewCount, article.viewCount) &&
                Objects.equals(updateTime, article.updateTime) &&
                Objects.equals(content, article.content);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userId, articleTypeId, title, praiseNumber, negativeNumber, viewCount, priacy, updateTime, content);
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
