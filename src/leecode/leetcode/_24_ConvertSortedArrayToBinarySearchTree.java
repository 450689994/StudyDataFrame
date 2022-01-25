package leecode.leetcode;

/**
 * 1-21
 */
public class _24_ConvertSortedArrayToBinarySearchTree {
    //二分读数组
    public static TreeNode sortedArrayToBST(int[] nums) {
        TreeNode method = method(nums, 0, nums.length);
        return method;
    }

    private static TreeNode method(int[] nums, int left, int right) {
        if (left >= right ) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode leftNode = method(nums, left, mid);
        TreeNode rightNode = method(nums, mid+1, right);
        return new TreeNode(nums[mid], leftNode, rightNode);
    }

    public static void main(String[] args) {
        System.out.println(sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
    }
}
