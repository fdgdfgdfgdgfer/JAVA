package org.example.concurrent.futrue_task;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @Author jfz
 * @Date 2024/3/25 15:16
 * @PackageName:org.example.concurrent.futrue_task
 * @ClassName: ExecuterTask
 */
public class ExecuterTask<T> implements CallableService<T> {

    @Override
    public T callable(T s) {
        FutureTask<String> stringFutureTask = new FutureTask<>(() -> {
            return "";
        });
        new Thread(stringFutureTask).start();
        Executors.newCachedThreadPool().execute(stringFutureTask);
        System.out.println(s);
        return s;
    }
}
