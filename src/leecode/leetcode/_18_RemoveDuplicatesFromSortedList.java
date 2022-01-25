package leecode.leetcode;

/**
 * 1-19
 */
public class _18_RemoveDuplicatesFromSortedList {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode result = head;
        while (head == null && head.next != null){
            if(head.next != null && head.val == head.next.val){
                head.next = head.next.next;
            }else {
                head = head.next;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode node_7_ = new ListNode(4, null);
        ListNode node_6_ = new ListNode(3, node_7_);
        ListNode node_5_ = new ListNode(2, node_6_);
        ListNode node_4_ = new ListNode(2, node_5_);
        ListNode node_3_ = new ListNode(2, node_4_);
        ListNode node_2 = new ListNode(1, node_3_);
        ListNode node_1_ = new ListNode(1, node_2);

        deleteDuplicates(node_1_);
    }
}
