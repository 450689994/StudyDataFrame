package 剑指offer;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * <p>
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 10000
 */
public class _06从尾到头打印链表_2 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 37 ms	39.2 MB
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        LinkedList<Integer> list = new LinkedList<>();
        int i = 0;
        while (head != null) {
            list.add(0, head.val);
            i++;
            head = head.next;
        }
        int[] ints = new int[i];
        for (i = 0; i < ints.length; i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }
}
