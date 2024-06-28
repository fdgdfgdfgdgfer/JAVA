package org.example.data_handle.big_file_handle;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author jfz
 * @Date 2024/6/17 14:59
 * @PackageName:org.example.data_handle
 * @ClassName: BigFileHandle
 */
public class BigFileHandle {
    public static void main(String[] args) throws IOException, InterruptedException {

        int nums = 5;
        // 计数器
        CyclicBarrier cyclicBarrier = new CyclicBarrier(nums);
        long l = System.currentTimeMillis();
        //处理

            new Thread(() -> {
                HandleModel handle = AdapterHand.getHand(1);
                try {
                    handle.hand();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }).start();

        try {
            cyclicBarrier.await();
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }

        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("主线程"+(currentTimeMillis - l)/1000+"s");
    }
}
