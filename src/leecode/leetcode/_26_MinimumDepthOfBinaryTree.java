package leecode.leetcode;

/**
 * 1-21
 */
public class _26_MinimumDepthOfBinaryTree {
    public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        else if (root.left == null) return minDepth(root.right) + 1;
        else if (root.right == null) return minDepth(root.left) + 1;
        else return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
//        TreeNode root5 = new TreeNode(6, null, null);
//        TreeNode root4 = new TreeNode(5, null, root5);
        TreeNode root3 = new TreeNode(4, null, null);
        TreeNode root2 = new TreeNode(3, null, null);
        TreeNode root1 = new TreeNode(2, root2, root3);
        System.out.println(minDepth(root1));
    }
}
