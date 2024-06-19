package org.example.designPattern.builderModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/1/26 15:04
 * @PackageName:org.example.designPattern.builderModel
 * @ClassName: MatterAll
 */
public interface MatterAll {

    MatterAll addFloor(Matter floor);

    MatterAll addCeiling(Matter floor);

    MatterAll addCoating(Matter floor);
    String desc();

}
