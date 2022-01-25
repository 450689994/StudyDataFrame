package leecode.leetcode;

/**
 * 1-20
 */
public class _23_MaximumDepthOfBinaryTree {

    //深度
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return method(root, 0);
    }

    private static int method(TreeNode root, int deep) {
        if (root == null) {
            return deep;
        }
        return Math.max(method(root.left, deep+1),
                method(root.right, deep+1));
    }


    public static void main(String[] args) {
        TreeNode root7 = new TreeNode(4);
        TreeNode root6 = new TreeNode(3);
        TreeNode root5 = new TreeNode(15);
        TreeNode root4 = new TreeNode(7);

        TreeNode root3 = new TreeNode(20, root5, root4);
        TreeNode root2 = new TreeNode(9, null, null);
        TreeNode root1 = new TreeNode(3, root2, root3);
        System.out.println(maxDepth(root1));
    }
}
