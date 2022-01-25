package bag_queue_stack.bag;

public interface IBag<T> {

    void add(T item);         //添加

    boolean isEmpty();      //背包是否为空

    int size();             //背包的大小
}
