package com.hjj.blog.recommend.dao;

import com.hjj.blog.projo.Article;
import com.hjj.blog.projo.UserInformation2;
import com.hjj.blog.projo.ViewRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * @author haojunjie
 * @create 2019-03-25 10:55
 */
@Mapper
@Repository
public interface RecommandDao {
    public List<ViewRecord> getViewRecordByUserId(int userId);

    public List<Article> getArticleByProfessionalType(@Param("viewRecords") Set<Integer> viewRecords);

    public UserInformation2 getUserInformation2ByUserId(int userId);

    public List<Article> getArticleByAttentionIds(@Param("attentionAllId") Set<Integer> attentionAllId,
                                                  @Param("viewRecords") Set<Integer> viewRecords);
}
