package symbolTable.api;

import java.util.Comparator;
import java.util.Iterator;

public interface OrderedCanDo<Key extends Comparable<Key>, Value>{
    Key min();                      //获取最小键

    Key max();                      //获取最大键

    Key floor(Key key);             //小于key的最大键，没有强调要存在key，外部key也可以在外部

    Key celling(Key key);           //大于key的最小键，没有强调要存在key，外部key也可以在外部

    int rank(Key key);              //小于key的键的数量，没有强调要存在key，外部key也可以在外部

    Key select(int k);              //排名为k的键

    void deleteMin();               //删除最小键

    void deleteMax();               //删除最大键

    int size(Key k1, Key k2);       //键k1~k2之间键的数量(不包括各自身)

    Iterator<Key> keySet(Key k1, Key k2);  //表中键k1~k2之间键的集合（已排序）
}
