package cn.nanjiabin.common.utils;

import com.alibaba.fastjson.JSON;

public class JSONUtils {
    /**
     * Object对象转换为json
     *
     * @param obj
     * @return
     */
    public static String toJSONString(Object obj) {
        return JSON.toJSONString(obj);
    }

    /**
     * json字符串转换为javabean
     *
     * @param json
     * @param clazz
     * @return
     */
    public static final <T> T parseObject(String json, Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }
}
