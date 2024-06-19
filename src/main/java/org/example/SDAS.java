package org.example;

import com.github.kevinsawicki.http.HttpRequest;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @Author jfz
 * @Date 2024/3/19 18:40
 * @PackageName:org.example
 * @ClassName: SDAS
 */
public class SDAS {
    public final static Integer core = 20;
    public final static Integer all = 40;
    public final static Integer keep = 60;
    public final static Integer task = 2000;
    static AtomicInteger i = new AtomicInteger(0);
    static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(core, all, keep
            , TimeUnit.SECONDS, new LinkedBlockingQueue<>(task),(t,e)->t.run());


    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        ArrayList<String> number = new ArrayList<>();
        for (int i = 0; i < 2040; i++) {
            number.add(i + "");
        }
        //对未打卡人数进行切片，保证并发大的时候效率也能稳定
        if (CollectionUtils.isEmpty(number)) {
            return;
        }
        // 当拥塞队列满了，避免主线程执行剩余任务造成阻塞进行切片，设置线程池最大执行任务片数2022
        int size = number.size();
        //最大任务数 = 线程池队列+总线程数
        int maxTask = task + all;
        //任务超出可以处理的范围 线程池队列+总线程数 分片
        if (size > maxTask) {
            int group = number.size() / maxTask+1;
            List<List<String>> partition = Lists.partition(number, group);
            //执行异步任务
            List<CompletableFuture<List<String>>> collect = partition
                    .stream()
                    .map(SDAS::cutAsync)
                    .peek(at -> thenOpen(at))
                    .collect(Collectors.toList());
            CompletableFuture.allOf(collect.toArray(new CompletableFuture[0])).join();
            //执行结果
        } else {
            //任务在可以处理的范围
            List<CompletableFuture<String>> futures = asyncTakDoGetOpenLimit(number);
            CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        }
        long e = System.currentTimeMillis();
        System.out.println((e-l)+"ms");
    }

    private static void thenOpenLimit(CompletableFuture<String> task) {

        task.thenAccept(ap -> {
                submitRemind(ap);
            });

    }

    private static void thenOpen(CompletableFuture<List<String>> opens) {
        opens.thenAccept(open -> {
            try {
                opens.get().forEach(SDAS::submitRemind
                );
            } catch (Exception e) {
                System.out.println("返回异常");
            }

        });
    }

    private static CompletableFuture<List<String>> cutAsync(List<String> nums) {
        return asyncTakDoGetOpen(nums);
    }

    private static CompletableFuture<List<String>> asyncTakDoGetOpen(List<String> nums) {
        return CompletableFuture.supplyAsync(() -> {
            return nums.stream().map(SDAS::getOpenId).collect(Collectors.toList());
        }, threadPoolExecutor);
    }

    private static List<CompletableFuture<String>> asyncTakDoGetOpenLimit(List<String> nums) {
        return nums.stream().map((task) -> {
            return CompletableFuture.supplyAsync(() -> {
                return getOpenId(task);
            }, threadPoolExecutor);
        }).peek(AO -> thenOpenLimit(AO)).collect(Collectors.toList());
    }

    private static String getOpenId(String num) {
        //访人员详情获取openId
        try {
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() + "->openId:" + num + "获取openid完成...");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return num;
    }

    private static void submitRemind(String openIds) {
        //推送
        try {
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() + "->openId:" + openIds + "推送完成...");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取缓存token
     */
    private static String getTokenByRedis() {
        String tokenPossYZJ = "token";
        try {
            Thread.sleep(500);
            System.out.println("token");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return tokenPossYZJ;
    }
}
