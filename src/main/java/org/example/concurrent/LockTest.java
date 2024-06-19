package org.example.concurrent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author jfz
 * @Date 2024/4/26 13:38
 * @PackageName:org.example.concurrent
 * @ClassName: LockTest
 */

public class LockTest {
    public static Integer num = 10;

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (Integer a : list) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    say(a);
                }
            });
        }

    }

    public static ReentrantLock reentrantLock = new ReentrantLock(true);

    public static void say(int a) {
        reentrantLock.lock();
        try {
            num = a;
            System.out.println(num);
        } finally {
            reentrantLock.unlock();
        }
    }
}
