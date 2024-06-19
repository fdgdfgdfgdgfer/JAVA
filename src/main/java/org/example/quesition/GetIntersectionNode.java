package org.example.quesition;
import lombok.Data;
/**
 * @Author jfz
 * @Date 2024/2/1 14:49
 * @PackageName:org.example.quesition
 * @ClassName: GetIntersectionNode
 */
@Data
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A.next;
            if (A == null) {
                A = headB;
            }
            B = B.next;
            if (B == null) {
                B = headA;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        //[4,1,8,4,5], listB = [5,6,1,8,4,5],
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(8);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.setNext(listNode2);
        listNode2.setNext(listNode3);
        listNode3.setNext(listNode4);
        listNode4.setNext(listNode5);
        listNode5.setNext(null);

        ListNode listNode6 = new ListNode(5);
        ListNode listNode7 = new ListNode(6);
        ListNode listNode8 = new ListNode(1);

        listNode6.setNext(listNode7);
        listNode7.setNext(listNode8);
        listNode8.setNext(listNode3);
        listNode3.setNext(listNode4);
        listNode4.setNext(listNode5);
        listNode5.setNext(null);
        System.out.println(new GetIntersectionNode().getIntersectionNode(listNode1, listNode6));
    }
}
