package symbolTable.test.link;

import symbolTable.implementation.link.UnorderedLinkedSymbolTable;

import java.util.Comparator;
import java.util.Iterator;

public class UnorderedLinkedSymbolTableTest {
    public static void main(String[] args) {
        UnorderedLinkedSymbolTable<Integer,String> st = new UnorderedLinkedSymbolTable();
        st.put(2,"1");
        st.put(1,"1");
        st.put(3,"1");
        System.out.println("排序前：");
        Iterator<Integer> iterator = st.keySet();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        st.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        System.out.println("排序后：");
        Iterator<Integer> iterator1 = st.keySet();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
    }
}
