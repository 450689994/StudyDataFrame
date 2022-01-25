package bag_queue_stack.queue;

import java.util.Iterator;

public class Queue<T> implements IQueue<T>, Iterable {
    private T[] arr;
    private int size;
    public int i;

    public Queue() {
        this.arr = (T[]) new Object[10];
    }

    public Queue(int capacity) {
        this.arr = (T[]) new Object[capacity];
    }

    @Override
    public void enqueue(T item) {
        if (isFull()) {
            //大小翻倍
            resize(2 * arr.length);
        }
        arr[size++] = item;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        //有值
        size--;
        if (size > 0 && size <= arr.length / 4) {
            resize(arr.length / 2);
        }
        T item = arr[0];
        T[] temp = (T[]) new Object[arr.length - 1];
        for (int i = 0; i < size; i++) {
            temp[i] = arr[i + 1];
        }
        arr = temp;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    class ListIterator implements Iterator<T> {
        private int i;

        @Override
        public boolean hasNext() {
            return size > i;
        }

        @Override
        public T next() {
            return arr[i++];
        }
    }

    private boolean isFull() {
        return arr.length == size;
    }

    private void resize(int max) {
        T[] temp = (T[]) new Object[max];
        for (int i = 0; i < size; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }
}
