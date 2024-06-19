package org.example.concurrent.futrue_task;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/3/25 15:15
 * @PackageName:org.example.concurrent.futrue_task
 * @ClassName: CallableService
 */
public interface CallableService<T> {
    T callable(T t);
}
