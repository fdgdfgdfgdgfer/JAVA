package org.example.testModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/3/25 8:48
 * @PackageName:org.example.testModel
 * @ClassName: Text
 */
@Data
public class Text implements Runnable {
    public static ThreadLocal<One> ones = new ThreadLocal<>();

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        set();
    }

    private void set() {
        try {
            System.out.println("========");
            System.out.println(Thread.currentThread().getName() + ones.get());
            Thread.sleep(5000);
            ones.remove();
            System.out.println(Thread.currentThread().getName() + ones.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
