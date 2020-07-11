package com.example.demo9.Controller;

import com.example.demo9.dao.signIn.sign;
import com.example.demo9.model.valueObject.signIn;
import com.example.demo9.model.valueObject.user;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

/**
 * 用户Session信息有效时
 * 进行今日打卡状态返回
 */

@Controller
public class todaySignInController {
    private static final String error = "error";
    private static final String nextPage = "todaySignIn";



    @RequestMapping("/todaySignIn")
    public String todaySignIn(HttpServletRequest request) {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            return error;
        }
        sign sign = new sign();
        signIn signIn = sign.getSign((user) session.getAttribute("user"));
        if (signIn == null) {
            request.setAttribute("isNull", "yes");
        } else {
            request.setAttribute("isNull", "no");
            request.setAttribute("sign", signIn);
        }
        return nextPage;
    }
}
