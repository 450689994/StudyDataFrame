package symbolTable.api;

import java.util.Iterator;

public interface SymbolTable<Key,Value> {
    void put(Key key,Value value);  //若key是null，则将key在表中删除
    Value get(Key key);             //获取键对应的值
    void delete(Key key);           //删除键
    boolean contains(Key key);      //key是否存在表中
    boolean isEmpty();              //表是否为空
    int size();                     //表中键值对个数
    Iterator<Key> keySet();         //表中所有键的集合（已排序）

    //节点的方法（模仿HashMap的Map.Entry）
    interface MyEntry<Key,Value>{
        //返回键
        Key getKey();
        //返回值
        Value getValue();
        //设置值
        void setValue(Value value);
    }
}
