package symbolTable.abs;

import symbolTable.api.SymbolTable;

public abstract class AbstractSymbolTable<Key,Value> implements SymbolTable<Key,Value> {
    //键值对的数量
    private int size;
    //节点MyNode（不支持排序的非树结构）
    protected class MyNode<Key,Value> implements SymbolTable.MyEntry{
        protected Key key;
        protected Value value;
        protected MyNode<Key,Value> next;

        public MyNode(Key key, Value value, MyNode<Key, Value> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        //为了sort排序才set，但是只有无需的容器才支持
        public void setKey(Key key) {
            this.key = key;
        }

        @Override
        public Key getKey() {
            return key;
        }

        @Override
        public Value getValue() {
            return value;
        }

        @Override
        public void setValue(Object o) {
            value = (Value) o;
        }

        public MyNode<Key, Value> getNext() {
            return next;
        }

        public void setNext(MyNode<Key, Value> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "MyNode{" +
                    "key=" + key +
                    ", value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    //节点OrderedMyNode继承于MyNode（支持排序因为泛型Key是Comparable的子类，非树结构）
    protected class OrderedMyNode<Key extends Comparable<Key>,Value> extends MyNode<Key,Value>{
        public OrderedMyNode(Key key, Value value, MyNode<Key, Value> next) {
            super(key, value, next);
        }

        @Override
        public Key getKey() {
            return key;
        }

        @Override
        public Value getValue() {
            return value;
        }

        @Override
        public void setValue(Object o) {
            value = (Value) o;
        }

        public OrderedMyNode<Key, Value> getNext() {
            return (OrderedMyNode)next;
        }

        public void setNext(OrderedMyNode<Key, Value> next) {
            super.next = next;
        }
    }

    //因为是树节点，所以key一定是实现Comparable的
    protected class TreeNode<Key extends Comparable<Key>,Value> implements SymbolTable.MyEntry<Key,Value> {
        protected Key key;
        protected Value value;
        protected TreeNode<Key, Value> left,right;  //左右节点
        protected int N;    //该节点为根的子树中的节点总数（包括自己）

        public TreeNode(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            N = n;
        }

        @Override
        public Key getKey() {
            return key;
        }

        @Override
        public Value getValue() {
            return value;
        }

        @Override
        public void setValue(Object o) {
            this.value = (Value) o;
        }

        public TreeNode<Key, Value> getLeft() {
            return left;
        }

        public void setLeft(TreeNode<Key, Value> left) {
            this.left = left;
        }

        public TreeNode<Key, Value> getRight() {
            return right;
        }

        public void setRight(TreeNode<Key, Value> right) {
            this.right = right;
        }

        public int getN() {
            return N;
        }

        public void setN(int n) {
            N = n;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "key=" + key +
                    ", value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    ", N=" + N +
                    '}';
        }
    }

    //删除
    @Override
    public void delete(Key key) {
        put(key,null);
    }

    //返回键值对的数量
    @Override
    public int size() {
        return size;
    }
    //设置键值对的数量
    protected void setSize(int size) {
        this.size = size;
    }

}
