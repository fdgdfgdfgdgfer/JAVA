package org.example.quesition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

/**
 * @Author jfz
 * @Date 2024/1/29 8:55
 * @PackageName:org.example.quesition
 * @ClassName: CopyLinked
 */
@Data
@NoArgsConstructor
public class CopyLinked {

    public static Node copyLinked(Node head) {
        Node car = head;
        while (car != null) {
            Node node = new Node(car.val);
            node.next = car.next;
            car.next = node;
            car = car.next.next;
        }
        car = head;
        while (null != car) {
            if (null != car.random) {
                car.next.random = car.random.next;
            }
            car = car.next.next;
        }

        car = head;
        Node result1 = head.next;
        Node result2 = head.next;
        Node pre = head;
        while (null != result1.next) {
            pre.next = pre.next.next;
            result1.next = result1.next.next;
            result1 = result1.next;
        }
        return result2;
    }

}








//     // 3. 拆分两链表
//        cur = head.next;
//        Node pre = head, res = head.next;
//        while(cur.next != null) {
//            pre.next = pre.next.next;
//            cur.next = cur.next.next;
//            pre = pre.next;
//            cur = cur.next;
//        }
//        pre.next = null;













