import java.util.Date;

public class Test {

  public static void main(String[] args) throws InterruptedException {
    System.out.println(new Date());
    sleep(10000);
    System.out.println(new Date());
  }

  public static void sleep(long time) throws InterruptedException {
    Object obj = new Object();
    long startTime = System.currentTimeMillis();
    while (System.currentTimeMillis() - startTime < time) {
      obj.wait(1);
    }
  }

}

