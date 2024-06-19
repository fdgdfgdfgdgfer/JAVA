package org.example.designPattern.Adapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/2/19 15:41
 * @PackageName:org.example.designPattern.Adapter
 * @ClassName: ZigbeeEventAdapter
 */
@Data
@NoArgsConstructor
public class ZigbeeEventAdapter implements EventAdapter{
    @Override
    public void setEvent(String event) {
        //zigbee业务
    }
}
