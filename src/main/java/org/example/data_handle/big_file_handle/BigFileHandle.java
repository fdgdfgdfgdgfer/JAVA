package org.example.data_handle.big_file_handle;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;

/**
 * @Author jfz
 * @Date 2024/6/17 14:59
 * @PackageName:org.example.data_handle
 * @ClassName: BigFileHandle
 */
public class BigFileHandle {
    public static void main(String[] args) throws IOException, InterruptedException {
        long l = System.currentTimeMillis();
        //处理
        HandleModel handle = AdapterHand.getHand(2);
        handle.model();
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("总耗时"+(currentTimeMillis - l)/1000+"s");
    }
}
