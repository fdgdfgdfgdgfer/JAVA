package org.example.designPattern.piping.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/6/7 14:49
 * @PackageName:org.example.designPattern.piping.order
 * @ClassName: NoticeProcess
 */
public class NoticeProcess extends ProcessModel{
    @Override
    public void action() {
        System.out.println("通知");
    }
}
