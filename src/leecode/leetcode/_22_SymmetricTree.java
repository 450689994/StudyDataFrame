package leecode.leetcode;

/**
 * 1-20
 */
public class _22_SymmetricTree {
    public static boolean isSymmetric(TreeNode root) {
        //深度优先遍历
        return method(root.left, root.right);
    }

    private static boolean method(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        if (left.val != right.val)
            return false;
        return method(left.left, right.right) && method(right.left, left.right);
    }

    public static void main(String[] args) {
        TreeNode root7 = new TreeNode(4);
        TreeNode root6 = new TreeNode(3);
        TreeNode root5 = new TreeNode(4);
        TreeNode root4 = new TreeNode(3);

        TreeNode root3 = new TreeNode(2, null, root4);
        TreeNode root2 = new TreeNode(2, root6, root7);
        TreeNode root1 = new TreeNode(1, root2, root3);
        System.out.println(isSymmetric(root1));
    }
}
