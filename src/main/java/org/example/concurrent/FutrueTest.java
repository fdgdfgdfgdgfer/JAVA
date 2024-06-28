package org.example.concurrent;

import com.sun.org.apache.xpath.internal.functions.FuncTrue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.omg.CORBA.TIMEOUT;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author jfz
 * @Date 2024/4/25 13:45
 * @PackageName:org.example.concurrent
 * @ClassName: FutrueTest
 */

public class FutrueTest {

    public static volatile Boolean a = true;

    public static void main(String[] args) throws ExecutionException, InterruptedException {


    }

    public static String say() {
        if (a) {
            a = false;
        }

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName());
        return Thread.currentThread().getName();
    }

}
