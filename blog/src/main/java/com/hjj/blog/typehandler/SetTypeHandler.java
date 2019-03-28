package com.hjj.blog.typehandler;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.hjj.blog.projo.Message;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author haojunjie
 * @create 2019-03-14 11:19
 */
public class SetTypeHandler implements TypeHandler<Set<Integer>> {

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, Set<Integer> integers, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, JSONObject.toJSONString(integers));
    }

    @Override
    public Set<Integer> getResult(ResultSet resultSet, String s) throws SQLException {
        Set<Integer> set = new HashSet<>();
        JSONArray jsonObject = JSONArray.parseArray(resultSet.getString(s));
        Object[] obj = jsonObject.toArray();

        for (int j=0; j<obj.length; j++) {
            set.add((Integer) obj[j]);
        }
        return set;
    }

    @Override
    public Set<Integer> getResult(ResultSet resultSet, int i) throws SQLException {
        Set<Integer> set = new HashSet<>();
        JSONArray jsonObject = JSONArray.parseArray(resultSet.getString(i));
        Object[] obj = jsonObject.toArray();

        for (int j=0; j<obj.length; j++) {
            set.add((Integer) obj[j]);
        }
        return set;
    }

    @Override
    public Set<Integer> getResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
