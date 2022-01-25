package bag_queue_stack.stack;

public class Test {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("弹出之前："+stack.size());
        for (Object o : stack) {
            System.out.println(o);
        }
        System.out.println("弹出的元素："+stack.pop());
        System.out.println("弹出之后："+stack.size());
        for (Object o : stack) {
            System.out.println(o);
        }
    }
}
