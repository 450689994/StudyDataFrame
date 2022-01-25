package leecode.leetcode;

/**
 * 1-14
 */
public class _3_罗马数字转整数 {
    public static int romanToInt(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i+1 < s.length() && getValue(s.charAt(i)) < getValue(s.charAt(i + 1))) {
                sum = sum + (getValue(s.charAt(i + 1)) - getValue(s.charAt(i)));
                i++;
            } else {
                sum = sum + getValue(s.charAt(i));
            }
        }
        return sum;
    }

    private static Integer getValue(Character key){
        switch (key){
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
            default:return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
    }
}
