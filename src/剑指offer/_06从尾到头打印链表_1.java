package 剑指offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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
public class _06从尾到头打印链表_1 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    int[] a;
    int i;
    int j;

    /**
     * 0 ms	40 MB
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        reverse(head);
        return a;
    }

    public void reverse(ListNode head){
        if (head == null){
            a = new int[i];
            return;
        }
        //数组长度还在增加
        i++;
        reverse(head.next);
        a[j++] = head.val;
    }
}

/**
 * 最好的解法就是栈（递归）
 */