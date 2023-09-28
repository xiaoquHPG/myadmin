package com.quruiqi.myadmin.common.utils;

import org.springframework.data.domain.Page;

import java.util.*;

/**
 * @Author Lenovo
 * @Date 2023/9/28 9:25
 **/
public class PageUtil {

    public static List toPage(int page, int size, List list) {
        int fromIndex = page * size;
        int toIndex = page * size + size;

        if (fromIndex > list.size()) {
            return Collections.emptyList();
        }else if (toIndex >= list.size()) {
            return list.subList(fromIndex, list.size());
        }
        return list.subList(fromIndex, toIndex);
    }

    /**
     * Page 数据处理，预防redis反序列化报错
     * @param page
     * @return
     */
    public static Map toPage(Page page) {
        Map map = new HashMap();

        map.put("content",page.getContent());
        map.put("totalElements",page.getTotalElements());

        return map;
    }

}
