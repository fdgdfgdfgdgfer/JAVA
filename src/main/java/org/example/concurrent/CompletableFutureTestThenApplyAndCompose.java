package org.example.concurrent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * @Author jfz
 * @Date 2024/3/18 11:35
 * @PackageName:org.example.concurrent
 * @ClassName: CompletableFutureTestThenApplyAndCompose
 */
public class CompletableFutureTestThenApplyAndCompose {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> asynctest = CompletableFuture.supplyAsync(() -> {
            System.out.println("asynctest");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {

            }
            return "async";
        }).thenApply(number -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
            }
            return "apply" + number;
        });

        System.out.println(asynctest.get());

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("异步任务执行中");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "asyn结果...";
        }).thenCompose(new Function<String, CompletionStage<String>>() {
            @Override
            public CompletionStage<String> apply(String s) {
                return CompletableFuture.supplyAsync(() -> {
                    return s + "compose结果...";
                });
            }
        });

        System.out.println(future.get());
    }

}
