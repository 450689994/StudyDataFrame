package symbolTable.test.array;

import symbolTable.implementation.array.UnorderedArraySymbolTable;

import java.util.Iterator;

public class UnorderedArraySymbolTableTest {
    public static void main(String[] args) {
        UnorderedArraySymbolTable<String, String> st = new UnorderedArraySymbolTable<>();
        st.put("1","1");
        st.put("2","2");
        st.put("3","3");
        st.put("4","");
        st.put("5","");
        st.put("6","");
        st.put("7","");
        st.put("8","");
        st.put("9","");
        st.put("10","");
        st.put("11","");
        st.put("4",null);
        st.put("1",null);
        st.put("2",null);
        st.put("3",null);
        st.put("5",null);
        st.put("6",null);
//        st.put("3",null);
//        st.put("5",null);

        Iterator<String> iterator = st.keySet();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
