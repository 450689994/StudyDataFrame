package huawei;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _12_多线程_2 implements Runnable {
    private static volatile StringBuffer stringBuffer;
    private static volatile int i;
    private static volatile int num = 0;
    private static ExecutorService service = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int a = sc.nextInt();
            if (a == 0)
                continue;
            num = a * 4;
            _12_多线程_2 task = new _12_多线程_2();
            service = Executors.newFixedThreadPool(4);
            service.submit(task);
        }
    }

    @Override
    public void run() {
        while (stringBuffer == null || stringBuffer.length() != num) {
            synchronized (this) {
                //如果是空
                if (stringBuffer == null){
                    stringBuffer = new StringBuffer();
                    stringBuffer.append("A");
                }else {
                    switch (stringBuffer.charAt(i)){
                        case 'A': stringBuffer.append("B");break;
                        case 'B': stringBuffer.append("C");break;
                        case 'C': stringBuffer.append("D");break;
                        case 'D': stringBuffer.append("A");break;
                    }
                    i++;
                }
            }
        }
        service.shutdownNow();
        System.out.println(stringBuffer);
        stringBuffer = null;
        i = 0;
    }
}