package org.example.designPattern.Adapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author jfz
 * @Date 2024/2/20 15:00
 * @PackageName:org.example.designPattern.Adapter
 * @ClassName: Point
 */
@Service
public class Point implements All{
    @Resource
    private ZIGB zigb;
    @Resource
    private NB nb;
    @Override
    public DeviceFactory get(String a) {
        if(a == "ZIG"){
            return zigb;
        }else {
            return nb;
        }
    }
}
