package sort;

import java.util.Arrays;

public class Choose {
    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1,0};
        for (int i = 0; i < arr.length-1; i++) {
            int mostTemp = arr[i];
            int mostIndex = i;

            for (int j = i+1; j <arr.length; j++) {
                if (arr[j]<mostTemp){
                    mostTemp = arr[j];
                    mostIndex = j;
                }
            }
            if (mostTemp != arr[i]) {
                arr[mostIndex] = arr[i];
                arr[i] = mostTemp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
