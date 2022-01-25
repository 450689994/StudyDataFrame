package bag_queue_stack.bag;

public class Test {
    public static void main(String[] args) {
        /**
         * 计算一串正整数数的平均值
         */
        Bag<Integer> bag = new Bag<>(100);
        bag.add(1);
        bag.add(2);
        bag.add(3);
        bag.add(4);
        int sum = 0;
        for (Integer i : bag) {
            sum = sum + i;
        }
        System.out.println("平均值："+(double)sum/bag.size());
    }
}
