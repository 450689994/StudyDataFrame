package leecode.leetcode;

/**
 * 1-17
 */
public class _12_最大子数组和 {
    //暴力
//    public static int maxSubArray(int[] nums) {
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            int temp = 0;
//            for (int j = i; j < nums.length; j++) {
//                temp += nums[j];
//                if(temp > max)
//                    max = temp;
//            }
//        }
//        return max;
//    }

    public static int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    //动态规划
//    public static int maxSubArray(int[] nums) {
//        int ans = nums[0];
//        int sum = 0;
//        for(int num: nums) {
//            if(sum > 0) {
//                sum += num;
//            } else {
//                sum = num;
//            }
//            ans = Math.max(ans, sum);
//        }
//        return ans;
//    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
