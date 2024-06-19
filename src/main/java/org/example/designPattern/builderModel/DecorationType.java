package org.example.designPattern.builderModel;

import lombok.*;
import sun.dc.pr.PRError;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author jfz
 * @Date 2024/1/26 14:57
 * @PackageName:org.example.designPattern.builderModel
 * @ClassName: DecorationType
 */
@Data
@NoArgsConstructor
public class DecorationType implements MatterAll {
    private final List<String> list = Collections.synchronizedList(new ArrayList<>());
    private BigDecimal price = BigDecimal.ZERO;
    private StringBuffer desc = new StringBuffer();
    private String style = "";

    public DecorationType(String level) {
        this.style = level;
    }

    @Override
    public MatterAll addFloor(Matter floor) {
        list.add(floor.brand());
        price = price.add(floor.price().multiply(new BigDecimal("100")));
        desc.append(floor.desc()).append("\n");
        return this;
    }

    @Override
    public MatterAll addCeiling(Matter floor) {
        list.add(floor.brand());
        price = price.add(floor.price().multiply(new BigDecimal("100")));
        desc.append(floor.desc()).append("\n");
        return this;
    }

    @Override
    public MatterAll addCoating(Matter floor) {
        list.add(floor.brand());
        price = price.add(floor.price().multiply(new BigDecimal("100")));
        desc.append(floor.desc()).append("\n");
        return this;
    }

    public String desc() {
        StringBuffer buffer = new StringBuffer("材料：");
        String join = String.join(",", list);
        buffer.append(join);
        buffer.append("\n").append("价格：").append(price);
        buffer.append("\n").append("介绍：").append(style).append(":").append(desc);
        return buffer.toString();
    }

}
