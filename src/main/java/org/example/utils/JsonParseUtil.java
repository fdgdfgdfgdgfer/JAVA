package org.example.utils;

import com.alibaba.fastjson.JSON;
import com.google.gson.*;
import net.sf.json.JSONObject;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 多层嵌套json数据转换为单层，同时规格化
 **/
public class JsonParseUtil {
    /**
     * 把拍平后的json进行格式化处理，输出标准的json格式
     *
     * @param uglyJSONString
     * @return
     */
    public static Map<String, String> jsonFormatter(String uglyJSONString) {

        Map<String, String> map = new HashMap<>();
        parseJson2Map(map, uglyJSONString, null);

        return map;
    }

    public static void parseJson2Map(Map map, JsonObject jsonObject, String parentKey) {
        for (Map.Entry<String, JsonElement> object : jsonObject.entrySet()) {
            String key = object.getKey();
            JsonElement value = object.getValue();
            String fullkey = (null == parentKey || parentKey.trim().equals("")) ? key : parentKey.trim() + "." + key;
            //判断对象的类型，如果是空类型则安装空类型处理
            if (value.isJsonNull()) {
                map.put(fullkey, null);
                continue;
                //如果是JsonObject对象则递归处理
            } else if (value.isJsonObject()) {
                parseJson2Map(map, value.getAsJsonObject(), fullkey);
                //如果是JsonArray数组则迭代，然后进行递归
            } else if (value.isJsonArray()) {
                JsonArray jsonArray = value.getAsJsonArray();
                Iterator<JsonElement> iterator = jsonArray.iterator();
                while (iterator.hasNext()) {
                    JsonElement jsonElement1 = iterator.next();
                    parseJson2Map(map, jsonElement1.getAsJsonObject(), fullkey);
                }
                continue;
                // 如果是JsonPrimitive对象则获取当中的值,则还需要再次进行判断一下
            } else if (value.isJsonPrimitive()) {
                try {
                    JsonElement element = new JsonParser().parse(value.getAsString());
                    if (element.isJsonNull()) {
                        map.put(fullkey, value.getAsString());
                    } else if (element.isJsonObject()) {
                        parseJson2Map(map, element.getAsJsonObject(), fullkey);
                    } else if (element.isJsonPrimitive()) {
                        JsonPrimitive jsonPrimitive = element.getAsJsonPrimitive();

                        if (jsonPrimitive.isNumber()) {
                            map.put(fullkey, jsonPrimitive.getAsNumber());
                        } else {
                            map.put(fullkey, jsonPrimitive.getAsString());
                        }
                    } else if (element.isJsonArray()) {
                        JsonArray jsonArray = element.getAsJsonArray();
                        Iterator<JsonElement> iterator = jsonArray.iterator();
                        while (iterator.hasNext()) {
                            parseJson2Map(map, iterator.next().getAsJsonObject(), fullkey);
                        }
                    }
                } catch (Exception e) {
                    map.put(fullkey, value.getAsString());
                }
            }
        }
    }

    /**
     * 使用Gson拍平json字符串，即当有多层json嵌套时，可以把多层的json拍平为一层
     *
     * @param map
     * @param json
     * @param parentKey
     */
    public static void parseJson2Map(Map map, String json, String parentKey) {
        JsonElement jsonElement = new JsonParser().parse(json);

        if (jsonElement.isJsonObject()) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            parseJson2Map(map, jsonObject, parentKey);
            //传入的还是一个json数组
        } else if (jsonElement.isJsonArray()) {
            JsonArray jsonArray = jsonElement.getAsJsonArray();
            Iterator<JsonElement> iterator = jsonArray.iterator();
            while (iterator.hasNext()) {
                parseJson2Map(map, iterator.next().getAsJsonObject(), parentKey);
            }
        } else if (jsonElement.isJsonPrimitive()) {
            System.out.println("please check the json format!");
        } else if (jsonElement.isJsonNull()) {

        }
    }

    public static void main(String[] args) {
        String json = "{\"code\":200, \"message\":\"ok\", \"data\":\"{\\\"id\\\":131,\\\"appId\\\":6,\\\"versionCode\\\":6014000}\"}";

        String test = "{\"data\":{\"device\":[{\"eventDesc\":\"2\",\"data\":[{\"paramDesc\":\"\",\"paramName\":\"eventContent\",\"paramValue\":\"{\\\"soaking_state\\\":1}\"},{\"paramDesc\":\"\",\"paramName\":\"IMEI\",\"paramValue\":\"869540069096381\"},{\"paramDesc\":\"\",\"paramName\":\"timestamp\",\"paramValue\":\"1695260854251\"}],\"eventType\":\"2\",\"deviceSn\":\"nb_fbf936433c8645a781c11a3ede1c33b4\"}]},\"time\":1695260854450,\"type\":\"event\"}";
        HashMap<String, String> hashMap = new HashMap<>();
        JsonParseUtil.parseJson2Map(hashMap, test, null);
        Set<String> set = hashMap.keySet();

        List<String> sn = set.stream().filter(a -> a.contains("deviceSn")).map(String::new).collect(Collectors.toList());
        String type = hashMap.get("type");
        System.out.println(type);
    }

}