package symbolTable.implementation.array;

import symbolTable.api.OrderedCanDo;
import symbolTable.exception.NullKeyException;
import symbolTable.exception.NullSymbolTableException;
import symbolTable.implementation.array.abs.AbstractArraySymbolTable;

import java.util.Iterator;

/**
 * 有序顺序（数组）符号表
 *
 * @param <Key>
 * @param <Value>
 */
public class OrderedArraySymbolTable<Key extends Comparable<Key>, Value> extends AbstractArraySymbolTable<Key, Value> implements OrderedCanDo<Key, Value> {

    @Override
    public void put(Key key, Value value) {
        super.put(key, value);
        //这里能做的只是每次插入之后排个序（两个以上才排）
        if (size() > 1) {
            /**
             * 只有当进行有关删除操作(delete、put(value = null)、deleteMin，注意deleteMax不需要因为本身就是最后一个)，才会填充数组
             * 因为排序是根据size()排序的，所以必须要提前填充数组
             */
            if (value == null)
                fillArray();
            sort();
        }
    }

    public void sort() {
        //对数组冒泡排序
        MyNode temp;//定义一个临时变量
        for (int i = 0; i < size() - 1; i++) {
            for (int j = 0; j < size() - i - 1; j++) {
                if (array[j + 1].getKey().compareTo(array[j].getKey()) < 0) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 二分查找(递归)
     *
     * @param key
     * @return
     */
    @Override
    public Value get(Key key) {
        //传的是数组的角标：0 ~ size-1
        return get(key, 0, size() - 1);
    }

    private Value get(Key key, int low, int high) {
        if (low <= high) {
            int mid = (low + high) / 2;
            int i = array[mid].getKey().compareTo(key);
            if (i > 0) {
                return get(key, low, high - 1);
            } else if (i < 0) {
                return get(key, mid + 1, high);
            } else {
                return array[mid].getValue();
            }
        }
        return null;    //找不到就返回null
    }

    /**
     * 获得key在数组中的索引index
     *
     * @param key
     * @return
     */
    public int getIndex(Key key) {
        return getIndex(key, 0, size() - 1);
    }

    //!!!!显然这里会出现代码的冗余，但是这个暂时没有好的办法解决。
    private int getIndex(Key key, int low, int high) {
        if (low <= high) {
            int mid = (low + high) / 2;
            int i = array[mid].getKey().compareTo(key);
            if (i > 0) {
                return getIndex(key, low, high - 1);
            } else if (i < 0) {
                return getIndex(key, mid + 1, high);
            } else {
                return mid;       //返回index
            }
        }
        return -1;  //找不到就返回-1
    }

    /**
     * 有序调用二分查找
     * @param key
     * @return
     */
    @Override
    public boolean contains(Key key) {
        //这里用get和getIndex都一样
        return getIndex(key) == -1 ? false : true;
    }

    @Override
    public Key min() {
        if (array == null)
            throw new NullSymbolTableException();
        return array[0].getKey();
    }

    @Override
    public Key max() {
        if (array == null)
            throw new NullSymbolTableException();
        return array[size() - 1].getKey();
    }

    @Override
    public Key floor(Key key) {
        int index = getIndex(key);
        if (min().compareTo(key) >= 0)     //如果小于等于最小值，直接返回null
            return null;
        if (index != -1)    //如果不是空，就返回结果
            return array[index - 1].getKey();
        return max();
    }

    @Override
    public Key celling(Key key) {
        int index = getIndex(key);
        if (max().compareTo(key) <= 0)     //如果大于等于最大值，直接返回null
            return null;
        if (index != -1)    //如果不是空，就返回结果
            return array[index + 1].getKey();
        //此时的key就是比min还小
        return min();
    }

    /**
     * 注意:
     *  1、这里是小于键的数量！如果不是空，就直接索引即可，因为 index-1+1 == index
     *  2、key也可以不是表中的key！
     * @param key
     * @return
     */
    @Override
    public int rank(Key key) {
        int index = getIndex(key);
        if (index != -1)
            return index;
        //如果没有看是比最大的大（还是比最小的小）
        if (max().compareTo(key) < 0) {     //比最大的还大，直接返回size
            return size();
        }
        return 0;
    }

    @Override
    public Key select(int k) {
        if (k > 0 && k <= length)    //k在数组大小范围内(1~length)
            return array[k - 1] == null ? null : array[k - 1].getKey();
        return null;
    }

    @Override
    public void deleteMin() {
        array[0] = null;
        setSize(size() - 1);
        fillArray();    //填充数组
    }

    @Override
    public void deleteMax() {
        array[size() - 1] = null;
        setSize(size() - 1);
    }

    @Override
    public int size(Key k1, Key k2) {
        int index1 = getIndex(k1);
        int index2 = getIndex(k2);
        //这个对k1、k2的前后大小没有要求，只要存在就行，不存在就抛异常，最后的值要是绝对值就行
        if (index1 == -1 || index2 == -1)
            throw new NullKeyException();
        int size = index2 - index1;
        return Math.abs(size) - 1; //不包括自身
    }

    @Override
    public Iterator<Key> keySet(Key k1, Key k2) {
        if (contains(k1) && contains(k2) && k1.compareTo(k2) <= 0)
            return new Iterator<Key>() {
                int index1 = getIndex(k1);
                int index2 = getIndex(k2);

                @Override
                public boolean hasNext() {
                    return index1 <= index2;
                }

                @Override
                public Key next() {
                    return array[index1++].getKey();
                }
            };
        return null;
    }
}
