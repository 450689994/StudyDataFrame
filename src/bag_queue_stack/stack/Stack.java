package bag_queue_stack.stack;

import java.util.Iterator;

public class Stack<T> implements IStack<T> ,Iterable{
    private Node first;
    private int size;

    private class Node{
        T item;
        Node next;
    }

    public Stack() {
    }

    @Override
    public void push(T item) {
        Node node = new Node();
        node.item = item;
        node.next = first;
        first = node;
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()){
            return null;
        }
        T item = first.item;
        first = first.next;
        size--;
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
    class ListIterator implements Iterator<T>{
        Node tempNode = first;
        @Override
        public boolean hasNext() {
            return tempNode!=null;
        }

        @Override
        public T next() {
            T item = tempNode.item;
            tempNode = tempNode.next;
            return item;
        }
    }
}
