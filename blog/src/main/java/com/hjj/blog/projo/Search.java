package com.hjj.blog.projo;

/**
 * 不对应表,只用来接受表单的数据
 * @author haojunjie
 * @create 2019-03-15 10:09
 */
public class Search {
    private String title;
    private String username;
    private String articleType;

    public Search() {
    }

    @Override
    public String toString() {
        return "Search{" +
                "title='" + title + '\'' +
                ", username='" + username + '\'' +
                ", articleType='" + articleType + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getArticleType() {
        return articleType;
    }

    public void setArticleType(String articleType) {
        this.articleType = articleType;
    }
}
