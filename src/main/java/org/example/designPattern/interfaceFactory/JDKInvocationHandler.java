package org.example.designPattern.interfaceFactory;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Data
@NoArgsConstructor
public class JDKInvocationHandler implements InvocationHandler {
    private CacheAdapter cacheAdapter;

    public JDKInvocationHandler(CacheAdapter cacheAdapter) {
        this.cacheAdapter = cacheAdapter;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        return CacheAdapter.class.getMethod(method.getName(), ClassLoaderUtils.getClazzByArgs(args)).invoke(cacheAdapter, args);
    }
}