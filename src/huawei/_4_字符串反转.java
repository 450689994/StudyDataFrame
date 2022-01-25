package huawei;

import java.util.Scanner;

public class _4_字符串反转 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(new StringBuilder(str).reverse());
    }
}
