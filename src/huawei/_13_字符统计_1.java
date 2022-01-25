package huawei;

import java.util.*;

public class _13_字符统计_1 {
    private static Stack<Map.Entry<Character,Integer>> stack = null;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            TreeMap<Character,Integer> map = new TreeMap<>();
            for (int i = 0; i < str.length(); i++) {
                if (map.containsKey(str.charAt(i))) {
                    map.put(str.charAt(i),map.get(str.charAt(i))+1);
                }else {
                    map.put(str.charAt(i),1);
                }
            }
            Set<Map.Entry<Character, Integer>> entries = map.entrySet();
            Iterator<Map.Entry<Character, Integer>> iterator = entries.iterator();
            while (iterator.hasNext()) {
                Map.Entry<Character, Integer> next = iterator.next();
                toPush(next);
            }
            while (stack.size()!=0){
                System.out.print(stack.pop().getKey());
            }
            System.out.println();
            stack = null;
        }
    }

    private static void toPush(Map.Entry<Character, Integer> next){
        //0、如果栈是空直接入栈
        if (stack == null){
            stack = new Stack<>();
            stack.push(next);
            return;
        }
        //2、如果比栈顶大，直接入栈
        if (stack.peek().getValue()<next.getValue()){
            stack.push(next);
        }else if (stack.peek().getValue()>next.getValue()){
            //1、如果比栈顶小，就和栈顶换，直到大于栈顶为止
            Map.Entry<Character, Integer> temp = stack.pop();
            if (stack.size() == 0) {
                stack = null;
            }
            toPush(next);
            stack.push(temp);
        }else {
            //3、如果和栈顶相等，就匹配ASCII码，在使用
            if (stack.peek().getKey()>next.getKey()){
                //ASCII大
                stack.push(next);
            }else {
                //ASCII小
                Map.Entry<Character, Integer> temp = stack.pop();
                if (stack.size() == 0) {
                    stack = null;
                }
                toPush(next);
                stack.push(temp);
            }
        }
    }
}
