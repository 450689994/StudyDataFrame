package leecode.leetcode;

/**
 * 1-15
 */
public class _7_移除元素 {
//    public static int removeElement(int[] nums, int val) {
//        int j = nums.length - 1;
//        for (int i = 0; i <= j; i++) {
//            if (nums[i] == val) {
//                swap(nums, i--, j--);
//            }
//        }
//        return j + 1;
//    }
//
//    private static void swap(int[] nums, int i, int j) {
//        int tmp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = tmp;
//    }

    public static int removeElement(int[] nums, int val) {
        int idx = 0;
        for (int x : nums) {
            if (x != val)
                nums[idx++] = x;
        }
        return idx;
    }


    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 0));
    }
}
