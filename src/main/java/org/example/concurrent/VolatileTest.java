package org.example.concurrent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author jfz
 * @Date 2024/4/25 9:08
 * @PackageName:org.example.concurrent
 * @ClassName: VolatileTest
 */

public class VolatileTest {
    public static volatile Integer a = 0;
    static volatile Integer v = 0;

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                test();
            }).start();
        }
    }

    static ReentrantLock reentrantLock = new ReentrantLock();

    public static void test() {
        if (a == 0) {
             a = 1;
            System.out.println(Thread.currentThread().getName()+"：成功");
        }else {
            System.out.println(Thread.currentThread().getName()+"：失败");
        }
    }
}
