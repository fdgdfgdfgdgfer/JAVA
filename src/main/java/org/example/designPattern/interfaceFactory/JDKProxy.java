package org.example.designPattern.interfaceFactory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Author jfz
 * @Date 2024/1/25 16:25
 * @PackageName:org.example.designPattern.interfaceFactory
 * @ClassName: JDKProxy
 */
@Data
@NoArgsConstructor
public class JDKProxy {
    public static <T> T getProxy(Class<T> interfaceClass, CacheAdapter
            cacheAdapter) throws Exception {
        InvocationHandler handler = new JDKInvocationHandler(cacheAdapter);
        ClassLoader classLoader =
                Thread.currentThread().getContextClassLoader();
        Class<?>[] classes = interfaceClass.getInterfaces();
        return (T) Proxy.newProxyInstance(classLoader, new Class[]{classes[0]},
                handler);
    }
}
