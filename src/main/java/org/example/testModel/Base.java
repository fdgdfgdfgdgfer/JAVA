package org.example.testModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author jfz
 * @Date 2024/5/28 17:13
 * @PackageName:org.example.testModel
 * @ClassName: Base
 */

public abstract class Base implements CardBase {
    public CardBase cardBase;

    public Base(CardBase cardBase) {
        this.cardBase = cardBase;
    }

    public void showCard(List<String> p1,List<String> p2,List<String> p3){
        cardBase.showCard(p1,p2,p3);
    }
}
