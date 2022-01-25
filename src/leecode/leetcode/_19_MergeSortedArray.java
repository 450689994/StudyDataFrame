package leecode.leetcode;

import java.util.Arrays;

/**
 * 1-19
 */
public class _19_MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        //直接合并后排序
//        for (int i = 0; i != n; ++i) {
//            nums1[m + i] = nums2[i];
//        }
//        Arrays.sort(nums1);

        //数组交换可行，但是太复杂，没有实现
//        for (int i = 0; i < m; i++) {
//            for (int s = i, j = 0; s <= m - i + 1 && j < n; s++, j++) {
//                if (nums1[s] > nums2[j]) {
//                    int tmp = nums1[s];
//                    nums1[s] = nums2[j];
//                    nums2[j] = tmp;
//                }
//            }
//        }
//        for (int i = 0; i != n; ++i) {
//            nums1[m + i] = nums2[i];
//        }


        //新数组
//        if (m == 0) {
//            for (int i = 0; i < nums1.length; i++) {
//                nums1[i] = nums2[i];
//            }
//        } else if (n != 0 && m != 0) {
//            int[] newArray = new int[m + n];
//            for (int nN = 0, n1 = 0, n2 = 0; nN < newArray.length; nN++) {
//                if ((n1 < m && n2 < n && nums1[n1] <= nums2[n2]) || (n2 == n)) {
//                    newArray[nN] = nums1[n1++];
//                } else if ((n2 < n && n1 < m && nums1[n1] > nums2[n2]) || (n1 == m)) {
//                    newArray[nN] = nums2[n2++];
//                }
//            }
//            for (int i = 0; i < nums1.length; i++) {
//                nums1[i] = newArray[i];
//            }
//        }

        //逆向插入(待定)



    }

    public static void main(String[] args) {

        int[] nums1 = {2, 0};
        int m = 1;
        int[] nums2 = {1};
        int n = 1;
        merge(nums1, m, nums2, n);
    }
}
