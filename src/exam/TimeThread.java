package exam;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeThread {
  private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
  public static void main(String[] args) {
    new Thread(
            () -> {
              while (true) {
                System.out.println(simpleDateFormat.format(new Date()));
                  try {
                      Thread.sleep(1000);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
              }
            })
        .start();
  }
}
