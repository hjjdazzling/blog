package com.hjj.blog.projo;

import java.io.Serializable;

/**
 * Created by haojunjie on 2019/2/25
 */
public class ProfessionalType2  {
    private Integer id;
    private Integer professionalType1Id;
    private String name;

    public ProfessionalType2() {
    }

    @Override
    public String toString() {
        return "ProfessionalType2{" +
                "id=" + id +
                ", professionalType1Id=" + professionalType1Id +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProfessionalType1Id() {
        return professionalType1Id;
    }

    public void setProfessionalType1Id(Integer professionalType1Id) {
        this.professionalType1Id = professionalType1Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
