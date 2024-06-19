package org.example.designPattern.Adapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Author jfz
 * @Date 2024/2/20 14:52
 * @PackageName:org.example.designPattern.Adapter
 * @ClassName: SADAi
 */
@Service
public class SADAi implements DeviceFactory {
    @Override
    public DeviceAdapter getDevice(String name) {
        return null;
    }
}
