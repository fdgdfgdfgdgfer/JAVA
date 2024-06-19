package org.example.quesition;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author jfz
 * @Date 2024/2/1 9:00
 * @PackageName:org.example.quesition
 * @ClassName: FristUni
 */
@Data
@NoArgsConstructor
public class FirstUniqChar {
    public int firstUniqChar(String s) {
        //不存在则返回-1
        int[] index = new int[26];
        for (int i = 0; i < s.length(); i++) {
            index[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 1){
                return i;
            }
        }

        return -1;
    }


}
