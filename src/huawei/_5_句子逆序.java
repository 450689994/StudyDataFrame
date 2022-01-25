package huawei;

import java.util.Scanner;

public class _5_句子逆序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] s = str.split(" ");
        for (int i = s.length - 1; i >= 0; i--) {
            System.out.print(s[i]+" ");
        }
    }
}
