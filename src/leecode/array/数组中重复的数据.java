package leecode.array;

import java.util.ArrayList;
import java.util.List;

public class 数组中重复的数据 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[nums[i]] && nums[i] != i) {
                //相等就挑出来
                list.add(nums[i]);
            }else {
                //不相等就交换
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[nums[i]] = temp;
                i = 0;
            }
        }
        return list;
    }
}
