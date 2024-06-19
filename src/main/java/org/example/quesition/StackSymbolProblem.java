package org.example.quesition;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

/**
 * @Author jfz
 * @Date 2024/1/30 9:13
 * @PackageName:org.example.quesition
 * @ClassName: StackSymbolProblem
 */
@Data
@NoArgsConstructor
@Builder
public class StackSymbolProblem {
    static HashMap<Character, Character> hashMap = new HashMap<Character, Character>() {{
        put('[', ']');
        put('{', '}');
        put('(', ')');
    }};

    public static boolean stackSymbolProblem(String s) {
        Stack<Character> objects = new Stack<>();

        objects.push('*');
        char[] chars = s.toCharArray();
        for (Character c : chars) {
            if(hashMap.containsKey(c)){
                objects.push(c);
            }else if(!c.equals(hashMap.get(objects.pop()))){
                return false;
            }
        }
        return objects.size() == 1;
    }






}
