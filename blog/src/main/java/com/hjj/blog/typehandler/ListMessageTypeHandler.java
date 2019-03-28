package com.hjj.blog.typehandler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hjj.blog.projo.Message;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author haojunjie
 * @create 2019-03-27 10:20
 */
public class ListMessageTypeHandler implements TypeHandler<List<Message>> {

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, List<Message> messages, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, JSONObject.toJSONString(messages));
    }

    @Override
    public List<Message> getResult(ResultSet resultSet, String s) throws SQLException {
        List<Message> list = new ArrayList<>();
        JSONArray jsonArray = JSON.parseArray(resultSet.getString(s));

        for (int i=0; i<jsonArray.size(); i++) {
            String str = jsonArray.get(i) + "";
            Message message = JSON.parseObject(str, Message.class);
            list.add(message);
        }
        return list;
    }

    @Override
    public List<Message> getResult(ResultSet resultSet, int i) throws SQLException {
        List<Message> list = new ArrayList<>();
        JSONArray jsonArray = JSON.parseArray(resultSet.getString(i));

        for (int j=0; j<jsonArray.size(); j++) {
            String str = jsonArray.get(j) + "";
            Message message = JSON.parseObject(str, Message.class);
            list.add(message);
        }
        return list;
    }

    @Override
    public List<Message> getResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
