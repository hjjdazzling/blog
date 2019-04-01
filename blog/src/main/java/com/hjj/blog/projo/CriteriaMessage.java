package com.hjj.blog.projo;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author haojunjie
 * @create 2019-03-27 10:03
 */
public class CriteriaMessage {
    private int id;
    private int userId;
    private int fromUserId;
    private boolean isRead;
    private Date time;
    private String content;

    public String formTime() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(time);
    }
    public CriteriaMessage() {
    }

    @Override
    public String toString() {
        return "CriteriaMessage{" +
                "id=" + id +
                ", userId=" + userId +
                ", fromUserId=" + fromUserId +
                ", isRead=" + isRead +
                ", time=" + time +
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

    public int getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(int fromUserId) {
        this.fromUserId = fromUserId;
    }

    public boolean getIsRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
