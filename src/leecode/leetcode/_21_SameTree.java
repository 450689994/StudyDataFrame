package leecode.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1-20
 */
public class _21_SameTree {

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        //深度优先搜索（一直向左，然后向右）
//        if (p != null && q != null) {
//            if (p.val != q.val) {
//                return false;
//            }
//            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
//        } else if (p == null && q == null) {
//            return true;
//        } else {
//            return false;
//        }
        //深度leetcode网友版本
//        if(p == null && q == null)
//            return true;
//        if(p == null || q == null)
//            return false;
//        if(p.val != q.val)
//            return false;
//        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);



        //广度优先搜索
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        Queue<TreeNode> queue1 = new LinkedList();
        Queue<TreeNode> queue2 = new LinkedList();
        queue1.offer(p);
        queue2.offer(q);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if (node1.val != node2.val) {
                return false;
            }
            TreeNode left1 = node1.left, right1 = node1.right, left2 = node2.left, right2 = node2.right;
            if (left1 == null ^ left2 == null) {
                return false;
            }
            if (right1 == null ^ right2 == null) {
                return false;
            }
            if (left1 != null) {
                queue1.offer(left1);
            }
            if (right1 != null) {
                queue1.offer(right1);
            }
            if (left2 != null) {
                queue2.offer(left2);
            }
            if (right2 != null) {
                queue2.offer(right2);
            }
        }
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public static void main(String[] args) {
        TreeNode root3 = new TreeNode(4);
        TreeNode root2 = new TreeNode(2);
        TreeNode root1 = new TreeNode(1, root2, root3);

        TreeNode _root3 = new TreeNode(3);
        TreeNode _root2 = new TreeNode(2);
        TreeNode _root1 = new TreeNode(1, _root2, _root3);
        System.out.println(isSameTree(root1, _root1));
    }
}
