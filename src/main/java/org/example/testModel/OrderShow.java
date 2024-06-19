package org.example.testModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author jfz
 * @Date 2024/5/28 17:17
 * @PackageName:org.example.testModel
 * @ClassName: OrderShow
 */
public class OrderShow extends Base {

    public OrderShow(CardBase cardBase) {
        super(cardBase);
    }

    @Override
    public void showCard(List<String> p1,List<String> p2,List<String> p3) {
        //排序
        quck(p1, 0, p1.size() - 1);
        quck(p2, 0, p2.size() - 1);
        quck(p3, 0, p3.size() - 1);
        super.showCard(p1,p2,p3);
    }

    public static void quck(List<String> list, int left, int right) {
        ///* 快速排序 */
        if (left >= right) {
            return;
        }
        int sort = sort(list, left, right);
        quck(list, left, sort - 1);
        quck(list, sort + 1, right);
    }


    public static int sort(List<String> list, Integer left, Integer right) {
        int i = left;
        int j = right;
        int num1 = 0;
        if (list.get(left).contains("2")) {
            num1 = 15;
        }
        if (list.get(left).contains("3")) {
            num1 = 3;
        }
        if (list.get(left).contains("4")) {
            num1 = 4;
        }
        if (list.get(left).contains("5")) {
            num1 = 5;
        }
        if (list.get(left).contains("6")) {
            num1 = 6;
        }
        if (list.get(left).contains("7")) {
            num1 = 7;
        }
        if (list.get(left).contains("8")) {
            num1 = 8;
        }
        if (list.get(left).contains("9")) {
            num1 = 9;
        }
        if (list.get(left).contains("10")) {
            num1 = 10;
        }
        if (list.get(left).contains("J")) {
            num1 = 11;
        }
        if (list.get(left).contains("Q")) {
            num1 = 12;
        }
        if (list.get(left).contains("K")) {
            num1 = 13;
        }
        if (list.get(left).contains("A")) {
            num1 = 14;
        }
        if (list.get(left).contains("w") || list.get(left).contains("W")) {
            num1 = 16;
        }

        while (i < j) {


            while (i < j) {
                int num3 = 0;
                if (list.get(j).contains("2")) {
                    num3 = 15;
                }
                if (list.get(j).contains("3")) {
                    num3 = 3;
                }
                if (list.get(j).contains("4")) {
                    num3 = 4;
                }
                if (list.get(j).contains("5")) {
                    num3 = 5;
                }
                if (list.get(j).contains("6")) {
                    num3 = 6;
                }
                if (list.get(j).contains("7")) {
                    num3 = 7;
                }
                if (list.get(j).contains("8")) {
                    num3 = 8;
                }
                if (list.get(j).contains("9")) {
                    num3 = 9;
                }
                if (list.get(j).contains("10")) {
                    num3 = 10;
                }
                if (list.get(j).contains("J")) {
                    num3 = 11;
                }
                if (list.get(j).contains("Q")) {
                    num3 = 12;
                }
                if (list.get(j).contains("K")) {
                    num3 = 13;
                }
                if (list.get(j).contains("A")) {
                    num3 = 14;
                }
                if (list.get(j).contains("w") || list.get(j).contains("W")) {
                    num3 = 16;
                }
                if (num1 <= num3) {
                    j--;
                } else {
                    break;
                }
            }
            while (i < j) {

                int num2 = 0;
                if (list.get(i).contains("2")) {
                    num2 = 15;
                }
                if (list.get(i).contains("3")) {
                    num2 = 3;
                }
                if (list.get(i).contains("4")) {
                    num2 = 4;
                }
                if (list.get(i).contains("5")) {
                    num2 = 5;
                }
                if (list.get(i).contains("6")) {
                    num2 = 6;
                }
                if (list.get(i).contains("7")) {
                    num2 = 7;
                }
                if (list.get(i).contains("8")) {
                    num2 = 8;
                }
                if (list.get(i).contains("9")) {
                    num2 = 9;
                }
                if (list.get(i).contains("10")) {
                    num2 = 10;
                }
                if (list.get(i).contains("10")) {
                    num2 = 10;
                }
                if (list.get(i).contains("J")) {
                    num2 = 11;
                }
                if (list.get(i).contains("Q")) {
                    num2 = 12;
                }
                if (list.get(i).contains("K")) {
                    num2 = 13;
                }
                if (list.get(i).contains("A")) {
                    num2 = 14;
                }
                if (list.get(i).contains("w") || list.get(i).contains("W")) {
                    num2 = 16;
                }
                if (num2 <= num1) {
                    i++;
                } else {
                    break;
                }
            }
            swap(list, i, j);
        }
        swap(list, i, left);
        return i;

    }

    public static void swap(List<String> list, int left, int right) {
        String temp = list.get(left);
        list.set(left, list.get(right));
        list.set(right, temp);
    }
}
