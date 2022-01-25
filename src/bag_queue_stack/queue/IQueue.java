package bag_queue_stack.queue;

public interface IQueue<T> {
    void enqueue(T item);   //添加一个元素

    T dequeue();            //删除最早添加的元素

    boolean isEmpty();      //队列是否为空

    int size();             //队列的元素数量
}
