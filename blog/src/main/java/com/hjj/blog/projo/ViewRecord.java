package com.hjj.blog.projo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;

/**
 * @author haojunjie
 * @create 2019-03-21 12:42
 */
public class ViewRecord {
    private int id;
    private int userId;
    private Date viewTime;
    private Set<Integer> viewRecord;

    public ViewRecord() {
    }

    @Override
    public String toString() {
        return "ViewRecord{" +
                "id=" + id +
                ", userId=" + userId +
                ", viewTime=" + viewTime +
                ", viewRecord=" + viewRecord +
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

    public Date getViewTime() {
        return viewTime;
    }

    public void setViewTime(Date viewTime) {
        this.viewTime = viewTime;
    }

    public Set<Integer> getViewRecord() {
        return viewRecord;
    }

    public void setViewRecord(Set<Integer> viewRecord) {
        this.viewRecord = viewRecord;
    }
}
