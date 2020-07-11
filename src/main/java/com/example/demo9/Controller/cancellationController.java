package com.example.demo9.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

/**
 * 退出用户登录
 */
@Controller
public class cancellationController {
    private static final String error = "error";
    private final static String loginPage = "redirect:/";

    @RequestMapping("/cancellation")
    public String cancellation(HttpServletRequest request) {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            return error;
        }
        session.removeAttribute("user");
        return loginPage;
    }
}
