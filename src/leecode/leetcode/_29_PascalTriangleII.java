package leecode.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1-24
 */
public class _29_PascalTriangleII {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            row.add(0);
            for (int j = i; j > 0; --j) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;
    }

    public static void main(String[] args) {
        System.out.println(getRow(6));
    }
}
