package com.example.demo9.model.DataWriteIn;

//import com.example.demo.model.DBConnect.DBApi;
//import com.example.demo.model.valueObject.signIn;
//import com.example.demo.model.valueObject.user;
import com.example.demo9.model.DBConnect.DBConnect.DBApi;
import com.example.demo9.model.valueObject.signIn;
import com.example.demo9.model.valueObject.user;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class signInDataUpdate {
    public void signInDataWriteIn(user user, signIn sign) {
        DBApi dbApi = new DBApi();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        try {
            dbApi.connect();
            String sql = "INSERT INTO `sign_in` (`owner_id`, `date`, `first_start_time`, `morning_end_time`, `exercise_time`, `exercise_back_time`, `night_start_time`, `end_time`, `total_effective_time`, `math_effective_time`, `english_effective_time`, `remarks`) VALUES ('";
            sql += user.getId();
            sql += "','";
            sql += df.format(new Date());
            sql += "','";
            if (sign.getFirstStartTime() != null && !sign.getFirstStartTime().isEmpty()) {
                sql += sign.getFirstStartTime();
            } else {
                sql += "00:00:00";
            }
            sql += "','";
            if (sign.getMorningEndTime() != null && !sign.getMorningEndTime().isEmpty()) {
                sql += sign.getMorningEndTime();
            } else {
                sql += "00:00:00";
            }
            sql += "','";
            if (sign.getExerciseTime() != null && !sign.getExerciseTime().isEmpty()) {
                sql += sign.getExerciseTime();
            } else {
                sql += "00:00:00";
            }
            sql += "','";
            if (sign.getExerciseBackTime() != null && !sign.getExerciseBackTime().isEmpty()) {
                sql += sign.getExerciseBackTime();
            } else {
                sql += "00:00:00";
            }
            sql += "','";
            if (sign.getNightStartTime() != null && !sign.getNightStartTime().isEmpty()) {
                sql += sign.getNightStartTime();
            } else {
                sql += "00:00:00";
            }
            sql += "','";
            if (sign.getEndTime() != null && !sign.getEndTime().isEmpty()) {
                sql += sign.getEndTime();
            } else {
                sql += "00:00:00";
            }
            sql += "','";
            if (sign.getTotalEffectiveTime() != null && !sign.getTotalEffectiveTime().isEmpty()) {
                sql += sign.getTotalEffectiveTime();
            } else {
                sql += "0";
            }
            sql += "','";
            if (sign.getMathEffectiveTime() != null && !sign.getMathEffectiveTime().isEmpty()) {
                sql += sign.getMathEffectiveTime();
            } else {
                sql += "0";
            }
            sql += "','";
            if (sign.getEnglishEffectiveTime() != null && !sign.getEnglishEffectiveTime().isEmpty()) {
                sql += sign.getEnglishEffectiveTime();
            } else {
                sql += "0";
            }
            sql += "','";
            if (sign.getRemarks() != null && !sign.getRemarks().isEmpty()) {
                sql += sign.getRemarks();
            } else {
                sql += "0";
            }
            sql += "');";
            System.out.println(sql);
            dbApi.Statement(sql);
            dbApi.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void signInDataUpdate(user user, signIn sign) {
        DBApi dbApi = new DBApi();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        int flag = 0;
        try {
            String sql = "UPDATE `sign_in` SET ";
            if (sign.getFirstStartTime() != null && !sign.getFirstStartTime().isEmpty()) {
                flag++;
                sql += "`first_start_time` = '";
                sql += sign.getFirstStartTime();
            }

            if (sign.getMorningEndTime() != null && !sign.getMorningEndTime().isEmpty()) {
                flag++;
                sql += "',`morning_end_time` = '";
                sql += sign.getMorningEndTime();
            }
            if (sign.getExerciseTime() != null && !sign.getExerciseTime().isEmpty()) {
                flag++;
                sql += "',`exercise_time` = '";
                sql += sign.getExerciseTime();
            }
            if (sign.getExerciseBackTime() != null && !sign.getExerciseBackTime().isEmpty()) {
                flag++;
                sql += "',`exercise_back_time` = '";
                sql += sign.getExerciseBackTime();
            }
            if (sign.getNightStartTime() != null && !sign.getNightStartTime().isEmpty()) {
                flag++;
                sql += "',`night_start_time` = '";
                sql += sign.getNightStartTime();
            }
            if (sign.getEndTime() != null && !sign.getEndTime().isEmpty()) {
                flag++;
                sql += "',`end_time` = '";
                sql += sign.getEndTime();
            }
            if (sign.getTotalEffectiveTime() != null && !sign.getTotalEffectiveTime().isEmpty()) {
                flag++;
                sql += "',`total_effective_time` = '";
                sql += sign.getTotalEffectiveTime();
            }
            if (sign.getMathEffectiveTime() != null && !sign.getMathEffectiveTime().isEmpty()) {
                flag++;
                sql += "',`math_effective_time` = '";
                sql += sign.getMathEffectiveTime();
            }
            if (sign.getEnglishEffectiveTime() != null && !sign.getEnglishEffectiveTime().isEmpty()) {
                flag++;
                sql += "',`english_effective_time` = '";
                sql += sign.getEnglishEffectiveTime();
            }
            if (sign.getRemarks() != null && !sign.getRemarks().isEmpty()) {
                flag++;
                sql += "',`remarks` = '";
                sql += sign.getRemarks();
            }
            if (flag == 0) {
                return;
            }

            sql += "' where owner_id = '";
            sql += user.getId();
            sql += "' and date='";
            sql += df.format(new Date());
            sql += "';";
            dbApi.connect();
            dbApi.Statement(sql);
            dbApi.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
