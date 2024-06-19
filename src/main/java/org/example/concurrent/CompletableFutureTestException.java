package org.example.concurrent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * @Author jfz
 * @Date 2024/3/18 11:05
 * @PackageName:org.example.concurrent
 * @ClassName: CompletableFuture
 */
public class CompletableFutureTestException {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("有返回的异步...");
           int a= 12 / 0;
           return "test";
        });
        future.whenComplete(new BiConsumer<String, Throwable>() {
            @Override
            public void accept(String s, Throwable throwable) {
                System.out.println(s+"出现异常");
            }
        });
        future.exceptionally(new Function<Throwable, String>() {
            @Override
            public String apply(Throwable throwable) {
                System.out.println("失败"+throwable.getMessage());
                return "执行异常";
            }
        });
        future.get();
    }


}
