package org.example.designPattern.builderModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author jfz
 * @Date 2024/1/26 14:32
 * @PackageName:org.example.designPattern.builderModel
 * @ClassName: Matter
 */
public interface Matter {
    //材料零件
    String stuff();

    //品牌
    String brand();

    //价格
    BigDecimal price();

    //介绍
    String desc();
}
