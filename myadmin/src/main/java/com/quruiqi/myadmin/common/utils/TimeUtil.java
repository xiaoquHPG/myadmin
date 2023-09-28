package com.quruiqi.myadmin.common.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * @Author Lenovo
 * @Date 2023/9/28 9:25
 **/
public class TimeUtil {

    public static String getWeekDay() {
        String[] weekDays = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        int day = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        return day < 0 ? weekDays[0] : weekDays[day];
    }

}
