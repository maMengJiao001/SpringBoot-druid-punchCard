package com.example.demo9.dao.login;

//import com.example.demo.model.DataAssembling.userDataAssembling;
import com.example.demo9.model.valueObject.user;
import com.example.demo9.model.DataAssembling.userDataAssembling;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class userLogin {
    private user user;

    //是否可登录
    public boolean ifAccess(String id, String password) {
        user = new userDataAssembling().OneUserData(id);//组装user对象
        if (user == null) {
            return false;
        } else if (user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    public String getAuthority() {
        if (user != null) {
            return user.getAuthority();
        }
        return "userLogin中user 未初始化!";
    }
}
