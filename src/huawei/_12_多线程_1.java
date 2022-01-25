package huawei;

import java.util.Scanner;

public class _12_多线程_1 implements Runnable {
    private static StringBuffer stringBuffer;
    private static int i;
    private static int num = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        num = a * 4;
        _12_多线程_1 thread = new _12_多线程_1();
        new Thread(thread, "A").start();
        new Thread(thread, "B").start();
        new Thread(thread, "C").start();
        new Thread(thread, "D").start();
    }

    @Override
    public void run() {
        while (true) {
            switch (Thread.currentThread().getName()) {
                case "A":
                    while (!cas('D', 'A')) {
                    }
                    break;
                case "B":
                    while (!cas('A', 'B')) {
                    }
                    break;
                case "C":
                    while (!cas('B', 'C')) {
                    }
                    break;
                case "D":
                    while (!cas('C', 'D')) {
                    }
                    break;
            }
        }
    }

    private synchronized boolean cas(char want, char add) {
        if (stringBuffer != null && stringBuffer.length() == num) {
            System.out.println(stringBuffer);
            stringBuffer = null;
            System.exit(0);
        }
        if (stringBuffer == null) {
            stringBuffer = new StringBuffer();
            stringBuffer.append("A");
            i = 0;
            return true;
        }
        if (stringBuffer != null && stringBuffer.charAt(i) == want) {
            stringBuffer.append(add);
            i++;
            return true;
        }
        return false;
    }
}