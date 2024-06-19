package org.example.designPattern.piping.cover;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/6/7 9:56
 * @PackageName:org.example.designPattern.factory
 * @ClassName: CoverInput
 */

public interface CoverInput<T, V> {
    public void copy(T t, V v);
}
