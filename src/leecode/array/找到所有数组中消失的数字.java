package leecode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 找到所有数组中消失的数字 {

    public List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> list = new ArrayList();
        Arrays.sort(nums);
        for (int num : nums) {
            System.out.print(num+", ");
        }
        System.out.println();
        for (int i = 0,j = 1; i < nums.length; i++) {
            if (nums[i] != j && i+1!=nums.length){
                if (nums[i] < j && i+1!=nums.length){
                    continue;
                }else if (nums[i] < j && i+1==nums.length){
                    System.out.println("123123");
                    for (int k = j; k < nums.length+1 ; k++) {
                        list.add(k);
                    }
                } else {
                    //大于说明有跳过
                    for (int k = j; k < nums[i]; k++) {
                        list.add(k);
                    }
                    j = nums[i];
                }
            } else if (i+1==nums.length && nums[i] != nums.length){
                list.add(nums.length);
            }
            j++;
        }
        return list;
    }

    public static void main(String[] args) {
//        int[] nums = {4,3,2,6,7,2,3,1};
//        int[] nums = {1,1,1,1,1};
        int[] nums = {1,1,2,2};
//        int[] nums = {1,2,2,3,4,4};
//        int[] nums = {27,40,6,21,14,36,10,19,44,10,41,26,39,20,25,19,14,7,29,27,40,38,11,44,4,6,48,39,9,13,7,45,41,23,31,8,24,1,3,5,28,11,49,29,18,4,38,32,24,15};

        // 122334(5)(6)78
        List<Integer> list = new 找到所有数组中消失的数字().findDisappearedNumbers1(nums);
        System.out.println(list);
    }
}
