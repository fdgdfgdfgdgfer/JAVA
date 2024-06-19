package org.example.designPattern.Adapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/2/19 14:52
 * @PackageName:org.example.designPattern.Adapter
 * @ClassName: XiRaKa
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class XiRaKa {
    private String id;
    private String eventId;
    private String name;
    private String desc;
    private String date;
    private String hi;
    private String gu;
}
