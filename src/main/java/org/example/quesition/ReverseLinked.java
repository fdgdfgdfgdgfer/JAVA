package org.example.quesition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/1/25 14:17
 * @PackageName:org.example.quesition
 * @ClassName: ReverseLinked
 */
@Data
@AllArgsConstructor
@Builder
public class ReverseLinked {

    public static ListNode reverseLinked(ListNode listNode) {
   return      cur(listNode,null);
    }

    public static ListNode cur(ListNode cur, ListNode pre) {
        if (cur == null) {
            return pre;
        }
        ListNode listNode = cur(cur.next, cur);
        cur.next = pre;
        return listNode;
    }

}
