package leecode.leetcode;

/**
 * 1-17
 */
public class _13_LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        String trim = s.trim();
        return trim.length() - trim.lastIndexOf(" ") - 1;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("1"));
    }
}
