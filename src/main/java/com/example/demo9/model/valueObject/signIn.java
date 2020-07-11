package com.example.demo9.model.valueObject;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class signIn {
    String id;
    String date;//打卡日期
    String firstStartTime;//第一次开始学习时间
    String morningEndTime;//早上结束时间
    String exerciseTime;//锻炼时间
    String ExerciseBackTime;//结束锻炼返回时间
    String nightStartTime;//晚上开始学习时间
    String EndTime;//结束时间
    String totalEffectiveTime;//总有效学习时间
    String mathEffectiveTime;//数学有效学习时间
    String englishEffectiveTime;//英语有效学习时间
    String remarks;//总结

}
