package huawei;

import java.util.*;

/**
 * 3+2*{1+2*[-4/(8-6)+7]}
 * 步骤：
 * 0、先把字符串表达式转换成<数组>表达式，因为两位数的存在和小数点的存在！还有-1这种数单独的出现！
 * 1、先把中序编程后续（栈+数组）
 * 2、再把把后序结合栈和数组进行计算即可。
 */
public class _9_四则运算_1 {
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

    private static List<String> getList(String midExpression) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < midExpression.length(); i++) {
            char c = midExpression.charAt(i);
            int level = getLevel(c);
            if (level == 1 || level == 3 || level == 4) {
                //不是减法直接入数组
                list.add(String.valueOf(c));
            } else if (level == 2) {
                //如果是减法
                if (c == '-') {
                    //情况一 如果前面还有数字： 9-4*(1+2)    ————>   9+(-4)*(1+2)
                    //情况二 如果前面没数字： -4*(1+2)     ————>   (-4)*(1+2)
                    if (i != 0 && (getLevel(midExpression.charAt(i - 1)) == 4 || (midExpression.charAt(i - 1) <= '9' && midExpression.charAt(i - 1) >= '0'))) {
                        list.add("+");
                    }
                    if (getLevel(midExpression.charAt(i+1)) == 1) {
                        list.add("-1");
                        list.add("*");
                    }else {
                        list.add("-" + getNumber(midExpression, i + 1));
                        int jump = j - i - 1;
                        i += jump;
                    }

                } else {
                    //加法无视
                    list.add(String.valueOf(c));
                }
            } else {
                //如果是数字！！！！！！！！
                String number = getNumber(midExpression, i);
                int jump = j - i - 1;
                i += jump;
                list.add(number);
            }
        }
        return list;
    }

    private static int j;

    private static String getNumber(String midExpression, int index) {
        //例如：782     7*10^2+8*10^1+2*10^0（用栈实现）
        //考虑点：多位数（暂不考虑小数点）
        Stack<Integer> stack = new Stack<>();
        Character temp = null;
        for (j = index; j < midExpression.length() && (temp = midExpression.charAt(j)) <= '9' && temp >= '0'; j++) {
            stack.push(Integer.parseInt(String.valueOf(temp)));
        }
        int number = 0;
        for (int k = 0; !stack.isEmpty(); k++) {
            number = number + stack.pop() * (int) Math.pow(10, k);
        }
        return String.valueOf(number);
    }

    private static List<String> getPostExpression(List<String> midList) {
        List<String> postList = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < midList.size(); i++) {
            String c1 = midList.get(i);
            char c = c1.charAt(0);
            //如果是操作数
            if (c1.length() > 1 || (c <= '9' && c >= '0')) {
                postList.add(c1);
                continue;
            }
            //如果是运算符
            if (getLevel(c) == 1) {
                //0、如果是左括号，直接忽略，入栈
                stack.push(c);
            } else if (getLevel(c) == 4) {
                //0.5、如果是右括号，那就全部弹出入数组直到遇到左括号
                Character pop = null;
                while (getLevel(pop = stack.pop()) != 1) {
                    postList.add(String.valueOf(pop));
                }
            } else if (stack.isEmpty()) {
                stack.push(c);
            } else if (getLevel(c) > getLevel(stack.peek())) {
                //2、不是左括号，并且此运算符优先级高于栈顶运算符的优先级，直进入
                stack.push(c);
            } else {
                //2、不是空，并且此运算符优先级低于等于栈顶运算符的优先级，直进入
                //3、并且如果此运算符一直低于等于栈顶运算符就得一直弹，然后放到数组中直到高于
                while (!stack.isEmpty() && getLevel(c) <= getLevel(stack.peek())) {
                    Character pop = stack.pop();
                    postList.add(String.valueOf(pop));
                }
                //4、最后把自己放进去
                stack.push(c);
            }
        }
        //最后把栈中的操作符都拿出来
        while (!stack.isEmpty()) {
            postList.add(String.valueOf(stack.pop()));
        }
        return postList;
    }

    private static Integer getResult(List<String> midList) {
        //准备一个数字栈，放操作数
        Stack<Integer> operandStack = new Stack<>();
        for (int i = 0; i < midList.size(); i++) {
            String c1 = midList.get(i);
            char c = c1.charAt(0);
            //数字入栈
            if (c1.length() > 1 || (c <= '9' && c >= '0')) {
                operandStack.push(Integer.parseInt(c1));
                continue;
            } else {
                int operand2 = operandStack.pop();
                int operand1 = operandStack.pop();
                switch (c) {
                    case '+':
                        operandStack.push(operand1 + operand2);
                        break;
                    case '-':
                        operandStack.push(operand1 - operand2);
                        break;
                    case '*':
                        operandStack.push(operand1 * operand2);
                        break;
                    case '/':
                        operandStack.push(operand1 / operand2);
                        break;
                }
            }
        }
        return operandStack.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String midExpression = sc.nextLine();
        List<String> midList = getList(midExpression);
        System.out.println(midList);
        List<String> postList = getPostExpression(midList);
        System.out.println(postList);
        Integer result = getResult(postList);
        System.out.println(result);
        //3+2*{1+2*[-4/(8-6)+7]}
        //3*5+8-0*3-6+0+0
        //3-10+(0+(10+5+3)-10)
        //9-1+0-9+4-10-(8+4+10)-1
    }
}
