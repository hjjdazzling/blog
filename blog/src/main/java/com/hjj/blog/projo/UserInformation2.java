package com.hjj.blog.projo;

import java.util.Set;

/**
 * @author haojunjie
 * @create 2019-03-14 10:36
 */
public class UserInformation2 {
    private int id;
    private int userId;
    private Set<Integer> praiseAllId;
    private Set<Integer> negativeAllId;
    private Set<Integer> collectAllId;
    private Set<Integer> attentionAllId;

    public UserInformation2() {
    }

    @Override
    public String toString() {
        return "UserInformation2{" +
                "id=" + id +
                ", userId=" + userId +
                ", praiseAllId=" + praiseAllId +
                ", negativeAllId=" + negativeAllId +
                ", collectAllId=" + collectAllId +
                ", attentionAllId=" + attentionAllId +
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

    public Set<Integer> getPraiseAllId() {
        return praiseAllId;
    }

    public void setPraiseAllId(Set<Integer> praiseAllId) {
        this.praiseAllId = praiseAllId;
    }

    public Set<Integer> getNegativeAllId() {
        return negativeAllId;
    }

    public void setNegativeAllId(Set<Integer> negativeAllId) {
        this.negativeAllId = negativeAllId;
    }

    public Set<Integer> getCollectAllId() {
        return collectAllId;
    }

    public void setCollectAllId(Set<Integer> collectAllId) {
        this.collectAllId = collectAllId;
    }

    public Set<Integer> getAttentionAllId() {
        return attentionAllId;
    }

    public void setAttentionAllId(Set<Integer> attentionAllId) {
        this.attentionAllId = attentionAllId;
    }
}
