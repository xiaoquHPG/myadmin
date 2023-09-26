package com.quruiqi.myadmin.common.exception;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * @Author Lenovo
 * @Date 2023/9/26 21:52
 **/
public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Class clazz, Object... saveBodyParamsMap) {
        super(EntityNotFoundException.generateMessage(clazz.getSimpleName(),toMap(String.class, String.class, saveBodyParamsMap)));
    }

    private static <K, V> Map<K, V> toMap(Class<K> key, Class<V> value, Object[] paramsMap) {
        if (paramsMap.length % 2 == 1) {
            throw new IllegalArgumentException("非法参数");
        }
        return IntStream.range(0, paramsMap.length / 2).map(i -> i * 2)
                .collect(HashMap::new, (m, i) -> m.put(key.cast(paramsMap[i]), value.cast(paramsMap[i + 1])),
                        Map::putAll);
    }

    private static String generateMessage(String simpleName, Object... saveBodyParamsMap) {
        return StringUtils.capitalize(simpleName) + "不存在" + saveBodyParamsMap;
    }




}
