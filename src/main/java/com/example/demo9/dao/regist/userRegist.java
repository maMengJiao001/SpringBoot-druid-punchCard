package com.example.demo9.dao.regist;

//import com.example.demo.model.DataAssembling.userDataAssembling;
//import com.example.demo.model.DataWriteIn.userRegistDataWriteIn;
//import com.example.demo.model.valueObject.user;

import com.example.demo9.model.DataAssembling.userDataAssembling;
import com.example.demo9.model.DataWriteIn.userRegistDataWriteIn;
import com.example.demo9.model.valueObject.user;

public class userRegist {
    private boolean ifUserExist(user user) {
        userDataAssembling tmp = new userDataAssembling();
        if (tmp.OneUserData(user.getId()) == null) {
            return false;
        }
        return true;
    }

    public boolean doRegist(user user) {
        if (ifUserExist(user)) {
            return false;
        } else {
            userRegistDataWriteIn tmp = new userRegistDataWriteIn();
            tmp.userRegistDataWriteIn(user);
            return true;
        }
    }

}
