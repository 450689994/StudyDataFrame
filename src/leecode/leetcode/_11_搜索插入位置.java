package leecode.leetcode;

/**
 * 1-16
 */
public class _11_搜索插入位置 {
//    public static int searchInsert(int[] nums, int target) {
//        int i = 0;
//        for (; i < nums.length; i++) {
//            if (target <= nums[i]){
//                return i;
//            }
//        }
//        return i;
//    }

    public static int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            //!!!!!!!!!!!!
            int mid = l + (r - l) / 2;
            if (nums[mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 7));
    }
}
