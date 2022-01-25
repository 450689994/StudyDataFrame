package 剑指offer;

import java.util.*;

public class Test {
    public static Integer[] generRandom(int range,int count){
        Set<Integer> set = new HashSet<>();
        int i = 0;
        while (set.size() != count) {
            i = new Random().nextInt(range) + 1;
            set.add(i);
        }
        Integer[] arr = new Integer[count];
        Integer[] integers = set.toArray(arr);
        return integers;
    }
    public static void main(String[] args) {
        Integer[] ints = generRandom(33, 6);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
