package symbolTable.test.array;

import symbolTable.abs.AbstractSymbolTable;
import symbolTable.implementation.array.OrderedArraySymbolTable;
import symbolTable.implementation.array.UnorderedArraySymbolTable;

import java.util.Iterator;

public class OrderedArraySymbolTableTest {
    public static void main(String[] args) {
        OrderedArraySymbolTable<String, String> st = new OrderedArraySymbolTable<>();
        st.put("5","555");
        st.put("2","222");
        st.put("1","111");
        st.put("8","888");
        st.put("6","666");
        st.put("4","444");
        st.put("3","333");
        st.put("7","777");


//        System.out.println(st.get("2"));
//        System.out.println(st.get("3"));
//        System.out.println(st.get("4"));
////        System.out.println(st.get("5"));
//        System.out.println(st.get("6"));
//        System.out.println(st.get("8"));

//        st.deleteMax();
//        st.deleteMax();


//        st.deleteMin();
//        st.deleteMin();

//        System.out.println(st.select(11));

//        System.out.println(st.rank("2"));

//        System.out.println(st.celling("-3"));

        System.out.println(st.floor("342342342"));

//        Iterator<String> iterator = st.keySet();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
//        System.out.println(st.size("6","9"));
    }
}
