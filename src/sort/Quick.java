package sort;

import java.util.Arrays;

public class Quick {
  public static void main(String[] args) {
    int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    sort(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
  }

  private static void sort(int[] arr, int left, int right) {
    if (right - left <= 0) {
      return;
    }
      int index = realSort(arr, left, right);
      sort(arr, left, index - 1 < 0 ? index : index - 1); // 前
      sort(arr, index + 1 > arr.length - 1 ? index : index + 1, right); // 后
  }

  private static int realSort(int[] arr, int left, int right) {
    int value = arr[left];
    boolean power = true; //  false:left  true:right
    while (left != right) {
      if (power == false) {
        if (arr[left] > value) {
          arr[right] = arr[left];
          power = true; // 转移控制权
          right--;
        } else {
          left++;
        }
      } else {
        if (arr[right] < value) {
          arr[left] = arr[right];
          // 转移控制权
          power = false;
          left++;
        } else {
          right--;
        }
      }
    }
    arr[left] = value;
    return left; // 返回索引
  }
}
