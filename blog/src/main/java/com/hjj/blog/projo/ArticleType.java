package com.hjj.blog.projo;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author haojunjie
 * @create 2019-03-08 19:02
 */
public class ArticleType {
    private Integer id;
    private Integer userId;
    @NotBlank(message = "类别名不能为空")
    private String typeName;

    public ArticleType() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleType that = (ArticleType) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(typeName, that.typeName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userId, typeName);
    }

    @Override
    public String toString() {
        return "ArticleType{" +
                "id=" + id +
                ", user_id=" + userId +
                ", typeName='" + typeName + '\'' +
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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
