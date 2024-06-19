package org.example.quesition;

import com.sun.corba.se.impl.orbutil.ObjectUtility;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author jfz
 * @Date 2024/2/1 11:22
 * @PackageName:org.example.quesition
 * @ClassName: IsSubsequence
 */
@Data
@NoArgsConstructor
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        ArrayList<Character> sa = new ArrayList<Character>() {
        };
        for (int i = 0; i < t.length(); i++) {
            sa.add(t.charAt(i));
        }
        char[] res = new char[sa.size()];
        for (Character c : s.toCharArray()) {
            if (sa.contains(c)) {
                res[sa.indexOf(c)] = c;
            }
        }
        String  s1 ="";
        for (Character f :res){
            if(Integer.valueOf(f) != 0){
                s1 +=f.toString();
            }
        }

       if (s1.equals(s)) {
            return true;
        } else {
            return false;

        }

    }

    public static void main(String[] args) {
//输入：："acb"
//t =
//"ahbgdc"  abc"
//t =
//"ahbgdc"  "ab"
//t =
//"baab"

        boolean subsequence = new IsSubsequence().isSubsequence("ab", "baab");
        System.out.println(subsequence);
    }
}
