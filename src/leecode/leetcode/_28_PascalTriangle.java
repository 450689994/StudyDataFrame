package leecode.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1-23
 */
public class _28_PascalTriangle {
    //官方版本
//    public List<List<Integer>> generate(int numRows) {
//        List<List<Integer>> ret = new ArrayList<List<Integer>>();
//        for (int i = 0; i < numRows; ++i) {
//            List<Integer> row = new ArrayList<Integer>();
//            for (int j = 0; j <= i; ++j) {
//                if (j == 0 || j == i) {
//                    row.add(1);
//                } else {
//                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
//                }
//            }
//            ret.add(row);
//        }
//        return ret;
//    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>(i);
            list.add(1);
            if (i == 1) {

            } else {
                int beforeIndex = 0;
                if (result.size() != 1) {
                    beforeIndex = i - 2;
                }
                List<Integer> beforeList = result.get(beforeIndex);
                for (int j = 0; j < beforeList.size(); j++) {
                    int nextValue = 0;
                    if (j + 1 < beforeList.size()) {
                        nextValue = beforeList.get(j + 1);
                    }
                    list.add(beforeList.get(j) + nextValue);
                }
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> generate = generate(0);
        System.out.println(generate);
    }
}
