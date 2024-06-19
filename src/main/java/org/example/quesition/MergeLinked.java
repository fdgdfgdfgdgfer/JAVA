package org.example.quesition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/1/25 11:24
 * @PackageName:org.example.quesition
 * @ClassName: MergeLinked
 */
@Data
@AllArgsConstructor
@Builder
public class MergeLinked {

    public static ListNode mergeLinked(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val > l2.val) {
            l2.next = mergeLinked(l1, l2.next);
            return l2;
        } else {
            l1.next = mergeLinked(l1.next, l2);
            return l1;
        }

    }
}
