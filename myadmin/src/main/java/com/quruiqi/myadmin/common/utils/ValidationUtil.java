package com.quruiqi.myadmin.common.utils;

import com.quruiqi.myadmin.common.exception.BadRequestException;

import java.util.Optional;

/**
 * @Author Lenovo
 * @Date 2023/9/28 9:25
 **/
public class ValidationUtil {

    /**
     * 验证是否为空
     * @param optional
     * @param entity
     * @param parameter
     * @param value
     */
    public static void isNull(Optional optional, String entity, String parameter, Object value) {
        if (!optional.isPresent()) {
            String msg = entity + "不存在" + "{" + parameter + ":" + value.toString() + "}";
            throw new BadRequestException(msg);
        }
    }

    /**
     * 验证是否为邮箱
     * @param string
     * @return
     */
    public static boolean isEmail(String string) {
        if (string == null){
            return false;
        }
        String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        return string.matches(regEx1);
    }

}
