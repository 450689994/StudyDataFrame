package symbolTable.implementation.bst;

import symbolTable.abs.AbstractSymbolTable;
import symbolTable.api.OrderedCanDo;
import symbolTable.exception.NullKeyException;

import java.util.Iterator;

public class BinarySearchTree<Key extends Comparable<Key>, Value> extends AbstractSymbolTable<Key, Value> implements OrderedCanDo<Key, Value> {
    private TreeNode<Key, Value> rootNode;      //总根节点

    @Override
    public void put(Key key, Value value) {
        //异常判断
        if (key == null)
            throw new NullKeyException();
        //开始递归
        rootNode = put(rootNode, key, value);
    }

    private TreeNode<Key, Value> put(TreeNode<Key, Value> treeNode, Key key, Value value) {
        //如果根节点是空
        if (treeNode == null)
            return new TreeNode(key, value, 1);
        //根节点不是空就要开始比较了
        int i = treeNode.getKey().compareTo(key); //> = < 0
        //比根节点大
        if (i < 0) treeNode.setRight(put(treeNode.getRight(), key, value));
            //比根节点小
        else if (i > 0) treeNode.setLeft(put(treeNode.getLeft(), key, value));
            //相等
        else {
            //删除
            if (value == null) {
                //！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
            }
            treeNode.setValue(value);
        }
        treeNode.setN(size(treeNode.getLeft()) + size(treeNode.getRight()) + 1);
        return treeNode;
    }

    @Override
    public Value get(Key key) {
        if (key == null)
            throw new NullKeyException();
        return get(rootNode, key);
    }

    private Value get(TreeNode<Key, Value> treeNode, Key key) {
        //如果再往下没有节点了
        if (treeNode == null) return null;
        int i = treeNode.getKey().compareTo(key);
        if (i > 0) return get(treeNode.getLeft(), key);
        else if (i < 0) return get(treeNode.getRight(), key);
        else return treeNode.getValue();
    }

    @Override
    public int size() {
        return size(rootNode);
    }

    private int size(TreeNode<Key, Value> treeNode) {
        return treeNode == null ? 0 : treeNode.getN();
    }

    @Override
    public boolean contains(Key key) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return rootNode == null;
    }

    @Override
    public Iterator<Key> keySet() {
        return new Iterator<Key>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Key next() {

                return null;
            }
        };
    }

    @Override
    public Key min() {
        return min(rootNode);
    }

    private Key min(TreeNode<Key, Value> treeNode) {
        if (treeNode.getLeft() == null) return treeNode.getKey();
        return min(treeNode.getLeft());
    }

    @Override
    public Key max() {
        return max(rootNode);
    }

    private Key max(TreeNode<Key, Value> treeNode) {
        if (treeNode.getRight() == null) return treeNode.getKey();
        return max(treeNode.getRight());
    }

    @Override
    public Key floor(Key key) {
        if (key == null)
            throw new NullKeyException();
        return floor(rootNode, key);
    }

    private Key floor(TreeNode<Key, Value> treeNode, Key key) {
        if (treeNode == null) return null;
        int i = treeNode.getKey().compareTo(key);
        if (i == 0) return treeNode.getKey();
        if (i > 0) return floor(treeNode.getLeft(), key);
        Key right = floor(treeNode.getRight(), key);
        if (right != null) return right;
        else return treeNode.getKey();
    }

    @Override
    public Key celling(Key key) {
        if (key == null)
            throw new NullKeyException();
        return celling(rootNode, key);
    }

    private Key celling(TreeNode<Key, Value> treeNode, Key key) {
        if (treeNode == null) return null;
        int i = treeNode.getKey().compareTo(key);
        if (i < 0) return celling(treeNode.getRight(), key);
        else if (i > 0) return celling(treeNode.getLeft(), key);
        else {
            //它下面都没有节点了，就直接null了
            if (treeNode.getRight() == null)
                return null;
            return min(treeNode.getRight());
        }
    }

    @Override
    public int rank(Key key) {
        if (key == null)
            throw new NullKeyException();
        return rank(rootNode, key);
    }

    private int rank(TreeNode<Key, Value> treeNode, Key key) {
        if (treeNode == null) return 0;
        int i = treeNode.getKey().compareTo(key);
        if (i < 0) return rank(treeNode.getRight(), key) + size(treeNode.getLeft()) + 1;
        else if (i > 0) return rank(treeNode.getLeft(), key);
        return treeNode.getLeft() != null ? size(treeNode.getLeft()) : 0;
    }

    @Override
    public Key select(int k) {
        return select(rootNode, k);
    }

    private Key select(TreeNode<Key, Value> treeNode, int k) {
        if (treeNode == null) return null;
        int t = k % 2 == 0 ? size(treeNode.getLeft()) + 1 : size(treeNode.getLeft());
        if (t < k)
            return select(treeNode.getRight(), k - t - 1);
        else if (t > k)
            return select(treeNode.getLeft(), k);
        else
            return treeNode.getKey();
    }

    @Override
    public void deleteMin() {

    }

    @Override
    public void deleteMax() {

    }

    @Override
    public int size(Key k1, Key k2) {
        return 0;
    }

    @Override
    public Iterator<Key> keySet(Key k1, Key k2) {
        return null;
    }
}
