package org.example.genericity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/1/24 10:06
 * @PackageName:org.example.genericity
 * @ClassName: GenercityInterface
 */
public interface GenercityInterface<T, C> {
    T getDevice(T t, C c);
}
