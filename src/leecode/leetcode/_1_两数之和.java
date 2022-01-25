package leecode.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 1-14
 */
public class _1_两数之和 {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]),i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] ints = {3, 2, 4};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(ints, target)));
    }
}
