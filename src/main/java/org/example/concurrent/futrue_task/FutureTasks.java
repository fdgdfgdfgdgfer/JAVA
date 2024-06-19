package org.example.concurrent.futrue_task;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/3/25 15:21
 * @PackageName:org.example.concurrent.futrue_task
 * @ClassName: FutureTask
 */
public class FutureTasks {
    public static void main(String[] args) {
        ExecuterTask executerTask = new ExecuterTask<String>();
        Thread aaa = new Thread(new ExecutorService(executerTask, "aaa"));
        aaa.start();
    }
}
