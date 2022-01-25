package huawei;

import java.util.Scanner;

public class _11_坐标移动 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] split = str.split(";");
        int x = 0, y = 0;

        for (String s : split) {
            if (s.equals("")) {
                continue;
            }
            if (s.matches("[ASDW]{1}[-]?[0-9]*")) {
                switch (s.charAt(0)) {
                    case 'W':
                        y = y + Integer.parseInt(s.substring(1));
                        break;
                    case 'S':
                        y = y - Integer.parseInt(s.substring(1));
                        break;
                    case 'A':
                        x = x - Integer.parseInt(s.substring(1));
                        break;
                    case 'D':
                        x = x + Integer.parseInt(s.substring(1));
                        break;
                }
            }
        }
        System.out.println(x+","+y);
    }
}
