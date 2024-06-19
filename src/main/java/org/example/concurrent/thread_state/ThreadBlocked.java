package org.example.concurrent.thread_state;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.concurrent.Callable;

/**
 * @Author jfz
 * @Date 2024/3/25 10:58
 * @PackageName:org.example.concurrent.thread_state
 * @ClassName: ThreadBlocked
 */
public class ThreadBlocked implements Runnable  {

    @Override
    public void run() {
        synchronized (ThreadBlocked.class) {
            while (true) {
                ThreadTimedWaiting.waiting(200);
            }
        }
    }

}
