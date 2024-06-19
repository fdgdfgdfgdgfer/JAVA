package org.example.concurrent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author jfz
 * @Date 2024/3/15 19:33
 * @PackageName:org.example.concurrent
 * @ClassName: CallableTry
 */

public class CallableTry implements Callable<Integer> {


    @Override
    public Integer call() throws Exception {
        TimeUnit.SECONDS.sleep(5);
        System.out.println(2);
        return 1;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableTry callableTry1 = new CallableTry();
        CallableTry callableTry2 = new CallableTry();
        ArrayList<CallableTry> callableTries = new ArrayList<CallableTry>() {
            {
                add(callableTry1);
                add(callableTry2);
            }
        };
        Future<Integer> submit = null;

        List<Integer> result = new ArrayList<Integer>();

        ExecutorService executorService = Executors.newCachedThreadPool();
        long b = System.currentTimeMillis();
        for (CallableTry callableTry : callableTries) {
            submit = executorService.submit(callableTry);
        }
        long e = System.currentTimeMillis()+5;
        System.out.println(e-b);

    }
}
