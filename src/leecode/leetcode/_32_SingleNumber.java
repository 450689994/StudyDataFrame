package leecode.leetcode;

import java.util.*;

/**
 * 1-24
 */
public class _32_SingleNumber {
    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if((i-1>=0 && nums[i-1] == nums[i]) ||(i+1<nums.length && nums[i] == nums[i+1])){
                i++;
            }else {
                return nums[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{4, 1, 2, 1, 2}));
    }
}
