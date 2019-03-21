package com.hjj.blog.listener.dao;

import com.hjj.blog.projo.ViewRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author haojunjie
 * @create 2019-03-21 14:23
 */
@Repository
@Mapper
public interface ViewRecordDao {
    public Integer addViewRecord(ViewRecord viewRecord);

    public Integer updateViewRecord(ViewRecord viewRecord);

    /**
     * 查看今天是否有浏览记录
     * @param userId
     * @param start
     * @return
     */
    public Integer selectViewRecord(@Param("userId") int userId, @Param("start") String start);

    /**
     * 查出用户的所有浏览记录id
     * @param userId
     * @return
     */
    public List<Integer> selectViewRecordByUserId(int userId);

    public List<ViewRecord> selectViewRecordsByUserId(int userId);
}
