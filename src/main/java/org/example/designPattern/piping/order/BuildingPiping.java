package org.example.designPattern.piping.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/6/7 15:10
 * @PackageName:org.example.designPattern.piping.order
 * @ClassName: BuildingPiping
 */

public interface BuildingPiping extends ProcessPipingStart {

    void buildingPiping(ProcessAction op);
}


