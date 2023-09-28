package com.quruiqi.myadmin.common.utils;

/**
 * @Author Lenovo
 * @Date 2023/9/28 13:04
 **/
public class SqlUtil {

    /**
     * 模糊
     * @param col
     * @return
     */
    public static String like(String col) {
        return "%" + col + "%";
    }

}
