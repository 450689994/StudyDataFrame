package bag_queue_stack.stack;

import java.util.Scanner;

public class Evaluate {
    public static void main(String[] args) {
        String expression ="((4*(5+5))+(120/(9-7)))";
        Stack<Integer> value = new Stack<>();
        Stack<String> operator = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        while (!next.equals("q")){
            switch (next){
                case "+":
                    operator.push(next);break;
                case "-":
                    operator.push(next);break;
                case "*":
                    operator.push(next);break;
                case "/":
                    operator.push(next);break;
                case "(":break;
                case ")":
                    String ops = operator.pop();
                    Integer val_b = value.pop();
                    Integer val_a = value.pop();
                    switch (ops){
                        case "+":
                            value.push(val_a+val_b);
                            break;
                        case "-":
                            value.push(val_a-val_b);
                            break;
                        case "*":
                            value.push(val_a*val_b);
                            break;
                        case "/":
                            value.push(val_a/val_b);
                            break;
                    }
                    break;

                    default:
                        //数字
                        value.push(Integer.valueOf(next));
            }
            next= scanner.next();
        }
        System.out.println("4*(5+5)+120/(9-7)="+value.pop());
    }
}
