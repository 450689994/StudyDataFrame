package leecode.leetcode;

import java.util.Arrays;

/**
 * 1-18
 */
public class _14_PlusOne {
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >= 0; i--) {
            int num = digits[i] + 1;
            if(num == 10){
                if(i-1 != -1){
                    digits[i] = 0;
                }else {
                    //直接返回一个新数组
                    int[] newArr = new int[digits.length + 1];
                    newArr[0] = 1;
                    return newArr;
                }
            }else {
                digits[i] ++;
                break;
            }
        }
        return digits;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{9})));
    }
}
