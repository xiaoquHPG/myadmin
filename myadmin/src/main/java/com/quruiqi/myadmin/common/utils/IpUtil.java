package com.quruiqi.myadmin.common.utils;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author Lenovo
 * @Date 2023/9/28 9:25
 **/
public class IpUtil {

    public static String getIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (isIp(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (isIp(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (isIp(ip)) {
            ip = request.getRemoteAddr();
        }
        return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
    }

    private static boolean isIp(String ip) {
        return StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip);
    }

}
