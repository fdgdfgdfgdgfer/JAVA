package org.example.java_base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/3/27 10:33
 * @PackageName:org.example.java_base
 * @ClassName: Child
 */
@Data
@NoArgsConstructor
public class Child extends Parent {

    @Override
    public void say() {
        System.out.println("im child");
    }
}
