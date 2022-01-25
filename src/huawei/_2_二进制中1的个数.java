package huawei;

import java.util.Scanner;

/**
 * 出下面之外，可以使用：
 *          递归
 *          Integer.toBinaryString(num);    直接转换为二进制
 */
public class _2_二进制中1的个数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int sum = 0;
        do {
            if (num % 2 == 1){
                ++sum;
            }
            num = num / 2;

        }while (num != 1);
        System.out.println(sum+1);
    }
}