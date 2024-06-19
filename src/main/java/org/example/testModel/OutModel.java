package org.example.testModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author jfz
 * @Date 2024/5/30 9:01
 * @PackageName:org.example.testModel
 * @ClassName: OutModel
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OutModel {
    //1:单张 ， 2:对子 , 3:三不带 , 4:三带一 , 5:4炸 , 6:王炸, 7:顺子，8:连对 9:出牌有误
    private Integer out;
    private List<String> outCard;
}
