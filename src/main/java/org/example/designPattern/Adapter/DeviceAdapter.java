package org.example.designPattern.Adapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/2/19 15:23
 * @PackageName:org.example.designPattern.Adapter
 * @ClassName: DeviceAdapter
 */
public interface DeviceAdapter {
    void setEvent(String date);
}
