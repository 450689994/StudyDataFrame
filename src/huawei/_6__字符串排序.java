package huawei;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 输入：
 * 9
 * cap
 * to
 * cat
 * card
 * two
 * too
 * up
 * boat
 * boot
 *
 * 输出：
 * boat
 * boot
 * cap
 * card
 * cat
 * to
 * too
 * two
 * up
 */
public class _6__字符串排序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        TreeSet treeSet = new TreeSet();
        for (int i = 0; i <= sum; i++) {
            treeSet.add(sc.nextLine());
        }
        for (Object o : treeSet) {
            System.out.println(o);
        }
    }
}
