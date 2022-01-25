package exam;

import java.io.File;
import java.io.FileInputStream;

public class 遍历文件目录 {
  public static void main(String[] args) {
    File file = new File("D:\\test\\src");
    String[] list = file.list();
    for (String s : list) {
      if (".jpg".equals(s.substring(s.length()-4))) {
        System.out.println(s);
      }
    }
  }
}
