package exam;

import java.util.Arrays;

public class 大于数组长度一半的数 {
   public static int f(int[] arr){
       if (arr.length == 1 && arr[0] != 0){
           return arr[0];
       }
       Arrays.sort(arr);
       int temp = 0;
       for (int i = 0; i < arr.length; i++) {
           if (arr[i] == arr[i+1]){
               temp++;
               if (temp >= arr.length/2){
                   return arr[i];
               }
           }else {
               temp = 0;
           }
       }
       return -1;
   }

    public static void main(String[] args) {
       int[] a = {9};
        f(a);
    }
}