package com.example.demo9.dao.signIn;

//import com.example.demo.model.DataAssembling.signInDataAssembling;
//import com.example.demo.model.DataWriteIn.signInDataUpdate;
//import com.example.demo.model.valueObject.signIn;
//import com.example.demo.model.valueObject.user;

import com.example.demo9.model.DataAssembling.signInDataAssembling;
import com.example.demo9.model.DataWriteIn.signInDataUpdate;
import com.example.demo9.model.valueObject.signIn;
import com.example.demo9.model.valueObject.user;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class sign {
    private List<signIn> signs;

    //返回该用户下所有的打卡信息对象 - 历史记录
    public List<signIn> getSigns(user user) {
        signs = new signInDataAssembling().AllSignIn(user);
        if (signs.isEmpty()) {
            return null;
        }
        return signs;
    }

    //返回今天的打卡信息对象 - 查询今日打卡信息
    public signIn getSign(user user) {
        getSigns(user);
        if (signs.isEmpty()) {
            return null;
        }
        for (signIn s : signs) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            if (s.getDate().equals(df.format(new Date()))) {
                return s;
            }
        }
        return null;
    }

//    更新今日打卡信息
    public void updateToday(user user, signIn sign) {
        if (getSign(user) == null) {
            signInDataUpdate s = new signInDataUpdate();
            s.signInDataWriteIn(user, sign);
        } else {
            signInDataUpdate s = new signInDataUpdate();
            s.signInDataUpdate(user, sign);
        }

    }
}
