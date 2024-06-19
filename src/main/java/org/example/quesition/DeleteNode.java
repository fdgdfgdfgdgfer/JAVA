package org.example.quesition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/1/26 13:45
 * @PackageName:org.example.quesition
 * @ClassName: DeleteNode
 */
@Data
@NoArgsConstructor
@Builder
public class DeleteNode {

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
