package org.example.quesition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author jfz
 * @Date 2024/2/2 9:51
 * @PackageName:org.example.quesition
 * @ClassName: DetectCycle
 */
@Data
@NoArgsConstructor
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> nodeHashMap = new HashSet<ListNode>();
        ListNode indexTop = head;
        while (indexTop != null) {
            if (!nodeHashMap.add(indexTop)) {
                return indexTop;
            }
            indexTop = indexTop.next;
        }


        return null;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.setNext(listNode2);
        listNode2.setNext(listNode3);
        listNode3.setNext(listNode1);
        ListNode listNode = new DetectCycle().detectCycle(listNode1);
        System.out.println(listNode);
    }
}
