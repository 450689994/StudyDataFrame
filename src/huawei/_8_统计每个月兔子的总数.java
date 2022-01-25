package huawei;

import java.util.Scanner;

/**
 * 斐波那契数列
 */
public class _8_统计每个月兔子的总数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        if (month == 1 || month == 2){
            System.out.println(1);
            return;
        }
        int sum = 0,one = 1,two = 1;
        for (int i = 3; i <= month; i++) {
            sum = one + two;
            one = two;
            two = sum;
        }
        System.out.println(sum);
    }
}
/**
 *        month         sum
 月 1    2    3    4    5    6    7    8    9    10    11    12

 小 1    0    1    1    2    3    5    8    13    21    34    55

 中 0    1    0    1    1    2    3    5    8     13    21    34

 大 0    0    1    1    2    3    5    8    13    21    34    55

    1    1    2    3    5    8   13   21    34    55    89    ···
 *
 *
 *
 *
 */
