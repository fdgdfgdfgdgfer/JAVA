package org.example.redission;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Author jfz
 * @Date 2024/3/12 17:00
 * @PackageName:org.example.redission
 * @ClassName: OrderController
 */

public class OrderController {

    public static String test(String uid) {
        boolean acquire = DistributedRedisLock.acquire(uid);
        if (!acquire) {
            return "等待";
        }
        System.out.println("1111");
        DistributedRedisLock.release(uid);
        return "111";
    }

    public static void main(String[] args)  {
         CompletableFuture.supplyAsync(() -> {
            return 1;
        });
        CompletableFuture.supplyAsync(() -> {
            return 2;
        });
         CompletableFuture.supplyAsync(() -> {
            int q = 9 / 0;
            return 3;
        });

    }

}
