package symbolTable.implementation.array.abs;

import symbolTable.abs.AbstractSymbolTable;
import symbolTable.exception.NullKeyException;

import java.util.Iterator;

public abstract class AbstractArraySymbolTable<Key, Value> extends AbstractSymbolTable<Key, Value> {
    //实现数组
    protected MyNode<Key, Value>[] array;

    //数组的长度
    protected int length;

    //扩容倍数
    protected final float EXPAND_CAPACITY_FACTOR = 2f;

    //缩容背倍数  15 * x = 10  x=10/15=2/3=0.67
    protected final float REDUCE_CAPACITY_FACTOR = 0.5f;

    //利用率
    protected final float RATE_CAPACITY_FACTOR = 0.25f;

    //数组初始容量
    protected final int DEFAULT_INITIAL_CAPACITY = 10;

    @Override
    public void put(Key key, Value value) {
        //数组是否进行了初始化
        if (array == null) {
            resize(true);
        }
        //如果key是null
        if (key == null)
            throw new NullKeyException();
        //如果key存在，判断存在不适用contain，因为contain要遍历一遍，之后锁定数组单元还要再锁定一遍，所以直接遍历
        for (int i = 0; i < size(); i++) {
            //array[i]不能是null因为如果遍历到被删除的键那就是null，会空指针异常
            if (array[i] != null && array[i].getKey().equals(key)) {
                if (value == null) {
                    //value是null，删除key-value
                    array[i] = null;
                    setSize(size() - 1);
                    //考虑缩容，利用率不到2/3
                    if (length != DEFAULT_INITIAL_CAPACITY && (double) size() / length <= RATE_CAPACITY_FACTOR) {
                        resize(false);
                    }
                    return;
                }
                //value不是null就修改
                array[i].setValue(value);
                return;
            }
        }
        //如果不存在key
        //判断数组是否使用满了,满了就扩容
        if (length == size())
            resize(true);
        //next在目前的数组暂时用不到，在之后的散列表中会用，所以保留
        array[size()] = new MyNode<Key, Value>(key, value, null);
        setSize(size() + 1);
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterator<Key> keySet() {
        return new Iterator<Key>() {
            int i = 0;

            @Override
            public boolean hasNext() {
                return i < length;
            }

            @Override
            public Key next() {
                return array[i++] == null ? null : array[i-1].getKey();
            }
        };
    }


    /**
     * true是扩容，false是缩容
     * @param inOrDe
     */
    protected void resize(boolean inOrDe) {
        if (inOrDe) {    //扩容
            //初始化数组
            if (array == null) {
                array = new MyNode[DEFAULT_INITIAL_CAPACITY];
                length = array.length;
                return;
            }
            //扩大容量
            copy(EXPAND_CAPACITY_FACTOR, true);
        } else {
            //缩容和上面的步骤一样
            copy(REDUCE_CAPACITY_FACTOR, false);
        }
    }

    private void copy(double capacity, boolean inOrDe) {
        //1、计算改变之后的容量
        int newLength = (int) (length * capacity);

        //3、创建新数组
        MyNode<Key, Value>[] newArray = new MyNode[newLength];
            /*4、进行一个数组的迁移，
            查看源码API：
            public static native void arraycopy(
                        Object src原数组,
                        int  srcPos原数组起始位置,
                        Object dest目标数组,
                        int destPos目标数组的起始位置,
                        int length要复制的长度
             );
             */
        if (inOrDe) {
            System.arraycopy(array, 0, newArray, 0, length);
        } else {
            //这里注意要填充数组！！！因为删除的可能会是中间的，缩小转移的大小是size而不是length
            fillArray();
            //填充之后再copy
            System.arraycopy(array, 0, newArray, 0, size());
        }
        //5、抛弃旧数组，使用新数组
        array = newArray;
        //2、更改大小属性
        length = newLength;
    }

    /**
     * 填充数组，即有空位就向前补
     */
    protected void fillArray(){
        //j是为了判断是否填充完毕，填充计数用的
        for (int i = 0,j = 0; i < length; i++) {
            //填充完毕
            if (j == size())
                break;
            //如果此数组单元是空，就得拿后面的补位
            if (array[i] == null) {
                //如果后一个也是空那就得遍历了
                if (array[i + 1] == null && j < size()){
                    for (int k = i+2; k<array.length ;k++){
                        //遍历到位置赋值
                        if (array[k] != null){
                            array[i] = array[k];
                            //赋值之后清空
                            array[k] = null;
                            //记得增加填充次数
                            j++;
                            break;
                        }
                    }
                }else {
                    //如果后一个不是空，那就直接用后一个的
                    array[i] = array[i + 1];
                    if (array[i + 1] != null)
                        array[i + 1] = null;
                    j++;
                }
            }else {
                //数组单元本身就有值就不用管，增加填充次数即可
                j++;
            }
        }
    }
}

