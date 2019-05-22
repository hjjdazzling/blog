package com.hjj.blog.test;

import java.sql.*;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

/**
 * @author haojunjie
 * @create 2019-05-13 20:52
 */
public class Test {
    @org.junit.Test
    public void test() {
        Instant instant = Instant.now().plusMillis(TimeUnit.HOURS.toMillis(8));

        long timeStamp = instant.getEpochSecond();
        System.out.println(timeStamp);
    }

        @org.junit.Test
        public static void main(String[] args) throws Exception {
            Connection conn = null;
            String sql = "****";
            ResultSet resultSet = null;
            Statement statement = null;
            String url = "jdbc:mysql://localhost:3306/sdesm?"
                    + "user=root&password=111111&useUnicode=true&characterEncoding=UTF8";

            try {
                Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
                conn = DriverManager.getConnection(url);
                statement = conn.createStatement();
                resultSet = statement.executeQuery(sql);// executeUpdate语句会返回一个受影响的行数，如果返回-1就没有成功

                while (resultSet.next()) {
                    System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2));// 入如果返回的是int类型可以用getInt()
                }

            } catch (SQLException e) {
                System.out.println("MySQL操作错误");
                e.printStackTrace();
                conn.rollback();
            } catch (Exception e) {
                e.printStackTrace();
                conn.rollback();
            } finally {
                if(resultSet != null) {
                    resultSet.close();
                }

                if (statement != null) {
                    statement.close();
                }

                if (conn != null) {
                    conn.close();
                }

            }

        }

}
