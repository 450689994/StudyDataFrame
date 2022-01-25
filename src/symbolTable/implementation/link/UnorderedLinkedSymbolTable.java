package symbolTable.implementation.link;

import symbolTable.exception.NullKeyException;
import symbolTable.implementation.link.abs.AbstractLinkedSymbolTable;

import java.util.Comparator;

/**
 * 无序链式符号表
 * @param <Key>
 * @param <Value>
 */
public class UnorderedLinkedSymbolTable<Key, Value> extends AbstractLinkedSymbolTable<Key, Value> {

    public UnorderedLinkedSymbolTable() {}

    /**
     * 采用头插法
     *
     * @param key
     * @param value
     */
    @Override
    public void put(Key key, Value value) {
        //key不能为空
        if (key == null){
            throw new NullKeyException();
        }
        //如果链表为空 且 不是删键，就初始化链表
        if (isEmpty() && value != null) {
            first = new MyNode(key, value, null);
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
            for (MyNode j = first; j != null; j = j.getNext()) {
                if (j.getNext().getKey().equals(key)) {
                    j.setNext(j.getNext().getNext());
                    setSize(size()-1);
                    return;
                }
            }
        }
        //如果value不是null
        //且存在key
        if (contains(key)) {
            for (MyNode i = first; i != null; i = i.getNext()) {
                //存在key，直接修改值
                if (i.getKey().equals(key)) {
                    i.setValue(value);
                    return;
                }
            }
        }
        //不存在key，采用头插法
        first = new MyNode<Key, Value>(key, value, first);
        setSize(size()+1);
    }

    /**
     * 因为无序队列本身无序，存的类型也不一定实现Comparable接口所以需要外部的比较器Comparator工具来进行排序
     * 采用冒泡排序
     * @param comparator    比较器
     */
    public void sort(Comparator comparator){
        //先把链表存到一个临时的数组
        MyNode[] myNodes = new MyNode[size()];
        int k = 0;
        for (MyNode i = first ; i != null ; i = i.getNext()){
            myNodes[k++] = new MyNode<>(i.getKey(),i.getValue(),i.getNext());
        }
        //对临时数组冒泡排序
        MyNode temp;//定义一个临时变量
        for(int i=0;i<myNodes.length-1;i++){
            for(int j=0;j<myNodes.length-i-1;j++){
                if(comparator.compare(myNodes[j+1].getKey(),myNodes[j].getKey())<0){
                    temp = myNodes[j];
                    myNodes[j] = myNodes[j+1];
                    myNodes[j+1] = temp;
                }
            }
        }
        //把排序后的数组再”写“回链表，是直接覆盖原链表的数据
        k = 0;
        for (MyNode i = first ; i != null ; i = i.getNext()){
            i.setKey(myNodes[k].getKey());
            i.setValue(myNodes[k++].getValue());
        }
    }
}
