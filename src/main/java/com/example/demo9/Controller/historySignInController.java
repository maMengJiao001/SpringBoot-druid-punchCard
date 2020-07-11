package com.example.demo9.Controller;
//
//import com.example.demo.dao.signIn.sign;
//import com.example.demo.model.valueObject.user;
import com.example.demo9.dao.signIn.sign;
import com.example.demo9.model.valueObject.user;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

/**
 * 输入用户ID
 * 输出历史打卡记录
 */
@Controller
public class historySignInController {
    private static final String error = "error";
    private static final String nextPage = "historySignIn";

    @RequestMapping("/historySignIn/{userID}")
    public String historySignIn(HttpServletRequest request, @PathVariable String userID) {
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
        user user = new user();
        user.setId(userID);
        request.setAttribute("signIn", sign.getSigns(user));
        return nextPage;
    }

}
