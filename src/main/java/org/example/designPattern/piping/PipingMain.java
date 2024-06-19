package org.example.designPattern.piping;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.designPattern.piping.cover.BuildService;
import org.example.designPattern.piping.order.PipingBuild;
import org.example.designPattern.piping.order.ProcessPipingStart;

/**
 * @Author jfz
 * @Date 2024/6/7 15:42
 * @PackageName:org.example.designPattern.piping
 * @ClassName: PipingMain
 */

public class PipingMain {
    public static void main(String[] args) {
        ProcessPipingStart build = new BuildService().build();
        build.start();
    }
}
