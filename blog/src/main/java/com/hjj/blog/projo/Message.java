package com.hjj.blog.projo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author haojunjie
 * @create 2019-03-27 10:22
 */
public class Message {
    private Date time;
    private String content;

    public String formTime() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(time);
    }
    public Message() {
    }

    @Override
    public String toString() {
        return "Message{" +
                "time=" + time +
                ", content='" + content + '\'' +
                '}';
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