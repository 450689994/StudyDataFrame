package sort;

import java.util.Arrays;

public class Merge {
  public static void main(String[] args) {
    int[] arr = {9,8,7,6,5,4,3,2,1,0};
    sort(arr);
    System.out.println(Arrays.toString(arr));
  }

  private static void sort(int[] arr) {
    sort(arr,0,arr.length-1);
  }

  private static void sort(int[] arr, int left, int right) {
    if(left<right){
      int mid = (left+right)/2;
      sort(arr,left,mid);
      sort(arr,mid+1,right);
      merge(arr,left,mid,right);
    }
  }

  private static void merge(int[] arr, int left, int mid, int right) {
    //临时数组
    int[] temp = new int[arr.length];
    //两个数组合并需要两个头指针,i:临时数组的索引
    int p_1 = left , p_2 = mid+1 , i = 0;

    while (p_1 <= mid && p_2 <= right){
      if(arr[p_1] <= arr[p_2]){
        temp[i++] = arr[p_1++];
      }else {
        temp[i++] = arr[p_2++];
      }
    }

    //加入左边的数组
    while (p_1 <= mid){
      temp[i++] = arr[p_1++];
    }

    //加入右边的数组
    while (p_2 <= right){
      temp[i++] = arr[p_2++];
    }

    //写回主数组
    i = 0;
    while (left <= right){
      arr[left++] = temp[i++];
    }
  }
}
