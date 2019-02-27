package com.hjj.blog.projo;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by haojunjie on 2019/2/25
 */
public class ProfessionalType3 {
    private Integer id;
    private Integer professionalType2Id;
    private String name;

    public ProfessionalType3() {
    }

    @Override
    public String toString() {
        return "ProfessionalType3{" +
                "id=" + id +
                ", professionalType2Id=" + professionalType2Id +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProfessionalType2Id() {
        return professionalType2Id;
    }

    public void setProfessionalType2Id(Integer professionalType2Id) {
        this.professionalType2Id = professionalType2Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
