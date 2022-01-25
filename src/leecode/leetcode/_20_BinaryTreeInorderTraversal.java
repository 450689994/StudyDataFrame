package leecode.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 1-19
 */
public class _20_BinaryTreeInorderTraversal {

//    public static List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        method(list, root);
//        return list;
//    }
//
//    private static void method(List<Integer> list, TreeNode root) {
//        if (root == null)
//            return;
//        method(list, root.left);
//        list.add(root.val);
//        method(list, root.right);
//    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if(root!=null) {
                stack.add(root);
                root = root.left;
            } else {
                TreeNode tmp = stack.pop();
                list.add(tmp.val);
                root = tmp.right;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root3 = new TreeNode(3);
        TreeNode root2 = new TreeNode(2, root3, null);
        TreeNode root1 = new TreeNode(1, null, root2);
        inorderTraversal(root1);
    }
}
