package org.example.genericity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/1/24 9:57
 * @PackageName:org.example.genericity
 * @ClassName: GenericityClass
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GenericityClass<T> {
    private T age;

    public <E> String getPl(E e) {
        return "sadadad";
    }

    public static <R> R getHp(R a) {
        return a;
    }
}
