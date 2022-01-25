package 剑指offer;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * 限制：
 *
 * 0 <= s 的长度 <= 10000
 *
 */
public class _05替换空格_2 {
    public String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0;i<s.length();i++){
            if (s.charAt(i) == ' '){
                stringBuilder.append("%20");
            }else {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        _05替换空格_2 test = new _05替换空格_2();
        String s = test.replaceSpace("We are happy.");
        System.out.println(s);
    }
}
