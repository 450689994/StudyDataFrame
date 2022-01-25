package leecode.leetcode;

import java.util.Arrays;

/**
 * 1-16
 */
public class _8_删除有序数组中的重复项 {
//    public static int removeDuplicates(int[] nums) {
//        int j = nums.length - 1;
//        for (int i = 1; i <= j; i++) {
//            //等于上一个  (i + 1 < nums.length && nums[i + 1] == nums[i - 1])
//            if (nums[i] == nums[i - 1]) {
//                swap(nums, i--, j--);
//            } else if (i - 2 >= 0 && nums[i] == nums[i - 2]) {
//                swap(nums, i--, j--);
//                Arrays.sort(nums, 0, j + 1);
//            }
//        }
//        Arrays.sort(nums, 0, j + 1);
//        return j + 1;
//    }

//    public static int removeDuplicates(int[] nums) {
//        int j = nums.length - 1;
//        boolean flag = false;
//        for (int i = 1; i <= j; i++) {
//            for (int k = 0; k < i; k++) {
//                if(nums[k] == nums[i]){
//                    flag = true;
//                    break;
//                }
//            }
//            if(flag){
//                swap(nums,i--,j--);
//                flag = false;
//            }
//        }
//        Arrays.sort(nums, 0, j + 1);
//        return j + 1;
//    }

//    private static void swap(int[] nums, int i, int j) {
//        int tmp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = tmp;
//    }

//    public static int removeDuplicates(int[] nums) {
//        int count = 0;
//        Integer temp = null;
//        for (int i = 1; i < nums.length; i++) {
//            int max = nums[nums.length - 1] + 1;
//            if (nums[i] == nums[i - 1] || (temp != null && nums[i] == temp)) {
//                if (nums[i] != max) {
//                    temp = nums[i];
//                }
//                nums[i] = max;
//                count++;
//            }
//        }
//        Arrays.sort(nums);
//        return nums.length - count;
//    }

    public static int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            //i > j是优化：避免原地复制
            if (nums[i] != nums[j] && i > j) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }


    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }
}
