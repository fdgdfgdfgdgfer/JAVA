package org.example.concurrent.timer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

/**
 * @Author jfz
 * @Date 2024/4/30 14:29
 * @PackageName:org.example.concurrent.timer
 * @ClassName: TimerTaskTest
 */

public class TimerTaskTest {

    public static void main(String[] ages) {
        ThreadPoolExecutor tp = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(200), (t, x) -> t.run()
        );
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + "executing one!");
            }
        };

        TimerTask tw = new TimerTask() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + "executing two!");
            }
        };
        //scheduleAtFixedRate
        ScheduledExecutorService ar = Executors.newScheduledThreadPool(2);
        ar.scheduleAtFixedRate(task, 3, 1, TimeUnit.SECONDS);
        ar.scheduleAtFixedRate(tw,0,1,TimeUnit.SECONDS);

    }
}
