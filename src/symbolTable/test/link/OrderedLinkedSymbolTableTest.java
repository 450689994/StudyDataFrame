package symbolTable.test.link;

import symbolTable.pojo.Student;
import symbolTable.implementation.link.OrderedLinkedSymbolTable;

public class OrderedLinkedSymbolTableTest{
    public static void main(String[] args) {
        OrderedLinkedSymbolTable<Student,String> st = new OrderedLinkedSymbolTable();
        Student s1 = new Student(1, "");
        Student s2 = new Student(2, "");
        Student s3 = new Student(3, "");
        Student s4 = new Student(4, "");
        Student s5 = new Student(5, "");
        Student s6 = new Student(6, "");
        st.put(s1,"");
        st.put(s2,"");
        st.put(s3,"");
        st.put(s4,"");
        st.put(s5,"222");
        st.put(s6,"");
        st.delete(s4);
        System.out.println(st.rank(s2));
    }
}
