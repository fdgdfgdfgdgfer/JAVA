package org.example.designPattern.Adapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/2/19 14:54
 * @PackageName:org.example.designPattern.Adapter
 * @ClassName: Zigbee
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Zigbee {
    private String id;
    private String eventId;
    private String desc;
    private String date;
    private String zig;
    private String asda;
}
