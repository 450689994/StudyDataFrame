package bag_queue_stack.queue;

public class Test {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>(1);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println("弹出之前："+queue.size());
        for (Object o : queue) {
            System.out.println(o);
        }
        Integer dequeue = queue.dequeue();
        System.out.println("弹出的元素："+dequeue);
        System.out.println("弹出之后："+queue.size());
        for (Object o : queue) {
            System.out.println(o);
        }
    }
}
