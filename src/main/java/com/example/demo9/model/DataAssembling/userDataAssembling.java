package com.example.demo9.model.DataAssembling;

//import com.example.demo.model.DBConnect.DBApi;
//import com.example.demo.model.valueObject.user;
import com.example.demo9.model.DBConnect.DBConnect.DBApi;
import com.example.demo9.model.valueObject.user;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class userDataAssembling {
    //根据用户id装配user对象
    public user OneUserData(String id) {
        DBApi dbApi = new DBApi();
        try {
            dbApi.connect();
            String sql = "select *from `user` where id='" + id + "';";
            dbApi.PreparedStatement(sql);
            ResultSet rs = dbApi.getResultSet();
            if (rs.next()) {
                user result = new user();
                result.setId(rs.getString("id"));
                result.setName(rs.getString("name"));
                result.setPassword(rs.getString("password"));
                result.setAuthority(rs.getString("authority"));
                dbApi.close();
                return result;
            } else {
                dbApi.close();
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
