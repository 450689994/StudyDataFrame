package symbolTable.implementation.link.abs;

import symbolTable.abs.AbstractSymbolTable;

import java.util.Iterator;

public abstract class AbstractLinkedSymbolTable<Key,Value> extends AbstractSymbolTable<Key,Value> {
    //头节点
    protected MyNode first;
    @Override
    public Value get(Key key) {
        if (isEmpty())
            return null;
        for (MyNode i = first; i != null; i = i.getNext()) {
            if (i.getKey().equals(key)) {
                return (Value) i.getValue();
            }
        }
        return null;
    }

    @Override
    public boolean contains(Key key) {
        if (isEmpty())
            return false;
        for (MyNode i = first; i != null; i = i.getNext()) {
            if (i.getKey().equals(key))
                return true;
        }
        return false;
    }

    //键的全迭代
    @Override
    public Iterator<Key> keySet() {
        return new Iterator<Key>() {
            MyNode temp = first;
            @Override
            public boolean hasNext() {
                return temp != null;
            }

            @Override
            public Key next() {
                try {
                    return (Key) temp.getKey();
                }finally {
                    temp = temp.getNext();
                }
            }
        };
    }
    //是否是空
    @Override
    public boolean isEmpty() {
        return first == null;
    }
}
