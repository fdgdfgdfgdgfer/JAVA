package org.example.quesition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/2/1 14:21
 * @PackageName:org.example.quesition
 * @ClassName: MiddleNode
 */
@Data
@NoArgsConstructor
public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        int length = 0;
        ListNode tem = head;
        while (tem != null) {
            length++;
            tem = tem.next;
        }
        int mid = length / 2;
        for (int i = 0; i <= mid; i++) {
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.setNext(listNode2);
        listNode2.setNext(listNode3);
        listNode3.setNext(null);
        ListNode listNode = new MiddleNode().middleNode(listNode1);

    }
}
