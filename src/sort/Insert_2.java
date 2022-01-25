package sort;

import java.util.Arrays;

/*
       升级版
 */
public class Insert_2 {
    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1,0};

        for (int i = 1; i < arr.length; i++) {
            //下面是for循环
            for (int j = i ; j > 0 && arr[j] < arr[j-1] ; j--) {
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }
            //下面是while循环
//            int j = i;
//            while (j != 0 && arr[j]<arr[j-1]){
//                int temp = arr[j];
//                arr[j] = arr[j-1];
//                arr[j-1] = temp;
//                j--;
//            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
