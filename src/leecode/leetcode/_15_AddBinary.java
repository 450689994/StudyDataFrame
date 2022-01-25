package leecode.leetcode;

/**
 * 1-18
 */
public class _15_AddBinary {
    public static String addBinary(String a, String b) {
        //取最长，翻转补零
        if(a.length()>b.length()){
            StringBuilder reverse = new StringBuilder(b).reverse();
            for (int i = 0; i < a.length()-b.length(); i++) {
                reverse.append("0");
            }
            b = reverse.reverse().toString();
        }else {
            StringBuilder reverse = new StringBuilder(a).reverse();
            for (int i = 0; i < b.length()-a.length(); i++) {
                reverse.append("0");
            }
            a = reverse.reverse().toString();
        }

        int ans = 0;
        char[] _a = a.toCharArray();
        char[] _b = b.toCharArray();
        for (int i = _a.length-1; i >= 0; i--) {
            int num_a = _a[i] - 48;
            int num_b = _b[i] - 48;
            if(num_a + num_b + ans == 2){
                _a[i] = 0 + 48;
                ans = 1;
            }else if(num_a + num_b + ans == 3){
                _a[i] = 1 + 48;
                ans = 1;
            }else{
                _a[i] = (char) (num_a + num_b + ans + 48);
                if(ans != 0)
                    ans -- ;
            }
        }

        if(ans != 0){
            return "1"+ new String(_a);
        }else {
            return new String(_a);
        }
    }

    public static void main(String[] args) {
        System.out.println(addBinary("",""));
    }
}
