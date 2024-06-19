package org.example.concurrent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.BiConsumer;

/**
 * @Author jfz
 * @Date 2024/3/18 11:49
 * @PackageName:org.example.concurrent
 * @ClassName: CompletableFutureThenAccept
 */
public class CompletableFutureThenAccept {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //对单个异步结果进行处理无返回
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("异步任务1执行...");
            return "async";
        });
        CompletableFuture<Void> accept = future.thenAccept(number -> {
            System.out.println(number + "accept执行...");
        });
        System.out.println(accept.get());
        System.out.println(future.get());


        //对多个结果进行处理
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("异步任务2执行...");
            return "async";
        });
        CompletableFuture<Void> both = future.thenAcceptBoth(future1, new BiConsumer<String, String>() {
            @Override
            public void accept(String s, String s2) {
                System.out.println(s + s2);
            }
        });

        //使用runnable,在上一个异步执行完执行
        future1.thenRun(()->{
            System.out.println("async结束现在到我了");
        });

    }

}
