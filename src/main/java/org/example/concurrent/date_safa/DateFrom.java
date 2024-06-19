package org.example.concurrent.date_safa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author jfz
 * @Date 2024/3/25 16:47
 * @PackageName:org.example.concurrent.date_safa
 * @ClassName: DateFrom
 */
public class DateFrom {
    public final static Integer MAX_THREAD = 1000;
    public final static Integer MAX_RUN = 20;
    private static SimpleDateFormat simpleDateFormat = new
            SimpleDateFormat("yyyy-MM-dd");
    private static ThreadLocal<DateFormat> local = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        //final Semaphore semaphore = new Semaphore(THREAD_COUNT);
        //        final CountDownLatch countDownLatch = new CountDownLatch(EXECUTE_COUNT);
        //        ExecutorService executorService = Executors.newCachedThreadPool();
        //        for (int i = 0; i < EXECUTE_COUNT; i++){
        //            executorService.execute(() -> {
        //                try {
        //                    semaphore.acquire();
        //                    try {
        //                        simpleDateFormat.parse("2020-01-01");
        //                    } catch (ParseException e) {
        //                        System.out.println("线程：" +
        //                                Thread.currentThread().getName() + " 格式化日期失败");
        //                        e.printStackTrace();
        //                        System.exit(1);
        //                    }catch (NumberFormatException e){
        //                        System.out.println("线程：" +
        //                                Thread.currentThread().getName() + " 格式化日期失败");
        //                        e.printStackTrace();
        //                        System.exit(1);
        //                    }
        //                    semaphore.release();
        //                } catch (InterruptedException e) {
        //                    System.out.println("信号量发生错误");
        //                    e.printStackTrace();
        //                    System.exit(1);
        //                }
        //                countDownLatch.countDown();
        //            });
        //        }
        //        countDownLatch.await();
        //        executorService.shutdown();
        //        System.out.println("所有线程格式化日期成功");
        //        }
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(2000));
        for (int i = 0; i < MAX_THREAD; i++) {
            threadPoolExecutor.execute((() -> {
                local.set(new SimpleDateFormat("yyyy-MM-dd"));
                try {
                    try {
                        DateFormat dateFormats = local.get();
                        dateFormats.parse("2023-01-01");
                        System.out.println(Thread.currentThread().getName());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

                try {
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }));
            boolean awaitTermination = threadPoolExecutor.awaitTermination(2, TimeUnit.SECONDS);
            if (awaitTermination) {
                System.out.println("超时了");
            }
        }
    }
}
