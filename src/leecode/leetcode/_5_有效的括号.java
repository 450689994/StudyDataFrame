package leecode.leetcode;

import java.util.Stack;

/**
 * 1-15
 */
public class _5_有效的括号 {
    public static boolean isValid(String s) {
        if (s.length() < 2) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (isRight(c)) {
                if (stack.isEmpty() || !match(c, stack.peek())) {
                    return false;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    private static boolean match(char c, Character peek) {
        switch (c) {
            case ']':
                if (peek == '[')
                    return true;
                return false;
            case '}':
                if (peek == '{')
                    return true;
                return false;
            case ')':
                if (peek == '(')
                    return true;
                return false;
            default:
                return false;
        }
    }


    private static boolean isRight(char c) {
        switch (c) {
            case ']':
                return true;
            case '}':
                return true;
            case ')':
                return true;
            default:
                return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isValid("){"));
    }
}
