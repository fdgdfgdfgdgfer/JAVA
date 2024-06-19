package org.example.java_base.serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;

/**
 * @Author jfz
 * @Date 2024/3/14 15:53
 * @PackageName:org.example.java_base.serializable
 * @ClassName: SerialicableModel
 */
@Data
@NoArgsConstructor
public class SerializableModel implements Serializable {
    public String name;
    public String password;

    public SerializableModel(String name, String password) {
        this.name = name;
        this.password = password;
    }

    //序列化
    public ByteArrayOutputStream serializableWay() throws IOException {
        Serializable serializableModel = null;

        //序列化
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(serializableModel);
        return byteArrayOutputStream;
    }

    //反序列化s
    public Object serializableReverse(ByteArrayOutputStream byteArrayOutputStream) throws IOException, ClassNotFoundException {
        byte[] bytes = byteArrayOutputStream.toByteArray();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Object o = objectInputStream.readObject();
      return o;
    }
}
