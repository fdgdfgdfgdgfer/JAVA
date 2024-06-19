package org.example.quesition;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class Solution {


    public static String decodeString(String s) {
        StringBuffer temp = new StringBuffer();
        StringBuffer result = new StringBuffer();
        Integer num = 0;
        LinkedList<Integer> numStack = new LinkedList<>();
        LinkedList<String> charStack = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (Character c : chars) {
            if (c >= '0' && c <= '9') {
                num = num * 10 + Integer.parseInt(c.toString());
            } else if (c.equals('[')) {
                numStack.addLast(num);
                charStack.addLast(result.toString());
                result = new StringBuffer();
                num = null;
            } else if (c.equals(']')) {
                StringBuffer temps = new StringBuffer();
                Integer integer = numStack.removeLast();
                for (int i = 0; i < integer; i++) {
                    temps.append(result);
                }
                result = new StringBuffer();
                result.append(charStack.removeLast() + temps.toString());
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = decodeString("100[leetcode]");
        System.out.println(s);
    }
}