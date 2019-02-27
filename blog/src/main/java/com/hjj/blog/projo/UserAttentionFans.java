package com.hjj.blog.projo;

/**
 * Created by haojunjie on 2019/2/25
 */
public class UserAttentionFans {
    private Integer id;
    private Integer user1Id;
    private Integer user2Id;
    private Integer design;

    public UserAttentionFans() {
    }

    @Override
    public String toString() {
        return "UserAttentionFans{" +
                "id=" + id +
                ", user1Id=" + user1Id +
                ", user2Id=" + user2Id +
                ", design=" + design +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUser1Id() {
        return user1Id;
    }

    public void setUser1Id(Integer user1Id) {
        this.user1Id = user1Id;
    }

    public int getUser2Id() {
        return user2Id;
    }

    public void setUser2Id(Integer user2Id) {
        this.user2Id = user2Id;
    }

    public int getDesign() {
        return design;
    }

    public void setDesign(Integer design) {
        this.design = design;
    }
}
