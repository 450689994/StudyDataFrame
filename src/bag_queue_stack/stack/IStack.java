package bag_queue_stack.stack;

public interface IStack<T> {

    void push(T item);  //添加一个元素

    T pop();            //删除最近添加的元素

    boolean isEmpty();  //栈是否为空

    int size();         //栈中的元素数量
}
