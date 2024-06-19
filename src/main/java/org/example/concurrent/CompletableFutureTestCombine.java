package org.example.concurrent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.BiFunction;

/**
 * @Author jfz
 * @Date 2024/3/18 12:02
 * @PackageName:org.example.concurrent
 * @ClassName: CompletableFutureTestCombine
 */
public class CompletableFutureTestCombine {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("async任务一执行....");
            return "async1...";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("async异步二执行");
            return "async2...";
        });

        CompletableFuture<String> future3 = future1.thenCombine(future2, new BiFunction<String, String, String>() {
            @Override
            public String apply(String s, String s2) {
                return s + s2;
            }
        });

        System.out.println(future1.get());
        System.out.println(future2.get());
        System.out.println(future3.get());
    }
}
