package org.example.concurrent.thread_state;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/3/25 11:01
 * @PackageName:org.example.concurrent.thread_state
 * @ClassName: TestThreadStatus
 */
public class TestThreadStatus {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        Thread thread3 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        });

        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();
        thread3.join();
        System.out.println("111");
    }
}
