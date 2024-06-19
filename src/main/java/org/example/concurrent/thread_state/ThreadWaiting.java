package org.example.concurrent.thread_state;

import lombok.*;

/**
 * @Author jfz
 * @Date 2024/3/25 10:55
 * @PackageName:org.example.concurrent.thread_state
 * @ClassName: ThreadWaiting
 */
@Data
public class ThreadWaiting implements Runnable {
    @Override
    public void run() {
        while (true) {
            synchronized (ThreadWaiting.class) {
                try {
                    ThreadWaiting.class.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
