package org.example.designPattern.Adapter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.InvocationTargetException;

/**
 * @Author jfz
 * @Date 2024/2/19 14:26
 * @PackageName:org.example.designPattern.Adapter
 * @ClassName: MQAdapter
 */
@Data
@NoArgsConstructor
public class MQAdapter {

    public static CommonModel mqAdapter(String comment) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (null == comment) {
            return null;
        }
        JSONObject jsonObject = JSON.parseObject(comment);
        CommonModel commonModel = new CommonModel();
        for (EventMethodName eventMethodName : EventMethodName.values()) {
            commonModel.getClass().getMethod(eventMethodName.method, String.class)
                    .invoke(commonModel, jsonObject.get(eventMethodName.name));
        }
        return commonModel;
    }

}
