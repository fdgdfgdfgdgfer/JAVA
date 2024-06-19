package org.example.java_base;

import lombok.*;

import javax.print.DocFlavor;
import java.io.Serializable;

/**
 * @Author jfz
 * @Date 2024/3/27 10:32
 * @PackageName:org.example.java_base
 * @ClassName: Parent
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Parent<T> implements Serializable  {
    public String a;

    public void say() {
        System.out.println("Im parent");
    }

    public T get(T t) {
        System.out.println(t);
        return t;
    }

    public <T> T eat(T t) {
        System.out.println(t);
        return t;
    }

}
