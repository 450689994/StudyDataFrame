package sort;

import java.util.Arrays;

public class Insert_1 {
    public static void main(String[] args) {
        int[] arr = {9,0,7,4,5,6,3,2,6,0};

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i-1]) {
                for (int j = 0; j < i; j++) {
                    if (arr[i] < arr[j]){
                        int[] temp = new int[arr.length];
                        if (j == 0){
                            temp[0] = arr[i];
                        }else {
                            System.arraycopy(arr,0,temp,0,j);
                            temp[j] = arr[i];
                        }
                        System.arraycopy(arr,j,temp,j+1,i-j);
                        System.arraycopy(arr,i+1,temp,i+1,arr.length-i-1);
                        arr = temp;
                        break;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
