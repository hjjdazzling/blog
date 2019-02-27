package com.hjj.blog.projo;

/**
 * Created by haojunjie on 2019/2/25
 */
public class ProfessionalType1 {
    private Integer id;
    private String name;

    public ProfessionalType1() {
    }

    @Override
    public String toString() {
        return "ProfessionalType1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
