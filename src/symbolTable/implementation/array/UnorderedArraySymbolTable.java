package symbolTable.implementation.array;

import symbolTable.implementation.array.abs.AbstractArraySymbolTable;

/**
 * 无序顺序（数组）符号表
 *
 * @param <Key>
 * @param <Value>
 */
public class UnorderedArraySymbolTable<Key, Value> extends AbstractArraySymbolTable<Key, Value> {

    /**
     * 无序只能挨个遍历
     *
     * @param key
     * @return
     */
    @Override
    public boolean contains(Key key) {
        //直接调get方法，防止代码冗余
        return get(key) == null ? false : true;
    }

    /**
     * 因为无序，所以只能遍历
     *
     * @param key
     * @return
     */
    @Override
    public Value get(Key key) {
        for (int i = 0; i < size(); i++) {
            if (array[i].getKey().equals(key))
                return array[i].getValue();
        }
        return null;
    }
}
