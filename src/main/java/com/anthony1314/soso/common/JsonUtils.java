package com.anthony1314.soso.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/**
 * @program: soso
 * @Description: 自定义响应结构, 转换类
 * @author: anthony1314
 * @create: 2019-11-22 17:13
 **/

public class JsonUtils {

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();


    /**
     *
     *
     * @description: 将对象转换成json字符串。
     * @param Object
     * @return: String
     * @author: anthony1314
     * @time: 2019/11/22 17:13
     */
    public static String objectToJson(Object data) {
        try {
            String string = MAPPER.writeValueAsString(data);
            return string;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     *
     *
     * @description:   将json数据转换成pojo对象list
     * @param String
     * @param Class<T>
     * @return: <T>
     * @author: anthony1314
     * @time: 2019/11/23 14:06
     */  
    public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
        try {
            T t = MAPPER.readValue(jsonData, beanType);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     *
     * @description: 将json数据转换成pojo对象list
     * @param String
     * @param Class<T>
     * @return: <T>List<T>
     * @author: anthony1314
     * @time: 2019/11/24 12:10
     */  
    public static <T>List<T> jsonToList(String jsonData, Class<T> beanType) {
        JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
        try {
            List<T> list = MAPPER.readValue(jsonData, javaType);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
