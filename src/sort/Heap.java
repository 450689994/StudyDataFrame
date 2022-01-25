package sort;

import java.util.Arrays;

/**
 * [a,b,c,d,e,f,g] r = 6 a(0) b(1) p=q-1 c(2) q=r/2-1 d(3) m=p*2+1 e(4) n=m+1 f(5) i=q*2+1 g(6)
 * j=p+1
 *
 * <p>0,1,2,3,4,5,6,7,8,9,··· [a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p] r = 15
 *
 * <p>b(1) g=w-1 c(2) w=e-1 d(3) e=u-1 e(4) u=o-1(g*2+1) f(5) o=r-1(w*2+1) g(6) r=p-1 h(7)
 * p=q-1(e*2+1) i(8) q=r/2-1 j(9) v=u+1 k(10) c=v+1 l(11) j=o*2+1 m(12) s=j+1 n(13) m=r*2+1 o(14)
 * n=m+1 p(15) i=p*2+1
 *
 * <p>数组根据索引转树：parent = (length-1)/2 ··· p = q-1 q = parent i = p*2+1 j = i+1 m = q*2+1 m+1
 */
public class Heap {
  public static void main(String[] args) {
//            int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    int[] arr = {16, 7, 3, 20, 17, 8};
//            int[] arr = {8,7,16,3};
    /** [16, 7, 3, 20, 17, 8] [20,[16,8,7,17,3]] [20,[17,[8,7,16,3]]] */
    bigHeap(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
  }

  private static void bigHeap(int[] arr, int left, int right) {
    if (left == right) {
      return;
    }
    for (int parent = (right - left) / 2 + left; parent >= left; parent--) {
      if (parent == left && (left == 1 && right - left< 3)) {
        adjustHeap(arr, parent, parent + 1, parent + 2);
      } else {
        adjustHeap(arr, parent, parent * 2 + 1, parent * 2 + 2);
      }
    }
    bigHeap(arr, left + 1, right);
  }

  private static void adjustHeap(int[] arr, int parent, int lChild, int rChild) {
    if (lChild < arr.length && arr[lChild] > arr[parent]) {
      int temp = arr[lChild];
      arr[lChild] = arr[parent];
      arr[parent] = temp;
    }
    if (rChild < arr.length && arr[rChild] > arr[parent]) {
      int temp = arr[rChild];
      arr[rChild] = arr[parent];
      arr[parent] = temp;
    }
  }
}
