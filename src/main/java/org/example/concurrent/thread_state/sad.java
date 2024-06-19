package org.example.concurrent.thread_state;
import java.util.ArrayList;
/**
 * @Author jfz
 * @Date 2024/4/28 13:43
 * @PackageName:org.example.concurrent.thread_state
 * @ClassName: sad
 */

public class sad {
    public static ArrayList<Integer> nums = new ArrayList<>();

    public static void main(String[] args) {
        insert(5);
        insert(2);
        insert(3);
        System.out.println(getMain());
    }

    public static void insert(Integer num) {
        if (null == nums || nums.size() == 0) {
            nums.add(num);
        } else {
            int i = 0;
            for (; i < nums.size(); i++) {
                if (num < nums.get(i)) {
                    break;
                }
            }
            nums.add(i,num);
        }

    }

    public static Double getMain() {
        if (nums.size() == 0) {
            return -1.0;
        }
        if (nums.size() == 1) {
            return Double.valueOf(nums.get(0));
        }
        if (nums.size() % 2 == 1) {
            return Double.valueOf(nums.get(nums.size() / 2));
        } else {
            int inx = nums.size() / 2;
            return (nums.get(inx) + nums.get(inx - 1)) / 2.0;
        }
    }
}