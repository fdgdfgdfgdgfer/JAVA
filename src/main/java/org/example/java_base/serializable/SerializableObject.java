package org.example.java_base.serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @Author jfz
 * @Date 2024/3/14 15:52
 * @PackageName:org.example.java_base.serializable
 * @ClassName: SerialicableObject
 */
public class SerializableObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerializableModel serializableModel = new SerializableModel("aaa", "bbb");
        ByteArrayOutputStream byteArrayOutputStream = serializableModel.serializableWay();

        Object serializableModel1 = serializableModel.serializableReverse(byteArrayOutputStream);
        System.out.println(serializableModel1);

        
    }
}
