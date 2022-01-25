package huawei;

import java.util.*;

public class _13_字符统计_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            TreeMap<Character,Integer> map = new TreeMap<>();
            for (int i = 0; i < str.length(); i++) {
                if (map.containsKey(str.charAt(i))) {
                    map.put(str.charAt(i),map.get(str.charAt(i))+1);
                }else {
                    map.put(str.charAt(i),1);
                }
            }
            Set<Map.Entry<Character, Integer>> entries = map.entrySet();
            ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
            Collections.sort(list,(x,y)-> y.getValue()-x.getValue());
            for (Map.Entry<Character, Integer> element : list) {
                System.out.print(element.getKey());
            }
            System.out.println();
        }
    }
}
