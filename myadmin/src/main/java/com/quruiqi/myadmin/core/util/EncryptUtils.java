package com.quruiqi.myadmin.core.util;

import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

/**
 * @Author Lenovo
 * @Date 2023/9/28 15:00
 **/
public class EncryptUtils {

    /**
     * md5加密
     * @param password
     * @return
     */
    public static String encryptPassword(String password) {
        return DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
    }

}
