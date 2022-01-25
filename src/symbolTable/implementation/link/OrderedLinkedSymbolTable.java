package symbolTable.implementation.link;

import symbolTable.api.OrderedCanDo;
import symbolTable.exception.NullKeyException;
import symbolTable.exception.NullSymbolTableException;
import symbolTable.implementation.link.abs.AbstractLinkedSymbolTable;

import java.util.Iterator;

/**
 * 有序链式符号表
 * @param <Key>
 * @param <Value>Key extends Comparable<Key>
 */
public class OrderedLinkedSymbolTable<Key extends Comparable<Key>, Value> extends AbstractLinkedSymbolTable<Key, Value> implements OrderedCanDo<Key, Value> {

    public OrderedLinkedSymbolTable() {
    }

    @Override
    public Key min() {
        if (first == null)
            throw new NullSymbolTableException();
        return (Key) first.getKey();    //返回头节点即可
    }

    @Override
    public Key max() {
        if (first == null)
            throw new NullSymbolTableException();
        for (OrderedMyNode i = (OrderedMyNode)first;i != null; i = i.getNext()){
            if (i.getNext() == null)    //遍历到最后一个节点并返回即可
                return (Key) i.getKey();
        }
        return null;
    }

    @Override
    public Key floor(Key key) {
        if (first == null)
            throw new NullSymbolTableException();
        //没有强调要存在key，外部key也可以比较
        for (OrderedMyNode i = (OrderedMyNode) first; i != null; i = i.getNext()) {
            if (i.getNext().getKey().compareTo(key) >= 0)   //遍历到前一个结点判断
                return (Key) i.getKey();
        }
        return null;
    }

    @Override
    public Key celling(Key key) {
        if (first == null)
            throw new NullSymbolTableException();
        //没有强调要存在key，外部key也可以比较
        for (OrderedMyNode i = (OrderedMyNode) first; i != null; i = i.getNext()) {
            if (i.getKey().compareTo(key) == 0 && i.getNext() != null)  //遍历到对应节点，有后一个就返回，没后一个就null
                return (Key) i.getNext().getKey();
        }
        return null;
    }

    @Override
    public int rank(Key key) {
        if (first == null)
            throw new NullSymbolTableException();
        //前提是key存在
        if (!contains(key)){
            throw  new NullKeyException();
        }
        //如果就是头节点直接返回1
        if (min().compareTo(key) == 0){
            return 1;
        }
        //遍历到位置即可
        int amount = 1;
        for (OrderedMyNode i = (OrderedMyNode)first;i != null; i = i.getNext()){
            if (i.getKey().compareTo(key) == 0){
                return amount;
            }
            amount++;
        }
        return amount;
    }

    @Override
    public Key select(int k) {
        if (first == null)
            throw new NullSymbolTableException();
        //k的大小判断
        if (k>size()){
            return null;
        }
        int j = 0;
        for (OrderedMyNode i = (OrderedMyNode)first; j < k ; i = i.getNext(),j++){
            //循环到指定位置
            if (j+1 == k){
                return (Key) i.getKey();
            }
        }
        return null;
    }

    @Override
    public void deleteMin() {
        if (first == null)
            throw new NullSymbolTableException();
        first = first.getNext();
    }

    @Override
    public void deleteMax() {
        if (first == null)
            throw new NullSymbolTableException();
        for (OrderedMyNode i = (OrderedMyNode)first ; i != null ; i = i.getNext()){
            if (i.getNext().getNext() == null){     //判断到提前一个
                i.setNext(null);
            }
        }
    }

    @Override
    public int size(Key k1, Key k2) {
        int size = 0;
        //用区间迭代器实现
        Iterator<Key> keyIterator = keySet(k1, k2);
        while (keyIterator.hasNext()) {
            size++;
            keyIterator.next();
        }
        return size;
    }

    @Override
    public Iterator<Key> keySet(Key k1, Key k2) {
        if (first == null)
            throw new NullSymbolTableException();
        if (!contains(k1) && !contains(k2))
            return null;
        if (k1.compareTo(k2) > 0)
            return null;
        return new Iterator<Key>() {
            OrderedMyNode temp = null;
            //先遍历到对应的k1开始位置
            {
                for (OrderedMyNode i = (OrderedMyNode)first ; i != null ; i = i.getNext()){
                    if(i.getKey().compareTo(k1) == 0){
                        temp = i;
                    }
                }
            }
            @Override
            public boolean hasNext() {
                if (temp == null)
                    return false;
                //不能超过k2
                if (temp.getKey().compareTo(k2)<= 0)
                    return true;
                return false;
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

    @Override
    public void put(Key key, Value value) {
        //key不能为空
        if (key == null){
            throw new NullKeyException();
        }
        //如果链表为空 且 不是删键，就初始化链表
        if (isEmpty() && value != null) {
            first = new OrderedMyNode(key, value, null);
            setSize(size()+1);
            return;
        }
        //如果value是null就视它要删除这个节点，因为提前达成协议不允许空value出现
        if (value == null) {
            //如果第一个就是
            if (first.getKey() == key) {
                first = first.getNext();
                setSize(size()-1);
                return;
            }
            //循环到前一个节点
            for (OrderedMyNode j = (OrderedMyNode)first; j != null; j = j.getNext()) {
                if (j.getNext().getKey().compareTo(key) >= 0) {
                    j.setNext(j.getNext().getNext());
                    setSize(size()-1);
                    return;
                }
            }
        }
        //如果value不是null
        //存在key，直接修改值
        if (contains(key)) {
            for (OrderedMyNode i = (OrderedMyNode) first; i != null; i = i.getNext()) {
                if (i.getKey().compareTo(key) == 0) {
                    i.setValue(value);
                    return;
                }
            }
        }
        //不存在key,key的位置要讲究一下，不能再头插了
        for (OrderedMyNode i = (OrderedMyNode)first; i != null; i = i.getNext()) {
            if (i.getNext() != null && i.getNext().getKey().compareTo(key) >= 0){
                i.setNext(new OrderedMyNode(key,value,i.getNext()));
                setSize(size()+1);
                return;
            }else if (i.getNext() == null && i.getKey().compareTo(key) <= 0){
                i.setNext(new OrderedMyNode(key,value,null));
                setSize(size()+1);
                return;
            }
        }
    }

}
