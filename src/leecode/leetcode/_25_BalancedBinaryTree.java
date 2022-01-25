package leecode.leetcode;

/**
 * 1-21
 */
public class _25_BalancedBinaryTree {
    public static boolean isBalanced(TreeNode root) {
        return method(root, 0) != Integer.MAX_VALUE;
    }

    private static int method(TreeNode root, int deep) {
        if (root == null) {
            return deep;
        }
        int leftDeep = method(root.left, deep + 1);
        int rightDeep = method(root.right, deep + 1);
        if (Math.abs(leftDeep - rightDeep) > 1) {
            return Integer.MAX_VALUE;
        }
        return Math.max(leftDeep, rightDeep);
    }

    public static void main(String[] args) {
        TreeNode root5 = new TreeNode(7);
        TreeNode root4 = new TreeNode(15);

        TreeNode root3 = new TreeNode(20, root4, root5);
        TreeNode root2 = new TreeNode(9, null, null);
        TreeNode root1 = new TreeNode(3, root2, root3);
        System.out.println(isBalanced(root1));
    }
}
