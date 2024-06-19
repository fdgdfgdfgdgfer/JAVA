package org.example.java_base.serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;

/**
 * @Author jfz
 * @Date 2024/3/28 17:19
 * @PackageName:org.example.java_base.serializable
 * @ClassName: TestSer
 */

@Builder
public class TestSer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        StudentA studentA = new StudentA();
        studentA.setA("A");
        studentA.setB("B");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(studentA);
        byte[] bytes = byteArrayOutputStream.toByteArray();

        ObjectInputStream inputStream = new ObjectInputStream(new ByteArrayInputStream(bytes));
        StudentA o = (StudentA) inputStream.readObject();
        System.out.println(o);
    }
}
