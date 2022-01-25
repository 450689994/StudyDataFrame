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
public class _05替换空格_1 {
    public String replaceSpace(String s) {
        String replace = s.replace(" ", "%");
        return replace;
    }

    public static void main(String[] args) {
        _05替换空格_1 test = new _05替换空格_1();
        String s = test.replaceSpace("We are happy.");
        System.out.println(s);
    }
}

/**
 * String 不可变是弊端，但是真的方便，字符串长了就不好了
 */