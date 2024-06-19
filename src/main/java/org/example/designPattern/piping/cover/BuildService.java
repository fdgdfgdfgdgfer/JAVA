package org.example.designPattern.piping.cover;

import lombok.Data;
import org.example.designPattern.piping.order.NoticeProcess;
import org.example.designPattern.piping.order.OrderProcess;
import org.example.designPattern.piping.order.PipingBuild;
import org.example.designPattern.piping.order.StockProcess;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author jfz
 * @Date 2024/6/7 10:05
 * @PackageName:org.example.designPattern.factory
 * @ClassName: BuildService
 */
@Data
public class BuildService  extends ContextFactory{
    @Override
    void doBuild(PipingBuild pipingBuild) {
        pipingBuild.buildingPiping(new NoticeProcess());
        pipingBuild.buildingPiping(new OrderProcess());
        pipingBuild.buildingPiping(new StockProcess());
    }
}
