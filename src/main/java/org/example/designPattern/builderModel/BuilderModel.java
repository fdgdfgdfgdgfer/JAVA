package org.example.designPattern.builderModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.designPattern.builderModel.DecorationType;
import org.example.designPattern.builderModel.ceiling.LevelOne;
import org.example.designPattern.builderModel.ceiling.LevelTwo;
import org.example.designPattern.builderModel.coating.FLSCoating;
import org.example.designPattern.builderModel.coating.LBcosting;
import org.example.designPattern.builderModel.floor.SXFloor;
import org.example.designPattern.builderModel.floor.ShiMuFloor;

/**
 * @Author jfz
 * @Date 2024/1/26 15:17
 * @PackageName:org.example.designPattern.builderModel.floor
 * @ClassName: Builder
 */
@Data
@NoArgsConstructor
public class BuilderModel {

    //现代风格
    public static  String getModern(){
        return new DecorationType("现代风格")
                .addCeiling(new LevelTwo())
                .addCoating(new FLSCoating())
                .addFloor(new ShiMuFloor()).desc();

    }
    //古典风格
    public static  String getClassical(){
        return new DecorationType("古典风格")
                .addCeiling(new LevelOne())
                .addCoating(new LBcosting())
                .addFloor(new SXFloor()).desc();

    }
}
