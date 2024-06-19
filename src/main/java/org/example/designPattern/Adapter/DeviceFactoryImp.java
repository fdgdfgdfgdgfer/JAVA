package org.example.designPattern.Adapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @Author jfz
 * @Date 2024/2/19 15:27
 * @PackageName:org.example.designPattern.Adapter
 * @ClassName: DeviceFactoryImp
 */
@Service
public class DeviceFactoryImp implements DeviceFactory {

    @Override
    public DeviceAdapter getDevice(String name) {
        if (Objects.equals(name, "ZIGBEE")) {
            return new ZigbeeImp();
        }
        if (Objects.equals(name, "NB")) {
            return new NbImp();
        }
        return null;
    }
}
