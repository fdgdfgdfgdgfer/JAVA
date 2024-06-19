package org.example.concurrent.futrue_task;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/3/25 15:18
 * @PackageName:org.example.concurrent.futrue_task
 * @ClassName: ExecutorService
 */
public class ExecutorService implements Runnable {
    private ExecuterTask executerTask;
    private String a;

    public ExecutorService(ExecuterTask executerTask, String a) {
        this.executerTask = executerTask;
        this.a = a;
    }

    @Override
    public void run() {
        executerTask.callable(a);
    }
}
