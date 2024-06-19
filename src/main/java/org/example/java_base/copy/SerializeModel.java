package org.example.java_base.copy;

import lombok.*;

import java.io.*;

/**
 * @Author jfz
 * @Date 2024/3/14 15:21
 * @PackageName:org.example.java_base.copy
 * @ClassName: SerializeModel
 */
@Data
public class SerializeModel implements Serializable {
    public String name;
    public SerializePrent prent;

    public SerializeModel clone() {
//        //序列化对象
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
//        objectOutputStream.writeObject(this);
//        //反序列化创建对象
//        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
//        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
//        return (SerializeModel) objectInputStream.readObject();
        // 将对象本身序列化到字节流
        try {


            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(this);

            // 再将字节流通过反序列化方式得到对象副本
            ObjectInputStream objectInputStream =
                    new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            return (SerializeModel) objectInputStream.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
