package huawei;

import java.util.Scanner;

/**
 * StringBuilder居然有反转的方法！
 */
public class _3_数字颠倒 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(new StringBuilder(str).reverse());
    }
}