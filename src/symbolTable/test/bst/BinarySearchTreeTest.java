package symbolTable.test.bst;

import symbolTable.implementation.bst.BinarySearchTree;

public class BinarySearchTreeTest {
    public static void main(String[] args) {
        BinarySearchTree<Integer,Integer> st = new BinarySearchTree();
//        st.put(1,111);
//        st.put(2,222);
//        st.put(2,000);
//        st.put(3,333);

        st.put(4,444);
        st.put(2,222);
        st.put(1,111);
        st.put(3,333);
        st.put(6,666);
        st.put(5,555);
        st.put(7,777);
        System.out.println(st.floor(5));

    }
}
