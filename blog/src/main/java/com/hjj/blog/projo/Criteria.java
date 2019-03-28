package com.hjj.blog.projo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author haojunjie
 * @create 2019-03-27 9:58
 */
public class Criteria {
    private int id;
    private int articleId;
    private int userId;
    private Date criteriaTime;
    private List<Message> criteriaArticle = new ArrayList<>();



    public Criteria() {
    }

    @Override
    public String toString() {
        return "Criteria{" +
                "id=" + id +
                ", articleId=" + articleId +
                ", userId=" + userId +
                ", criteriaTime=" + criteriaTime +
                ", criteriaArticle=" + criteriaArticle +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getCriteriaTime() {
        return criteriaTime;
    }

    public void setCriteriaTime(Date criteriaTime) {
        this.criteriaTime = criteriaTime;
    }

    public List<Message> getCriteriaArticle() {
        return criteriaArticle;
    }

    public void setCriteriaArticle(List<Message> criteriaArticle) {
        this.criteriaArticle = criteriaArticle;
    }
}
