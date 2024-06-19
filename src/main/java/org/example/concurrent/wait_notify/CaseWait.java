package org.example.concurrent.wait_notify;

import lombok.*;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author jfz
 * @Date 2024/4/30 17:17
 * @PackageName:org.example.concurrent.wait_notify
 * @ClassName: CaseWait
 */

public class CaseWait {
    public static void main(String[] ags) {
//        ThreadPoolExecutor exe = new ThreadPoolExecutor(
//                1,
//                4,
//                10,
//                TimeUnit.SECONDS,
//                new LinkedBlockingQueue<>(50),
//                (e, x) -> e.run());
        Bus bus = new Bus();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    bus.sayOne(i);
                }
            }
        }).start();

        for (int i = 0; i < 50; i++) {
            bus.sayTwo(i);
        }


    }
}

class Bus {

    public volatile Boolean loop = true;

    @SneakyThrows
    public void sayOne(Integer i) {
        
                synchronized (this) {
                    while (!loop) {
                        this.wait();
                    }
                    for (int j = 0; j < 10; j++) {
                        System.out.println(Thread.currentThread().getName() + ":总" + i + "次，子线程" + j + "次"
                        );
                    }
                    loop = false;
                    this.notifyAll();
                }

    }

    @SneakyThrows
    public void sayTwo(Integer j) {
        synchronized (this) {
            while (loop) {
                this.wait();
            }

            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + ":总50次-第" + j + "次，主线程" + i + "次"
                );
            }
            loop = true;
            this.notifyAll();
        }
    }
}
