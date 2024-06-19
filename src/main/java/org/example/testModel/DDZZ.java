package org.example.testModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

import java.util.List;

/**
 * @Author jfz
 * @Date 2024/5/29 16:47
 * @PackageName:org.example.testModel
 * @ClassName: DDZZ
 */

public class DDZZ {
    public static List<String> alls;
    public static Boolean showDown = false;
    public static Boolean show = false;
    public static String blank = "    ";
    public static int computer = 20;
    public static int blankLenth = 21;
    public static String computerOne = "";
    public static String computerTwo = "";
    public static String user = "";

    public static void getBlank(int count, String blank, StringBuffer sb) {
        for (int m = 0; m < count; m++) {
            sb.append(blank);
        }
    }

    public static void getComputeBlank(List<String> p2, List<String> p3) {
        String USER1 = "电脑一";
        String USER2 = "电脑二";
        //空格符
        //获取电脑之间的间隔
        StringBuffer jg = new StringBuffer();
        getBlank(computer, blank, jg);
        System.out.println(USER1 + jg + USER2);
    }

    public static void getUser(List<String> p1, StringBuffer buffer) {
        for (int u = 0; u < p1.size(); u++) {
            buffer.append(p1.get(u));
        }
    }

    public static void getUserBlank(List<String> p1) {
        StringBuffer buffer = new StringBuffer();
        getUser(p1, buffer);
        int mid = blankLenth - p1.size();
        StringBuffer front = new StringBuffer();
        front.append(blank);
        int cont = mid / 2;
        getBlank(cont, blank, front);
        int userFront = p1.size() / 2;
        StringBuffer userBuffer = new StringBuffer();
        getBlank(userFront, blank, userBuffer);
        System.out.println(front.toString() + buffer);
        System.out.println(userBuffer + front.toString() + " 玩家");
    }

    public static void cardCount(List<String> p2, List<String> p3, Boolean show, StringBuffer buffer) {
        int max = Math.max(p2.size(), p3.size());
        for (int i = 0; i < max; i++) {
            String showP2 = "";
            String showP3 = "";
            if (show) {
                if (p2.size() > i) {
                    showP2 = p2.get(i);
                }
                if (p3.size() > i) {
                    showP3 = p3.get(i);
                }
            } else {
                if (p2.size() > i) {
                    showP2 = "♦";
                }
                if (p3.size() > i) {
                    showP3 = "♦";
                }
            }
            if (showDown) {
                if (i == max / 2) {
                    StringBuffer stringBuffer = new StringBuffer(buffer);
                    StringBuffer delete = stringBuffer.delete(stringBuffer.length() - 10, stringBuffer.length());
                    int count = delete.length() / 6;
                    StringBuffer front = new StringBuffer();
                    StringBuffer tial = new StringBuffer();
                    getBlank(count, blank, front);
                    getBlank(count, blank, tial);
                    System.out.println(showP2 + "  " + front + alls.get(0) + alls.get(1) + alls.get(2) + tial + "  " + showP3);
                }
            }
            if (StringUtils.isNotBlank(computerOne)) {
                if (i == max / 2) {
                    StringBuffer stringBuffer = new StringBuffer(buffer);
                    StringBuffer delete = stringBuffer.delete(stringBuffer.length() - 10, stringBuffer.length());
                    int count = delete.length() / 4;
                    StringBuffer front = new StringBuffer();
                    StringBuffer tial = new StringBuffer();
                    getBlank(count, blank, front);
                    getBlank(count, blank, tial);
                    System.out.println(showP2 + computerOne + front + tial + "  " + showP3);
                }
            }
            if (StringUtils.isNotBlank(computerTwo)) {
                if (i == max / 2) {
                    StringBuffer stringBuffer = new StringBuffer(buffer);
                    StringBuffer delete = stringBuffer.delete(stringBuffer.length() - 20, stringBuffer.length());
                    int count = delete.length() / 6;
                    StringBuffer front = new StringBuffer();
                    StringBuffer tial = new StringBuffer();
                    getBlank(count, blank, front);
                    getBlank(count, blank, tial);
                    System.out.println(showP2 + " " + front + tial + computerTwo + showP3);
                }
            }
            if (StringUtils.isNotBlank(user)) {
                if (i == max - 1) {
                    StringBuffer stringBuffer = new StringBuffer(buffer);
                    StringBuffer delete = stringBuffer.delete(stringBuffer.length() - 20, stringBuffer.length());
                    int count = delete.length() / 6;
                    StringBuffer front = new StringBuffer();
                    StringBuffer tial = new StringBuffer();
                    getBlank(count, blank, front);
                    getBlank(count, blank, tial);
                    System.out.println(showP2+ "  " + front + user + tial + "  " + showP3);
                }
            }
            System.out.println(showP2 + buffer + showP3);
        }
    }

}
