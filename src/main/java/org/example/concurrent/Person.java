package org.example.concurrent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author jfz
 * @Date 2024/5/22 15:37
 * @PackageName:org.example.concurrent
 * @ClassName: Person
 */

public class Person {

    private static volatile Boolean loop = true;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                Vidio();
            }).start();
        }

    }


    private static ReentrantLock look = new ReentrantLock();

    static void Vidio() {
        try {
            look.lock();
            if (loop) {
                System.out.println(Thread.currentThread().getName() + "执行业务...");
                loop = false;
            }
            look.unlock();
        } catch (Exception e) {

        }finally {
            look.unlock();
        }
    }

    static class Live implements Runnable {
        @Override
        public void run() {
            System.out.println("我在看直播...");
        }
    }
}
