package com.example.demo9.Controller;

//import com.example.demo.dao.signIn.sign;
//import com.example.demo.model.valueObject.signIn;
//import com.example.demo.model.valueObject.user;
import com.example.demo9.dao.signIn.sign;
import com.example.demo9.model.valueObject.signIn;
import com.example.demo9.model.valueObject.user;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

/**
 * 用户Session信息有效时
 * 进行今日打卡信息的更新
 */
@Controller
public class todaySignInUpLoad {
    private static final String error = "error";
    private static final String nextPage = "redirect:/todaySignIn";

    @PostMapping("/todaySignIn/upload")
    public String todaySignInUpLoad(HttpServletRequest request) {
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
        String firstStartTime = (String) request.getParameter("firstStartTime");
        String morningEndTime = (String) request.getParameter("morningEndTime");
        String exerciseTime = (String) request.getParameter("exerciseTime");
        String exerciseBackTime = (String) request.getParameter("exerciseBackTime");
        String nightStartTime = (String) request.getParameter("nightStartTime");
        String endTime = (String) request.getParameter("endTime");
        String totalEffectiveTime = (String) request.getParameter("totalEffectiveTime");
        String mathEffectiveTime = (String) request.getParameter("mathEffectiveTime");
        String englishEffectiveTime = (String) request.getParameter("englishEffectiveTime");
        String remarks = (String) request.getParameter("remarks");
        signIn si = signIn.builder().firstStartTime(firstStartTime).morningEndTime(morningEndTime).exerciseTime(exerciseTime).ExerciseBackTime(exerciseBackTime)
                .nightStartTime(nightStartTime).EndTime(endTime).totalEffectiveTime(totalEffectiveTime).mathEffectiveTime(mathEffectiveTime).englishEffectiveTime(englishEffectiveTime)
                .remarks(remarks).build();
        s.updateToday((user) session.getAttribute("user"), si);
        return nextPage;

    }
}
