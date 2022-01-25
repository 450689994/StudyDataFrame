package leecode.leetcode;

/**
 * 1-22
 */
public class _27_PathSum {
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return (hasPathSum(root.left, targetSum - root.val) ||
                hasPathSum(root.right, targetSum - root.val));
    }

    public static void main(String[] args) {
        TreeNode root3 = new TreeNode(3, null, null);
        TreeNode root2 = new TreeNode(2, null, null);
        TreeNode root1 = new TreeNode(1, root2, root3);
        System.out.println(hasPathSum(null, 0));
    }
}
