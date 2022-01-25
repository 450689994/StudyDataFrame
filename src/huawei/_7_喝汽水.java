package huawei;

import java.util.ArrayList;
import java.util.Scanner;

public class _7_喝汽水 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        int num = 0;
        while ((num = sc.nextInt()) != 0){
            if (num !=  0) {
                arr.add(f(num, 0));
            }else {
                break;
            }
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static int f(int num,int sum){
        if (num-2 > 1) {
            return f(num -2,++sum);
        }else {
            return ++sum;
        }
    }
}
