package org.example.testModel;

import com.sun.org.apache.bcel.internal.generic.NEW;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author jfz
 * @Date 2024/5/28 16:50
 * @PackageName:org.example.testModel
 * @ClassName: CardBaseImpl
 */
public class CardBaseImpl implements CardBase {
    public static List<String> alls;
    public static Boolean showDown = false;
    public static Boolean show = false;
    public static String blank = "    ";
    public static int computer = 20;
    public static int blankLenth = 21;
    public static String computerOne = "";
    public static String computerTwo = "";
    public static String user = "";


    @Override
    public void showCard(List<String> p1, List<String> p2, List<String> p3) {

        DDZZ.computerOne = computerOne;
        DDZZ.computerTwo= computerTwo;
        DDZZ.user = user;

        DDZZ.alls = alls;
        DDZZ.showDown =showDown;
        DDZZ.show = show;
        //电脑间隔
        DDZZ.getComputeBlank(p2, p3);
        //牌距
        StringBuffer buffer = new StringBuffer();
        DDZZ.getBlank(blankLenth, blank, buffer);
        //取最大牌数
        DDZZ.cardCount(p2, p3, show, buffer);
        //玩家动态间隔
        DDZZ.getUserBlank(p1);
    }


}
