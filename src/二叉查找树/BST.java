package 二叉查找树;

import java.util.Iterator;

/**
 * 有序二叉树 要实现Comparable 要进行比较
 */
public class BST <Key extends Comparable<Key>,Value> implements IBST<Key,Value>{
    private Node root;  //根节点

    /**
     * 节点数据类型
     */
    private class Node{
        private Key key;
        private Value value;
        private Node left,right;    //左右节点
        private int N;              //以该节点为根的子树中的节点总数
    }

    @Override
    public void put(Key key, Value value) {

    }

    @Override
    public Value get(Key key) {

        return null;
    }

    @Override
    public void delete(Key key) {

    }

    @Override
    public boolean contains(Key key) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node x){
        if (x == null) return 0;
        return x.N;
    }

    @Override
    public Key min() {
        return null;
    }

    @Override
    public Key max() {
        return null;
    }

    @Override
    public Key floor(Key key) {
        return null;
    }

    @Override
    public Key celling(Key key) {
        return null;
    }

    @Override
    public int rank(Key key) {
        return 0;
    }

    @Override
    public Key select(int k) {
        return null;
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
    public Iterator keys(Key k1, Key k2) {
        return null;
    }

    @Override
    public Iterator keys() {
        return null;
    }

}
