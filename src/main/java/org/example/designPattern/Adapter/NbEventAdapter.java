package org.example.designPattern.Adapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/2/19 15:42
 * @PackageName:org.example.designPattern.Adapter
 * @ClassName: NbEventAdapter
 */
@Data
@NoArgsConstructor
public class NbEventAdapter implements EventAdapter {
    @Override
    public void setEvent(String event) {
        //nb业务
    }
}
