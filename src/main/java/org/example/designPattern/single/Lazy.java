package org.example.designPattern.single;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/1/26 17:31
 * @PackageName:org.example.designPattern.single
 * @ClassName: Lazy
 */
public class Lazy {
    private static Lazy lazy;

    private Lazy() {
        lazy = new Lazy();
    }

    public static Lazy getIntece() {
        if(lazy != null){
            return  lazy;
        }else {
            return  new Lazy();
        }
    }
}
