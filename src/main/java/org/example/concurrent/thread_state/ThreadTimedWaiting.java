package org.example.concurrent.thread_state;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.TimeUnit;

/**
 * @Author jfz
 * @Date 2024/3/25 10:53
 * @PackageName:org.example.concurrent.thread_state
 * @ClassName: ThreadTimedWaiting
 */
@Data
public class ThreadTimedWaiting implements Runnable {
    @Override
    public void run() {
        while (true) {
            waiting(200);
        }
    }

    public static void waiting(Integer second) {
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}

