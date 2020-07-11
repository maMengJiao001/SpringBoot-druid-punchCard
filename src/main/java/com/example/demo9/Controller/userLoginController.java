package com.example.demo9.Controller;

//import com.example.demo.dao.login.userLogin;
//import com.example.demo.dao.signIn.sign;
//import com.example.demo.model.valueObject.authority;
//import com.example.demo.model.valueObject.user;
import com.example.demo9.dao.login.userLogin;
import com.example.demo9.dao.signIn.sign;
import com.example.demo9.model.valueObject.authority;
import com.example.demo9.model.valueObject.user;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

@Controller
public class userLoginController {
    private static final String error = "error";
    private final static String loginPage = "index";
    private final static String userAccess = "redirect:/userFunctionSelect";
    private final static String adminAccess = "adminPage";
    private final static String userPage = "userFunctionSelect";

    @RequestMapping("/")
    public String loginPage(HttpServletRequest request) {
        if (request.getSession().getAttribute("registState") != null) {
            request.setAttribute("registState", request.getSession().getAttribute("registState"));
            request.getSession().removeAttribute("registState");
        }
        return loginPage;
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request, @RequestParam("userId") String userId, @RequestParam("password") String password) {
        userLogin UserLogin = new userLogin();
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (UserLogin.ifAccess(userId.trim(), password.trim())) {

            if (UserLogin.getAuthority().equals(authority.general.toString())) {
                request.getSession().setAttribute("user", UserLogin.getUser());
                return userAccess;
            } else if (UserLogin.getAuthority().equals(authority.admin.toString())) {
                request.getSession().setAttribute("user", UserLogin.getUser());
                return adminAccess;
            }
        }
        request.setAttribute("inputError", "用户名或密码错误");
        return loginPage;
    }

    @RequestMapping("/userFunctionSelect")
    public String userFunctionSelect(HttpServletRequest request) {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            return error;
        }
        sign s = new sign();
        if (s.getSign((user) session.getAttribute("user")) == null) {
            request.setAttribute("state", "你瞅啥？麻溜去打卡");
        } else {
            request.setAttribute("state", "不错，打卡成功了！");
        }
        return userPage;
    }

}
