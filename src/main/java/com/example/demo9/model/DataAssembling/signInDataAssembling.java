package com.example.demo9.model.DataAssembling;

//import com.example.demo.model.DBConnect.DBApi;
//import com.example.demo.model.valueObject.signIn;
//import com.example.demo.model.valueObject.user;
import com.example.demo9.model.DBConnect.DBConnect.DBApi;
import com.example.demo9.model.valueObject.signIn;
import com.example.demo9.model.valueObject.user;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Component
public class signInDataAssembling {
    //根据用户来装配打卡对象
    public List<signIn> AllSignIn(user user) {
        List<signIn> signIns = new LinkedList<signIn>();
        DBApi dbApi = new DBApi();
        try {
            dbApi.connect();
            String sql = "SELECT * FROM sign_in where owner_id = '";
            sql += user.getId();
            sql += "' order by date DESC;";
            dbApi.PreparedStatement(sql);
            ResultSet rs = dbApi.getResultSet();
            while (rs.next()) {
                signIn sign = signIn.builder().id(rs.getString("id")).date(rs.getString("date")).firstStartTime(rs.getString("first_start_time"))
                        .morningEndTime(rs.getString("morning_end_time")).exerciseTime(rs.getString("exercise_time"))
                        .ExerciseBackTime(rs.getString("exercise_back_time")).nightStartTime(rs.getString("night_start_time"))
                        .EndTime(rs.getString("end_time")).totalEffectiveTime(rs.getString("total_effective_time"))
                        .mathEffectiveTime(rs.getString("math_effective_time")).englishEffectiveTime(rs.getString("english_effective_time"))
                        .remarks(rs.getString("remarks")).build();
                signIns.add(sign);

            }
            dbApi.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return signIns;
    }

}
