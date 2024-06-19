package org.example.designPattern.proxy;

import com.sun.org.apache.bcel.internal.generic.NEW;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Author jfz
 * @Date 2024/3/3 17:42
 * @PackageName:org.example.designPattern.proxy
 * @ClassName: TecharProxy
 */
public class TecharProxy implements Action {
    private final Techar techar = new Techar();
    private final String a = "123";

    public TecharProxy() {

    }

    @Override
    public String action() {
        System.out.println("响铃");
        techar.action();
        System.out.println("下课");
        return "";
    }

    public static void main(String[] args) {
        FutureTask futureTask = new FutureTask<>(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return null;
            }
        });

    }
}
