package org.example.designPattern.piping.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/6/7 14:55
 * @PackageName:org.example.designPattern.piping.order
 * @ClassName: ProcessModel
 */

public abstract class ProcessModel implements ProcessAction {
    private String status = "defual";

    public String getSend() {
        return "common process";
    }

}
