package com.hjj.blog.projo;

import java.util.Date;

/**
 * Created by haojunjie on 2019/2/25
 */
public class UserInformation {
    private Integer id;
    private Integer user_id;
    private Integer professionalType3Id;
    private String realName;
    private Date birth;
    private String phone;
    private String email;
    private Integer attentionNumber;
    private Integer fansNumber;
    private String description;

    public UserInformation() {
    }

    @Override
    public String toString() {
        return "UserInformation{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", professionalType3Id=" + professionalType3Id +
                ", realName='" + realName + '\'' +
                ", birth=" + birth +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", attentionNumber=" + attentionNumber +
                ", fansNumber=" + fansNumber +
                ", description='" + description + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public int getProfessionalType3Id() {
        return professionalType3Id;
    }

    public void setProfessionalType3Id(Integer professionalType3Id) {
        this.professionalType3Id = professionalType3Id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAttentionNumber() {
        return attentionNumber;
    }

    public void setAttentionNumber(Integer attentionNumber) {
        this.attentionNumber = attentionNumber;
    }

    public int getFansNumber() {
        return fansNumber;
    }

    public void setFansNumber(Integer fansNumber) {
        this.fansNumber = fansNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}