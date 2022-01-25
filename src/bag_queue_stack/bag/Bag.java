package bag_queue_stack.bag;

import java.util.Iterator;

public class Bag<T> implements IBag<T> , Iterable<T> {
    private T[] arr;
    private int size;

    public Bag() {
        //创建泛型数组在Java中是不允许的
        this.arr = (T[]) new Object[10];
    }

    public Bag(int capacity) {
        this.arr = (T[]) new Object[capacity];
    }

    @Override
    public void add(T item) {
        arr[size++] = item;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }
    class ListIterator implements Iterator<T>{
        private int i;
        @Override
        public boolean hasNext() {
            return size>i;
        }

        @Override
        public T next() {
            return arr[i++];
        }
    }
}
