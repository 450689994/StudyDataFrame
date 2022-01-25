package 二叉查找树;

import java.util.Iterator;

public interface IBST<Key,Value> {
    void put(Key key,Value value);  //若key是null，则将key在表中删除
    Value get(Key key);             //获取键对应的值
    void delete(Key key);           //删除键
    boolean contains(Key key);      //key是否存在表中
    boolean isEmpty();              //表是否为空
    int size();                     //表中键值对个数
    Key min();                      //获取最小键
    Key max();                      //获取最大键
    Key floor(Key key);             //小于等于key的最大键
    Key celling(Key key);           //大于等于键的最小键
    int rank(Key key);              //小于key的键的数量
    Key select(int k);              //排名为k的键
    void deleteMin();               //删除最小键
    void deleteMax();               //删除最大键
    int size(Key k1, Key k2);       //键k1~k2之间键的数量
    Iterator keys(Key k1, Key k2);  //表中键k1~k2之间键的集合（已排序）
    Iterator keys();                //表中所有键的集合（已排序）
}
