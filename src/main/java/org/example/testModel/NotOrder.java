package org.example.testModel;

import java.util.List;

/**
 * @Author jfz
 * @Date 2024/5/28 17:26
 * @PackageName:org.example.testModel
 * @ClassName: NotOrder
 */
public class NotOrder extends Base {


    public NotOrder(CardBase cardBase) {
        super(cardBase);
    }

    public void showCard(List<String> p1,List<String> p2,List<String> p3) {
        super.showCard(p1,p2,p3);
    }
}
