package org.example.quesition;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author jfz
 * @Date 2024/2/1 9:48
 * @PackageName:org.example.quesition
 * @ClassName: KEY
 */
@Data
@NoArgsConstructor
@Builder
public class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> hashMap1 = new HashMap<>();
        HashMap<Character, Character> hashMap2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (hashMap1.containsKey(a) && hashMap1.get(a) != b ||
                    hashMap2.containsKey(b) && hashMap2.get(b) != a
            ) {
                return false;
            }

            hashMap1.put(a, b);
            hashMap2.put(b, a);
        }
        return true;
        //  Map<Character, Character> s2t = new HashMap<>(), t2s = new HashMap<>();
        //            for (int i = 0; i < s.length(); i++) {
        //                char a = s.charAt(i), b = t.charAt(i);
        //                // 对于已有映射 a -> s2t[a]，若和当前字符映射 a -> b 不匹配，
        //                // 说明有一对多的映射关系，则返回 false ；
        //                // 对于映射 b -> a 也同理
        //                if (s2t.containsKey(a) && s2t.get(a) != b ||
        //                        t2s.containsKey(b) && t2s.get(b) != a)
        //                    return false;
        //                s2t.put(a, b);
        //                t2s.put(b, a);
        //            }
        //            return true;
    }

    public static void main(String[] args) {
        boolean isomorphic = new IsIsomorphic().isIsomorphic("badc", "baba");
        System.out.println(isomorphic);
    }
}
