package org.example.quesition;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/1/26 9:53
 * @PackageName:org.example.quesition
 * @ClassName: SeparateLinked
 */
@Data
@NoArgsConstructor
@Builder
public class SeparateLinked {
    public static ListNode separateLinked(ListNode head, Integer value) {
        ListNode minOld = new ListNode(0);
        ListNode maxOld = new ListNode(0);
        ListNode min = minOld;
        ListNode max = maxOld;
        while (head != null) {
            if (head.val < value) {
                min.next = head;
                min = min.next;
            } else {
                max.next = head;
                max = max.next;
            }
            head = head.next;
        }
        min.next = maxOld.next;
        max.next = null;
        return minOld.next;
    }
    public static ListNode partition(ListNode head, Integer x) {
        ListNode smlDummy = new ListNode(0);
        ListNode  bigDummy = new ListNode(0);
        ListNode sml = smlDummy;
        ListNode big = bigDummy;
        while (head != null) {
            if (head.val < x) {
                sml.next = head;
                sml = sml.next;
            } else {
                big.next = head;
                big = big.next ;
            }
            head = head.next;
        }
        sml.next = bigDummy.next;
        big.next = null;
        return smlDummy.next;
    }
}
