package org.example.java_base;


import org.example.java_base.Parent;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author jfz
 * @Date 2024/3/27 10:33
 * @PackageName:org.example.java_base
 * @ClassName: Test
 */

public class Test {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //获取类
        Class<Reflect> reflectClass = Reflect.class;
        Class<?> forName = Class.forName("org.example.java_base.Reflect");
        System.out.println("反射类：" + reflectClass);
        System.out.println("反射类：" + forName);
        //获取类构造器并构造
        Constructor<Reflect> constructor = reflectClass.getConstructor(String.class, String.class);
        Reflect reflect = constructor.newInstance("a", "b");
        System.out.println("构造器" + reflect);
        //直接实例化
        Reflect reflect1 = reflectClass.newInstance();
        reflect1.setA("c");
        reflect1.setB("d");
        System.out.println("直接实例化：" + reflect1);
        //获取字段


        Class<Reflect> aClass = Reflect.class;
        Reflect reflect2 = aClass.newInstance();
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if(field.getName().equals("a")){
                field.set(reflect2,"m");
            }
            if(field.getName().equals("b")){
                field.set(reflect2,"n");
            }
        }
        System.out.println(reflect2);
        Method declaredMethod = aClass.getDeclaredMethod("setB", String.class);
        Object b = declaredMethod.invoke(reflect2, "b");
        System.out.println(b);
    }
}
