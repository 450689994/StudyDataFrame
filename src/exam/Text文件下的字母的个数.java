package exam;

import com.sun.org.apache.xpath.internal.axes.MatchPatternIterator;

import java.io.*;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text文件下的字母的个数 {
  public static void main(String args[]) throws IOException {
    DataInputStream in = new DataInputStream(new FileInputStream("D:\\test\\src\\a.txt"));
    BufferedReader d = new BufferedReader(new InputStreamReader(in));
    CharSequence input;
    String str;
    String regex = "[a-zA-Z]";
    int count = 0;
    while ((str = d.readLine()) != null) {
      Matcher matcher = Pattern.compile(regex).matcher(str);
      while (matcher.find()) {
        count++;
      }
    }
    System.out.println(count);
    d.close();
    in.close();
  }
}
