package org.example.designPattern.Adapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Author jfz
 * @Date 2024/2/20 14:56
 * @PackageName:org.example.designPattern.Adapter
 * @ClassName: ZGim
 */
@Service
public class ZGim implements ZIGB{
    @Override
    public DeviceAdapter getDevice(String name) {
        return null;
    }
}
