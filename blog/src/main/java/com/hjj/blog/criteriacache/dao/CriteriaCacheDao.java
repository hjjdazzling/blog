package com.hjj.blog.criteriacache.dao;

import com.hjj.blog.projo.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author haojunjie
 * @create 2019-05-15 9:26
 */
@Mapper
@Repository
public interface CriteriaCacheDao {
    public List<Criteria> getCriterias(@Param("articlesId") List<Integer> articlesId);
}
