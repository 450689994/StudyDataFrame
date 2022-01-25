package leecode.leetcode;

/**
 * 1-14
 */
public class _2_回文数 {
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String s = Integer.toString(x);
        //一半即可
        for (int i = 0, j = s.length() - 1; i < s.length()/2; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(10));
    }
}
