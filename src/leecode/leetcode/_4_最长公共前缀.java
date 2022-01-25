package leecode.leetcode;

/**
 * 1-14
 */
public class _4_最长公共前缀 {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        String ans = strs[0];
        for(int i =1;i<strs.length;i++) {
            int j=0;
            for(;j<ans.length() && j < strs[i].length();j++) {
                if(ans.charAt(j) != strs[i].charAt(j))
                    break;
            }
            ans = ans.substring(0, j);
            if(ans.equals(""))
                return ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }
}


/*
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder("");
        for (int i = 0, j = 0; i < strs.length; i++) {
            if(j == strs[i].length()){
                break;
            }
            char temp = strs[0].charAt(j);
            char c = strs[i].charAt(j);
            if (c == temp) {
                if (i == strs.length - 1) {
                    i = -1;
                    j++;
                    result.append(c);
                }
            }else {
                break;
            }
        }
        return result.toString();
    }
 */