package huawei;

import java.util.List;
import java.util.Stack;

/**
 * 递归实现
 */
public class _10_四则运算_2 {
    private static int getLevel(Character operator) {
        if (operator == '}' || operator == ']' || operator == ')') {
            return 4;
        } else if (operator == '*' || operator == '/') {
            return 3;
        } else if (operator == '+' || operator == '-') {
            return 2;
        } else if (operator == '{' || operator == '[' || operator == '(') {
            return 1;
        }
        return 0;
    }

    private Integer operate(List<String> midList, Integer index) {
        Stack<Integer> stack = new Stack<>();

        String s = midList.get(index);
        int level = getLevel(midList.get(index).charAt(0));
        int rightLevel = getLevel(midList.get(index + 2).charAt(0));

        if (level == 1) {
            //左括号先不管
        } else if (level == 2 && rightLevel == 3) {
            //+、-,并且后面有*、/
            operate(midList, index + 2);
        } else if (level == 2 && rightLevel != 3) {
            //+、-,并且后面有*、/
        } else if (level == 3 && rightLevel == 1) {
            //*、/,并且后面有左括号
            operate(midList, index + 3);
        }

            return null;
    }

    public static void main(String[] args) {

    }
}
