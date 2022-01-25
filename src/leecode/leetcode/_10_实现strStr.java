package leecode.leetcode;

/**
 * 1-16
 */
public class _10_实现strStr {
    public static int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }
        if ("".equals(haystack) || "".equals(needle)) {
            return 0;
        }
        for (int i = 0; haystack.length() - i >= needle.length(); i++) {
            int j = 0;
            for (; j < needle.length(); j++) {
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "issipi"));
    }
}
