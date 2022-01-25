package leecode.leetcode;

/**
 * 1-24
 */
public class _31_ValidPalindrome {
    public static boolean isPalindrome(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }
        String s1 = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        String s2 = new StringBuilder(s1).reverse().toString();
        return s1.equals(s2);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("0P"));
    }
}
