package leecode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 输入两个数字，在输入两个数组的长度：
 * 第一个数字：第一个数组的长度
 * 第二个数字：第二个数组的长度
 * 第二个数组是对第一个数组的操作，数组中的值arr[i]指定第一个数组前arr[i]个元素后移到第一个数组的最后
 *
 * 例如：
 * 输入：
 * 5 2
 * [1,2,3,4,5]
 * [1,3]
 * 输出：
 * [5,1,2,3,4]
 *
 * 例如：
 *  * 输入：
 *  * 1 3
 *  * [1,2,3,4,5]
 *  * [1,2,3,4] = 10   10%5 = 0  不变
 *      23451
 *      45123
 *      23451
 *      12345
 *  * 输出：
 *  * [5,1,2,3,4]
 *
 * 分析：
 * 0、数组1的长度i，数组2的长度j
 * 1、计算第二个数组的和（n）
 * 2、如果n小于第一个数组的长度就，就直接后移n个
 * 3、如果大于，对 n%i = m，就直接后移m个
 */
public class 数组元素后移 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        int j = scanner.nextInt();

        int[] arr1 = new int[i];
        int[] arr2 = new int[j];
        int sum2 = 0;

        for (int n = 0; n < i; n++) {
            arr1[n] = scanner.nextInt();
        }
        for (int n = 0; n < j; n++) {
            arr2[n] = scanner.nextInt();
            sum2 = sum2 + arr2[n];
        }
        int number = sum2 % i;
        if (number != 0){
            int[] newArray = new int[i];
            System.arraycopy(arr1,number,newArray,0,i-number);
            System.arraycopy(arr1,0,newArray,i-number,number);
            System.out.println(Arrays.toString(newArray));
        }
    }
}
