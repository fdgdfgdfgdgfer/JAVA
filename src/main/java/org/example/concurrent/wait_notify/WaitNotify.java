package org.example.concurrent.wait_notify;

import lombok.*;

/**
 * @Author jfz
 * @Date 2024/4/30 16:22
 * @PackageName:org.example.concurrent.wait_notify
 * @ClassName: WaitNotify
 */

public class WaitNotify {
    public static Object lock = new WaitNotify();

    public static void main(String[] arg) throws Exception {

        System.out.println(Thread.currentThread().getName() + "开始");
        Thread a1 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                test();
            }
        });

        Thread a2 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                test();
            }
        });
        Thread a3 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                req();
            }
        });
        a1.start();
        a2.start();
        a3.start();
        while (true) {
            Thread.sleep(2000);
            System.out.println("main: thread-a1" + a1.getState());
            System.out.println("main: thread-a2" + a2.getState());
        }
    }

    public static void test() {
        System.out.println(Thread.currentThread().getName() + "开始");
        try {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getState());
                lock.wait();
                System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getState());
            }
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            synchronized (lock) {
                lock.notifyAll();
            }
        }
        System.out.println(Thread.currentThread().getName() + "结束");
    }

    public static void req() {
        synchronized (lock) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("唤醒线程");
            lock.notifyAll();
        }
    }
}
