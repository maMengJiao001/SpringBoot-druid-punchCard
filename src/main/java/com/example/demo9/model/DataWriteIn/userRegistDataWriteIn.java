package com.example.demo9.model.DataWriteIn;


import com.example.demo9.model.DBConnect.DBConnect.DBApi;
import com.example.demo9.model.valueObject.user;

import java.sql.SQLException;

public class userRegistDataWriteIn {
    //写入新注册用户的数据
    public void userRegistDataWriteIn(user user) {
        DBApi dbApi = new DBApi();
        try {
            dbApi.connect();
            String sql = "insert into `user` (`id`, `name`, `password`, `authority`) VALUES ('";
            sql += user.getId();
            sql += "','";
            sql += user.getName();
            sql += "','";
            sql += user.getPassword();
            sql += "','";
            sql += "general";
            sql += "');";
            dbApi.Statement(sql);
            dbApi.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
