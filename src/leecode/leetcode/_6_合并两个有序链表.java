package leecode.leetcode;

/**
 * 1-15
 */
public class _6_合并两个有序链表 {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }else if(list2 == null){
            return list1;
        }else if(list1.val < list2.val){
            list1.next = mergeTwoLists(list1.next,list2);
            return list1;
        }else {
            list2.next = mergeTwoLists(list1,list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        ListNode node_4 = new ListNode(4, null);
        ListNode node_2 = new ListNode(2, node_4);
        ListNode node_1 = new ListNode(1, node_2);

        ListNode node_4_ = new ListNode(4, null);
        ListNode node_3 = new ListNode(3, node_4_);
        ListNode node_1_ = new ListNode(1, node_3);

        mergeTwoLists(node_1, node_1_);
    }
}
