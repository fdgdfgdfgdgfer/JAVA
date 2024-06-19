package org.example.designPattern.piping.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/6/7 15:04
 * @PackageName:org.example.designPattern.piping.order
 * @ClassName: PipingNode
 */
@Data

public class PipingNode {
    private ProcessAction processAction;
    private PipingNode next;

    public void exec(){
        processAction.action();
        if(next != null){
            next.exec();
        }
    }

}
