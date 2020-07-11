package com.example.demo9.Controller;

//import com.example.demo.dao.regist.userRegist;
//import com.example.demo.model.valueObject.user;
import com.example.demo9.dao.regist.userRegist;
import com.example.demo9.model.valueObject.user;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller

public class userRegistController {
    private final static String loginPage = "redirect:/";

    @PostMapping("/userRegist/update")
    public String regist(HttpServletRequest request, @RequestParam("userId") String userId, @RequestParam("userName") String userName, @RequestParam("password") String password) {
        userRegist userRegist = new userRegist();
        user user = new user();
        user.setId(userId.trim());
        user.setName(userName.trim());
        user.setPassword(password.trim());
        if (userRegist.doRegist(user)) {
            request.getSession().setAttribute("registState", "注册成功!");
        } else {
            request.getSession().setAttribute("registState", "用户id已存在");
        }
        return loginPage;
    }
}
