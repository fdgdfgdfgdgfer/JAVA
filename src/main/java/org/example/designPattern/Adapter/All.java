package org.example.designPattern.Adapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/2/20 14:59
 * @PackageName:org.example.designPattern.Adapter
 * @ClassName: All
 */
public interface All {
    DeviceFactory get(String a);
}
