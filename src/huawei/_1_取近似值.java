package huawei;

import java.util.Scanner;

public class _1_取近似值 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double num = sc.nextDouble();
        System.out.println(num>=(int)num+0.5?(int)Math.ceil(num):(int)Math.floor(num));
    }
}